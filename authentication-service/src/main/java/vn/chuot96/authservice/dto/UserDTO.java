package vn.chuot96.authservice.dto;

import java.util.List;

public record UserDTO(String provider, String subject, String scope, List<String> audience) {}
