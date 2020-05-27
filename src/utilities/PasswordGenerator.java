package utilities;

import java.util.UUID;

public class PasswordGenerator {
    public static String passGenerator() {
        return UUID.randomUUID().toString().substring(0, 7);
    }
}
