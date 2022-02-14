# Проект автотестов на [hh.ru](https://hh.ru/)

<img align="center" src="https://github.com/ioomoon/QA-guru-graduation/blob/master/img/hh.jpg?raw=true" width="300">

---

## <img src="https://github.com/ioomoon/QA-guru-graduation/blob/master/img/icon5.png?raw=true" width="25"> Реализованы проверки:

Ui:
- Проверка наличия корректного промо-текста на главной странице
- Проверка наличия результатов поиска по профессии
- Проверка наличия результатов расширенного поиска
- Проверка перехода на страницу для работодателей при нажатии кнопки в панели навигации
- Проверка перехода на страницу для работодателей при нажатии 'Я ищу сотрудника'

API:
- Проверка наличия результата поиска по работодателям на территории России
- Проверка корректного поиска компании по id
- Проверка на наличие открытых вакансий в HH.ru
- Проверка доступных локалей для хоста hh.ru
- Проверка доступных локалей для хоста hh.kz
- Поиск работодателя 'QA-guru'

---
## <img src="https://github.com/ioomoon/QA-guru-graduation/blob/master/img/icon2.png?raw=true" width="25"> Стек технологий:
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



## <img src="https://github.com/ioomoon/QA-guru-graduation/blob/master/img/icon4.png?raw=true" width="25"> Запуск проекта:
- для запуска проектов локально необходимо в local.properies определить параметры конфигурации
- для запуска проектов удаленно необходимо в remote.properies определить параметры конфигурации или передать значения:

  * browser (default chrome)
  * browserVersion (default 91.0)
  * browserSize (default 1920x1080)
  * remoteDriverUrl (url address from selenoid or grid)
  * allure_notifications_version (default 2.2.3)
  * comment (for Allure notifications)


Локально:
```bash
gradle clean test
```

Удаленно:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```
## <img src="https://github.com/ioomoon/QA-guru-graduation/blob/master/img/icon6.png?raw=true" width="25"> Отчеты в Allure Report
![](img/allure1.png "Java")
![](img/allure2.png "Java")


## <img src="https://github.com/ioomoon/QA-guru-graduation/blob/master/img/icon1.png?raw=true" width="25"> Telegram-уведомления о прохождении тестов
![](img/telegram_notification.png "Java")

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
