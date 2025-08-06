package vn.chuot96.authservice.compo;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.dto.RequestDTO;
import vn.chuot96.authservice.service.ForwardService;

@Aspect
@Component
@RequiredArgsConstructor
public class BeforeImplementAspect {
    private final ForwardService forwardService;

    @Around("@annotation(vn.chuot96.anno.BeforeImplement) || within(@vn.chuot96.anno.BeforeImplement *)")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        RequestDTO request = (RequestDTO) args[0];
        Mono<?> forwardMono = forwardService.forwardRCache(request);
        return forwardMono.then(Mono.defer(() -> {
            try {
                return (Mono<?>) joinPoint.proceed();
            } catch (Throwable e) {
                return Mono.error(e);
            }
        }));
    }
}
