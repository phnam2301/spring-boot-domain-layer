package vn.chuot96.authservicetbirpg2d.dto;

import java.util.List;

public record UserDTO(String provider, String subject, String scope, List<String> audience) {}
