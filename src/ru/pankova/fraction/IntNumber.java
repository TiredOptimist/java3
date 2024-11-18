package ru.pankova.fraction;

import ru.pankova.main.DoubleSum;

// Класс для целых чисел из задачи 5.1.
public class IntNumber implements DoubleSum {
    private final int num;

    int getNum(){
        return this.num;
    }

    public IntNumber(int num) {
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