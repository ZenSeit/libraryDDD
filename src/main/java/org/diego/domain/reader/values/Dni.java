package org.diego.domain.reader.values;

import org.diego.generic.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dni implements ValueObject<String> {

    private String dni;

    public Dni(String dni) {

        Pattern pattern = Pattern.compile("^[0-9]{9,10}$");

        Matcher matcher = pattern.matcher(dni);

        if(matcher.matches()){
            this.dni = dni;
        }else{
            throw new IllegalArgumentException("Your dni should have only numbers and length between 9 to 10 characters");
        }


    }

    @Override
    public String value() {
        return dni;
    }
}
