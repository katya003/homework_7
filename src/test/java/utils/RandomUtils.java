package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String gerDayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String getMonthBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, 2024));
    }

    public String getSubjectsOne() {
        return faker.options().option("History", "Maths");
    }

    public String getHobbiesOne() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }

    public String getCity(String state) {
        if ("NCR".equals(state)) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(state)) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if ("Haryana".equals(state)) {
            return faker.options().option("Karnal", "Panipat");
        } else {
            return "";
        }
    }
}
