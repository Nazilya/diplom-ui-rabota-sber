package sber.rabota.helpers;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.Locale;

public class TestData {
    Faker fakerEn = new Faker();
    Faker fakerRU = new Faker(new Locale("ru"));
    public static String region = "г Санкт-Петербург",
            regionForSearch = "Санкт-Петербург",
            attribute = "innerText",
            menuElement = "Вакансии",
            vacanciesUrl = "search/4138526/";
    public static int logoCount = 2,
            menuElementsCount = 3;
    public static List<String> menuElements =
            List.of("Вакансии", "Карьерные медиа", "Выпускникам и студентам");

    public static List<String> errorTexts =
            List.of("Обязательное поле ", "Обязательное поле ", "Проверьте адрес", "Это не похоже на номер телефона");

    public String lastName = fakerRU.name().lastName(),
            firstName = fakerRU.name().firstName(),
            email = fakerEn.internet().emailAddress(),
            phone = fakerRU.phoneNumber().subscriberNumber(10),
            fileName = "files/Rezume.docx";

    public static String vacancies = "Вакансии",
            vacanciesPageTitle = "Поиск вакансий",
            carier = "Карьерные медиа",
            cariersPageTitle = "Работа в Сбере: Карьерные медиа",
            graduate = "Выпускникам и студентам",
            graduatesPageTitle = "SberGraduate - Твори будущее со Сбером",
            attributeTitle = "textContent";
}
