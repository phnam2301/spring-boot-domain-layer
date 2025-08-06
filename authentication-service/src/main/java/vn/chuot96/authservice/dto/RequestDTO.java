package vn.chuot96.authservice.dto;

public record RequestDTO(String provider, String subject, String objectCode // Acc Credential or App Code
        ) {}
