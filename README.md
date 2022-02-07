# Проект автотестов на [hh.ru](https://hh.ru/)

---
## Реализованы проверки:
- Проверка наличия корректного промо-текста на главной странице
- Проверка наличия результатов поиска по профессии
- Проверка наличия результатов расширенного поиска
- Проверка перехода на страницу для работодателей при нажатии кнопки в панели навигации
- Проверка перехода на страницу для работодателей при нажатии 'Я ищу сотрудника'

---
## Стек технологий:
![](img/Intelij_IDEA.png "IntelliJ IDEA")
![](img/Java.png "Java")
![](img/Gradle.png "Gradle")
![](img/JUnit5.png "JUnit5")
![](img/Appium.png "Appium")
![](img/Selenide.png "Selenide")
![](img/Selenoid.png "Selenoid")
![](img/Allure_Report.png "Allure")
![](img/allureTestOps.png "AllureTestOps")
![](img/Browserstack.png "Browserstack")
![](img/Github.png "GitHub")
![](img/Jenkins.png "Jenkins")
![](img/Rest-Assured.png "Rest-Assured")
![](img/AndroidStudio.png "Android Studio")


### Запуск проекта:
- для запуска проектов локально необходимо в local.properies определить параметры конфигурации
- для запуска проектов удаленно необходимо в remote.properies определить параметры конфигурации или передать значения:

  * browser (default chrome)
  * browserVersion (default 89.0)
  * browserSize (default 1920x1080)
  * browserMobileView (mobile device name, for example iPhone X)
  * remoteDriverUrl (url address from selenoid or grid)
  * videoStorage (url address where you should get video)
  * threads (number of threads)


Локально:
```bash
gradle clean test
```

Удаленно:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Видео о прохождении тестов
<img src="https://i.ibb.co/sKGJ8hk/176e95f870b0a79b.gif" alt="video test" border="0" />


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>

<a href="https://ibb.co/sKGJ8hk"><img src="https://i.ibb.co/sKGJ8hk/176e95f870b0a79b.gif" alt="176e95f870b0a79b" border="0"></a>