package ru.pankova.fraction;

import ru.pankova.main.DoubleSum;

// Класс для дробей из задачи 5.1.
public class FractionNumber implements DoubleSum {
    private final int chis;
    private final int znam;

    int getChis(){
        return this.chis;
    }

    int getZnam(){
        return this.znam;
    }

    public FractionNumber(int chis, int znam) {
        if (znam == 0) { // знаменатель не может равняться 0
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }

        if (znam < 0) { // знаменатель не может быть отрицательным
            chis = -chis;
            znam = -znam;
        }
        this.chis = chis;
        this.znam = znam;
    }
    @Override
    public double doubleValue() {
        return (double) chis / znam;
    }

    @Override
    public String toString() {
        return Double.toString(doubleValue());
    }
}