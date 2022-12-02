package org.example;

public class MyStringUtils {

    public static boolean isBlank(String nullString) {

        if (nullString == null) {
            return true;
        } else if (  nullString.isEmpty() ) {
            return true;
        } else if ( nullString.isBlank()) {
            return true;
        }

        return false;
    }

}
