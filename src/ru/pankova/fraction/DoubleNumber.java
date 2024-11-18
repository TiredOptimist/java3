package ru.pankova.fraction;

import ru.pankova.main.DoubleSum;

// Класс для вещественных чисел из задачи 5.1.
public class DoubleNumber implements DoubleSum {
    private final double num;

    double GetNum(){
        return this.num;
    }

    public DoubleNumber(double num) {
        this.num = num;
    }

    @Override
    public double doubleValue() {
        return num;
    }

    @Override
    public String toString() {
        return Double.toString(doubleValue());
    }
}