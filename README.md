# BankAccountKata

####################################
Subject :

Bank account kata
Think of your personal bank account experience When in doubt, go for the simplest solution
 
Requirements
Deposit and Withdrawal
Account statement (date, amount, balance)
Statement printing
 
User Stories
 
US 1: 
In order to save money
As a bank client
I want to make a deposit in my account
 
 US 2: 
In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

 US 3: 
In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance)  of my operations

####################################

developpé avec Spring Boot, Hibernate/JPA, MySql, Spring data, Spring MVC pour les WebService Rest
			et Angular 2/4  avec @angular/cli

ATTENTION : si le projet java est lancé en tant que JavaApplication il n y a rien d'autre à faire,

			sinon, s'il est lancé en tant que war ou à l'aide de la ServletInitializer, alors il faut modifier la variable URL_WEBSERVICE_BEGIN dans le fichier app.url-config.ts
			avec cette nouvelle valeur : URL_WEBSERVICE_BEGIN='http://localhost:8080/BankAccountKata/services/';
			
			
####################################

il faut dezziper le fichier node_modules.rar (car il était trop volumineux )

ATTENTION : La BD se nomme 'bankaccountkata'
pour creer la BD on peut soit : 
- utiliser le fichier sql : bankaccountkata.sql
- changer le parametre  "spring.jpa.hibernate.ddl-auto=create"  du  fichier "BankAccountKata\BankAccountKata\src\main\resources\application.properties"



