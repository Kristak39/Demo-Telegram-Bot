package com.Kristian.TelegramBot.Demo.Telegram.Bot.scripts

import groovy.sql.Sql

// Задаем параметры подключения к HSQLDB
def url = 'jdbc:hsqldb:mem:testdb'
def user = 'SA'
def password = ''

// Создаем объект Sql для выполнения SQL запросов
def sql = Sql.newInstance(url, user, password, 'org.hsqldb.jdbc.JDBCDriver')

try {
    // Выполняем SQL запросы для создания базы данных и таблицы
    sql.execute('''CREATE TABLE users (
                    id INTEGER IDENTITY PRIMARY KEY,
                    username VARCHAR(50),
                    password VARCHAR(50)
                  )''')

    println "Таблица 'users' создана успешно."

} finally {
    // Закрываем соединение после выполнения запросов
    sql.close()
}