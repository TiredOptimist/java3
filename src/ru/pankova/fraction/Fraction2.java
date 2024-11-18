package ru.pankova.fraction;

// 3.1. Нельзя наследовать
public final class Fraction2 {
    private final int chis;
    private final int znam;

    public int getChis() {
        return chis;
    }

    public int getZnam() {
        return znam;
    }

    // Конструктор для целого числа
    public Fraction2(int chis) {
        this(chis, 1);
    }

    // Конструктор для дроби
    public Fraction2(int chis, int znam) {
        if (znam == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }

        if (znam < 0) {
            chis = -chis;
            znam = -znam;
        }

        int nod = nod(chis, znam);
        this.chis = chis / nod;
        this.znam = znam / nod;
    }

    public String toString() {
        return chis + "/" + znam;
    }

    // Нахождение наибольшего общего делителя
    private int nod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Сложение дробей
    public Fraction2 summa(Fraction2 fraction) {
        int newChis = this.chis * fraction.znam + fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction2(newChis, newZnam);
    }

    // Вычитание дробей
    public Fraction2 razn(Fraction2 fraction) {
        int newChis = this.chis * fraction.znam - fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction2(newChis, newZnam);
    }

    // Умножение дробей
    public Fraction2 umn(Fraction2 fraction) {
        int newChis = this.chis * fraction.chis;
        int newZnam = this.znam * fraction.znam;
        return new Fraction2(newChis, newZnam);
    }

    // Деление дробей
    public Fraction2 del(Fraction2 fraction) {
        if (fraction.chis == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        int newChis = this.chis * fraction.znam;
        int newZnam = this.znam * fraction.chis;
        return new Fraction2(newChis, newZnam);
    }
}

