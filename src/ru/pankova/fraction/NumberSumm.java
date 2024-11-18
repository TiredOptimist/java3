package ru.pankova.fraction;

import ru.pankova.main.DoubleSum;

// Класс для сложения чисел из задачи 5.1.
public class NumberSumm {
    public static double sum(DoubleSum[] numbers) {
        double sum = 0;
        for (DoubleSum number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}