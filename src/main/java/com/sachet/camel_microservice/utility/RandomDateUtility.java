package com.sachet.camel_microservice.utility;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class RandomDateUtility {

    public String nextDate() {
        long minDate = LocalDate.of(1900, 1, 1).toEpochDay();
        long maxDate = LocalDate.of(2024, 8, 19).toEpochDay();
        Random random = new Random();
        long randomDay = minDate + random.nextLong(maxDate - minDate);
        return "Sending the message at "+LocalDate.ofEpochDay(randomDay);
    }
}
