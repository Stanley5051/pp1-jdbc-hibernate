package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();


        System.out.println("Создание таблицы...");
        userService.createUsersTable();
        System.out.println("Таблица пользователей создана.");

        userService.saveUser("Вася", "Пупкин", (byte) 25);
        userService.saveUser("Елена", "Головач", (byte) 30);
        userService.saveUser("Баракь", "Обэма", (byte) 55);
        userService.saveUser("Фокс", "Терьер", (byte) 4);


        System.out.println("Получение всех пользователей...");
        List<User> users = userService.getAllUsers();
        if (users != null) {
            users.forEach(System.out::println);  // печать всех в консоль
        } else {
            System.out.println("Пользователи не найдены.");
        }


        System.out.println("Очистка таблицы...");
        userService.cleanUsersTable();
        System.out.println("Таблица пользователей очищена.");


        System.out.println("Удаление таблицы...");
        userService.dropUsersTable();
        System.out.println("Таблица пользователей удалена.");
    }
}