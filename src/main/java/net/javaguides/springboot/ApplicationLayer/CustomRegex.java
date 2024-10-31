package net.javaguides.springboot.ApplicationLayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegex {
    private String value;
    private String regex;
    Pattern pattern; // = Pattern.compile(regex);
    Matcher matcher; // = ;

    public CustomRegex(
            String value,
            String regex) {
        this.value = value;
        this.regex = regex;
    }

    public boolean valid() {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        
        return matcher.matches();
    }
}
