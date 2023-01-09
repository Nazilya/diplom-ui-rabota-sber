# Проект по автоматизации тестирования
<a target="_blank" href="https://rabota.sber.ru/">Веб сайт Работа в Сбере</a>

<p align="center">
<img title="Allure Graphics" src="images/screens/sberRabota.png">
</p>

## :maple_leaf: Содержание:

- [Технологии и инструменты](#earth_africa-технологии-и-инструменты)
- [Реализованные проверки](#earth_africa-Реализованные-проверки)
- [Сборка в Jenkins](#earth_africa-Jenkins-job)
- [Запуск из терминала](#earth_africa-Запуск-тестов-из-терминала)
- [Allure отчет](#earth_africa-Allure-отчет)
- [Отчет в Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#earth_africa-Примеры-видео-о-прохождении-тестов)

## :maple_leaf:Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :maple_leaf: Список проверок, реализованных в автотестах

✓ Проверка кликабельности элементов меню на главной станице
✓ Поиск вакансии QA Automation
✓ Поиск вакансий (параметризованные тесты)
✓ Поиск вакансии с использованием фильтров
✓ Заполнение формы для отклика на вакансию

## :maple_leaf: Запуск тестов

### :maple_leaf: Локальный запуск :
```
gradle clean test
```

### :maple_leaf: Удаленный запуск:
```
clean
ui_tests
-Dbase_url=${BASE_URL}
-DremoteUrl=${REMOTE_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
```

### <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Запуск через  <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-NazilyaMullagildina_UI-tests/"> Jenkins </a>

### :maple_leaf: Параметры сборки в Jenkins:

- запуск тестов с тегом ui_tests (по умолчанию)
- browser (браузер, по умолчанию chrome)
- version (версия браузера, по умолчанию 100.0)
- size (размер окна браузера, по умолчанию 1920x1080)
- remoteUrl (логин, пароль и адрес удаленного сервера selenoid)
- BASE_URL (https://rabota.sber.ru/ - по умолчанию)

<p align="center">
<a href="https://jenkins.autotests.cloud/job/C16-NazilyaMullagildina_UI-tests/"><img src="images/screens/Jenkins1.png" alt="Jenkins"/></a>
</p>

<p align="center">
<a href="https://jenkins.autotests.cloud/job/10_DikayaAV_diploma/"><img src="images/screens/Jenkins2.png" alt="Jenkins"/></a>
</p>



## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/10_DikayaAV_diploma/allure/">Allure report</a>

### :maple_leaf: Главное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Allure_Report1.png">
</p>

### :maple_leaf: Тесты

<p align="center">
<img title="Allure Tests" src="images/screens/Allure_Report2.png">
</p>

### :maple_leaf: Графики

<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_Report3.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Настроено автоматическое оповещение о результатах прогона тестов в Telegram-бот

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/telegramNotif.png" >
</p>


## <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Allure"/></a> Видео прохождения теста

<p align="center">
<img title="Selenoid Video" src="images/video/videoUItests.mp4" width="250" height="153"  alt="video"> 
</p>
