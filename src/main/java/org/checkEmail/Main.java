package org.checkEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean checkEmail(String text) {
        String pattern = "[a-zA-Z]\\w+(\\.\\w+)*@(\\w+\\.)+\\w{2,}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}