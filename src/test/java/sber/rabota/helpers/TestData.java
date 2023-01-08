package sber.rabota.helpers;

import com.github.javafaker.Faker;

import java.util.List;

public class TestData {
    Faker faker = new Faker();
    public String region = "г Санкт-Петербург",
            regionForSearch = "Санкт-Петербург",
            attribute = "innerText",
            menuElement = "Вакансии",
            validVacansy = "QA automation",
            negativeSearchResult = "Ничего не нашлось",
            positiveSearchResult = "Найдено вакансий",
            vacanciesUrl = "search/4103204/";
    public int logoCount = 2,
            menuElementsCount = 3;
    public static List<String> menuElements =
            List.of("Вакансии", "Карьерные медиа", "Выпускникам и студентам");

    public static List<String> errorTexts =
            List.of("Обязательное поле ", "Обязательное поле ", "Проверьте адрес", "Это не похоже на номер телефона");

    //public String invalidVacansy = RandomUtils.randomString(10);

    public String lastName = faker.name().lastName(),
            firstName = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            fileName = "Резюме.pdf";


}