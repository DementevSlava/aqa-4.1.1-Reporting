package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private LocalDate today = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Faker faker = new Faker(new Locale("ru"));

    public String nameByCard() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public String forwardDate(int pluDays){
        LocalDate newDate = today.plusDays(pluDays);
        return formatter.format(newDate);
    }

    public String getRandomCity() {
        String[] cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул",
                "Владикавказ", "Горно-Алтайск", "Йошкар-Ола", "Казань", "Калининград", "Калуга",
                "Краснодар", "Магадан", "Магас", "Махачкала", "Нарьян-Мар", "Салехард", "Самара",
                "Саранск", "Саратов", "Хабаровск", "Ханты-Мансийск", "Южно-Сахалинск", "Великий Новгород",
                "Владивосток", "Владимир", "Вологда", "Рязань", "Биробиджан", "Чебоксары",
                "Москва", "Санкт-Петербург", "Ульяновск", "Симферополь", "Ростов-на-Дону"};
        Random random = new Random();
        int i = random.nextInt(cities.length);
        return (cities[i]);
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }
}
