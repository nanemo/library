package com.nanemo.util;

import com.nanemo.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class DateValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        System.out.println("|" + person.getBirthday() + "|");
        String birthday = person.getBirthday().trim();
        System.out.println(birthday.length());
        System.out.println("|" + person.getBirthday().trim() + "|");

        if (birthday.isBlank() || birthday.isEmpty()) {
            errors.rejectValue("birthday", "", "Year of date can not be empty");
        } else if (Integer.parseInt(birthday) >= LocalDate.now().getYear()) {
            errors.rejectValue("birthday", "", "Added year cannot be higher than the current year");
        } else if (Integer.parseInt(birthday) < 0) {
            errors.rejectValue("birthday", "", "Added year cannot be negative");
        }

    }

}
