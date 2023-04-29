@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=C:\Users\HELAL\.jdks\corretto-17.0.6
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\HELAL\.m2\repository\allure\allure-2.21.0\bin;%path%
allure serve allure-results
pause
exit