package ru.pankova.main;// Панькова Светлана. Вариант 2

import ru.pankova.city.*;
import ru.pankova.fraction.*;

import java.util.Scanner;


import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Задание 1.4. Изменить сущность Дробь, чтобы выполнялись следующие условия:
        // 1. Дробь не может быть изменена после создания;
        // 2. Необходимо корректно обрабатывать отрицательные значения.
        out.println("Задание 1.4. Примеры работоспособности программы: ");
        out.print("1. Создаем дробь с отрицательным знаменателем и получаем его" +
                " значение через геттер: \nНапример: 7/-3 Результат: ");
        Fraction1 f1 = new Fraction1(7, -3);
        out.println(f1.getZnam());
        out.println("2. Создаем дробь 3/4. При попытке изменить дробь напрямую или через сеттеры произойдет ошибка.");
        Fraction1 f2 = new Fraction1(3,4);
        /*f2.chis = 5;
        f2.znam = 8;
        f2.setChis(1);
        f2.setZnam(2);*/

        // Задание 3.1. Изменить сущность Дробь, полученную в задаче 2.1.4.
        // Гарантируйте, что невозможно создать
        //такой подвид дроби, который позволял бы создавать Дроби с изменяемым состоянием.

        // Задание 4.2. Изменить сущность Дробь, полученную в задаче 2.3.1. Дробь должна быть подтипом класса
        //Number. Данный класс входит в стандартную редакцию языка Java.
        out.println("\n\n\nЗадание 4.2. Хотите ввести дробь самостоятельно? - да/нет без пробела");
        String otvet = in.nextLine();
        if (otvet.equalsIgnoreCase("да")) {
            int userChisl;
            int userZnam;
            boolean flag = false;

            while (!flag) {
                out.print("Введите числитель и знаменатель: ");
                if (in.hasNextInt()) {
                    userChisl = in.nextInt();
                    if (in.hasNextInt()) {
                        userZnam = in.nextInt();
                        try {
                            Fraction3 f4 = new Fraction3(userChisl, userZnam);
                            out.println("intValue: " + f4.intValue());
                            out.println("floatValue: " + f4.floatValue());
                            out.println("longValue: " + f4.longValue());
                            out.println("doubleValue: " + f4.doubleValue());
                            flag = true;
                        } catch (IllegalArgumentException e) {
                            out.println(e.getMessage());
                        }
                    } else {
                        out.println("Некорректный ввод! Попробуйте снова.");
                        in.next();
                    }
                } else {
                    out.println("Некорректный ввод! Попробуйте снова.");
                    in.next();
                }
            }
        } else if (otvet.equalsIgnoreCase("нет")) {
            out.println("Создадим дробь 10/3 и вызовем методы intValue, floatValue, longValue, doubleValue ");
            Fraction3 f3 = new Fraction3(10, 3);
            out.println("intValue: " + f3.intValue());
            out.println("floatValue: " + f3.floatValue());
            out.println("longValue: " + f3.longValue());
            out.println("doubleValue: " + f3.doubleValue());
        }
        else {
            out.println("Некорректный ввод!");
        }
        // Задание 5.1. Разработать метод, который принимает набор числовых значений и
        // возвращает их сумму в вещественной форме.
        out.print("\n\n\nЗадание 5.1. \nРезультат вычисления первого примера: ");
        DoubleSum n1 = new IntNumber(2);
        DoubleSum n2 = new FractionNumber(3,5);
        DoubleSum n3 = new DoubleNumber(2.3);
        DoubleSum[] numbers1 = {n1, n2, n3};
        out.println(NumberSumm.sum(numbers1));

        out.print("Результат вычисления второго примера: ");
        DoubleSum n4 = new DoubleNumber(3.6);
        DoubleSum n5 = new FractionNumber(49, 12);
        DoubleSum n6 = new IntNumber(3);
        DoubleSum n7 = new FractionNumber(3, 2);
        DoubleSum[] numbers2 = {n4, n5, n6, n7};
        out.println(NumberSumm.sum(numbers2));

        out.print("Результат вычисления третьего примера: ");
        DoubleSum n8 = new FractionNumber(1, 3);
        DoubleSum n9 = new IntNumber(1);
        DoubleSum[] numbers3 = {n8, n9};
        out.println(NumberSumm.sum(numbers3));

        // Задание 1.10. Изменить сущность ru.pankova.city.City. Гарантировать, что между двумя городами может быть только
        //одна прямая дорога.
        //Города можно создавать с указанием заранее заданных путей, в любой момент времени можно
        //добавить новую дорогу в любой город и удалить имеющуюся дорогу.
        out.println("\n\n\nЗадание 1.10. Демонстрация работоспособности программы.");
        // Создание городов
        City1 city1 = new City1("City1");
        City1 city2 = new City1("City2");

        // Создание города с заранее заданными путями
        List<City1> ways = new ArrayList<>(Arrays.asList(city1, city2));
        List<Integer> prices = new ArrayList<>(Arrays.asList(100, 150));
        City1 city3 = new City1("City3", ways, prices);

        out.println(city3);

        // Добавление новой дороги
        City1 city4 = new City1("City4");
        city3.addWay(city4, 200);
        out.println("\nПосле добавления новой дороги:");
        out.println(city3);

        // Удаление дороги
        city3.removeWay(city2);
        out.println("\nПосле удаления дороги:");
        out.println(city3);

        // Попытка добавления существующей дороги
        try {
            city3.addWay(city1, 200); // Попытка добавить существующую дорогу
        } catch (IllegalArgumentException e) {
            out.println("\nПопытка добавления существующей дороги:");
            out.println(e.getMessage());
        }

        // Задание 2.3.3 Создать такой подвид сущности Город, полученной в задаче 2.1.10, которая будет гарантировать,
        //что при добавлении дороги из одного города в другой, одновременно будет добавляться и
        //обратная дорога.
        out.println("\n\n\nЗадание 2.3.3. Создадим два города А и В.");
        City2_3_3 cityA1 = new City2_3_3("CityA");
        City2_3_3 cityB1 = new City2_3_3("CityB");

        out.println("Добавим в город А путь в B. Результат: ");
        cityA1.addWay(cityB1, 100);

        out.println(cityA1);
        out.println(cityB1);

        out.println("Удалим из города А путь в В. Результат: ");
        cityA1.removeWay(cityB1);

        out.println(cityA1);
        out.println(cityB1);

        // Задание 2.5. Маршрут.
        //Данная задача предполагает разработку новой сущности на основе той, что была получена в
        //задаче 1.4.8 (Город).
        out.println("Задача 2.5. Маршрут из Города F в Город D: ");
        City2 cityA = new City2("A");
        City2 cityB = new City2("B");
        City2 cityC = new City2("C");
        City2 cityD = new City2("D");
        City2 cityE = new City2("E");
        City2 cityF = new City2("F");

        // Город А
        cityA.addWay(cityB, 5);
        cityA.addWay(cityF, 1);
        cityA.addWay(cityD, 6);
        // Город B
        cityB.addWay(cityA, 5);
        cityB.addWay(cityC, 3);
        // Город C
        cityC.addWay(cityB, 3);
        cityC.addWay(cityD, 4);
        // Город D
        cityD.addWay(cityC, 4);
        cityD.addWay(cityE, 2);
        cityD.addWay(cityA, 6);
        // Город E
        cityE.addWay(cityF, 2);
        // Город F
        cityF.addWay(cityE, 2);
        cityF.addWay(cityB, 1);

        Route route = new Route(cityF, cityD);
        out.println(route);

        // Задание 6.5. Переопределить метод сравнения
        //объектов по состоянию таким образом, чтобы два Города считались одинаковыми тогда, когда у
        //них одинаковый набор путей в другие города.
        System.out.println("\nЗадание 6.5. Демонстрация работоспособности программы: ");

        // Города первого типа
        City city1A = new City1_6_5("CityA");
        City city1B = new City1_6_5("CityB");

        // Города второго типа
        City city2A = new City2_6_5("CityA");
        City city2B = new City2_6_5("CityB");

        // Сравниваем города разных типов
        city1A.addWay(city1B, 10);
        city2A.addWay(city1B, 10);

        System.out.println("Сравнение городов разных типов: " + city1A.equals(city2A));

        // Сравниваем города одного типа (одинаковые пути)
        City city1D = new City1_6_5("CityD");
        City city1E = new City1_6_5("CityE");

        city1D.addWay(city1E, 20);

        City city1G = new City1_6_5("CityG");
        City city1H = new City1_6_5("CityH");

        city1G.addWay(city1H, 20);

        System.out.println("Сравнение городов одного типа (одинаковые пути): " + city1D.equals(city1G));

        // Сравниваем города одного типа (разные пути)
        City city1J = new City1_6_5("CityJ");
        City city1K = new City1_6_5("CityK");

        city1J.addWay(city1K, 30);

        City city1M = new City1_6_5("CityM");
        City city1N = new City1_6_5("CityN");

        city1M.addWay(city1N, 60);

        System.out.println("Сравнение городов одного типа (разные пути): " + city1J.equals(city1M));
        in.close();

        // Задание 7.3.
        out.println("\n\n\nЗадание 7.3");
        if (args.length != 2) {
            out.println("Пожалуйста, введите два числа в качестве аргументов командной строки.");
            return;
        }

        String xStr = args[0];
        String yStr = args[1];

        try {
            double result = power(xStr, yStr);
            out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            out.println("Ошибка преобразования строки в число: " + e.getMessage());
        }
    }

    public static double power(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        return Math.pow(x, y);
    }
}
