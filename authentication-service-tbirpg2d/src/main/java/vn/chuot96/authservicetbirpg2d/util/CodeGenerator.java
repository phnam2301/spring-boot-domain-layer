package vn.chuot96.authservicetbirpg2d.util;

import java.util.UUID;

public class CodeGenerator {
    public static String generate() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .replaceAll("[^A-Za-z0-9]", "")
                .substring(0, 8)
                .toUpperCase();
    }
}
