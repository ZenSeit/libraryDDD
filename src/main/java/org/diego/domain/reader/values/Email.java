package org.diego.domain.reader.values;

import org.diego.generic.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements ValueObject<String> {

    private String email;

    public Email(String email) {

        Pattern pattern = Pattern.compile("^[a-z0-9]+(?:[._][a-z0-9]+)*@(?:\\w+\\.)+\\w{2,5}$");

        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Type a valid email");
        }

    }

    @Override
    public String value() {
        return email;
    }
}
