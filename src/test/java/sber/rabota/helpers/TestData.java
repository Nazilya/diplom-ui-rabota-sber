package sber.rabota.helpers;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;

public class TestData {
    //    Faker faker = new Faker();
    Faker faker = new Faker(new Locale("ru"));
    public String region = "г Санкт-Петербург",
            regionForSearch = "Санкт-Петербург",
            attribute = "innerText",
            menuElement = "Вакансии",
            vacanciesUrl = "search/4138526/";
    public int logoCount = 2,
            menuElementsCount = 3;
    public static List<String> menuElements =
            List.of("Вакансии", "Карьерные медиа", "Выпускникам и студентам");

    public static List<String> errorTexts =
            List.of("Обязательное поле ", "Обязательное поле ", "Проверьте адрес", "Это не похоже на номер телефона");

    public String lastName = faker.name().lastName(),
            firstName = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            fileName = "files/Rezume.docx";

    public String vacancies = "Вакансии",
            vacanciesPageTitle = "Поиск вакансий",
            carier = "Карьерные медиа",
            cariersPageTitle = "Работа в Сбере: Карьерные медиа",
            graduate = "Выпускникам и студентам",
            graduatesPageTitle = "SberGraduate - Твори будущее со Сбером",
            attributeTitle = "textContent";

}
