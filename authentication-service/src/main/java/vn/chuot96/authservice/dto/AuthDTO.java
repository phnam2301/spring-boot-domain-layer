package vn.chuot96.authservice.dto;

import java.util.List;
import vn.chuot96.authservice.component.DatabaseParam;

public record AuthDTO(DatabaseParam database, String query, List<Object> params) {}
