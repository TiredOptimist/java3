package ru.pankova.fraction;

// 4.2. Дробь должна быть подтипом класса Number
public final class Fraction3 extends Number {
    private final int chis;
    private final int znam;

    public int getChis() {
        return chis;
    }

    public int getZnam() {
        return znam;
    }

    // Конструктор для целого числа
    public Fraction3(int chis) {
        this(chis, 1);
    }

    // Конструктор для дроби
    public Fraction3(int chis, int znam) {
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

    @Override
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
    public Fraction3 summa(Fraction3 fraction) {
        int newChis = this.chis * fraction.znam + fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction3(newChis, newZnam);
    }

    // Вычитание дробей
    public Fraction3 razn(Fraction3 fraction) {
        int newChis = this.chis * fraction.znam - fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction3(newChis, newZnam);
    }

    // Умножение дробей
    public Fraction3 umn(Fraction3 fraction) {
        int newChis = this.chis * fraction.chis;
        int newZnam = this.znam * fraction.znam;
        return new Fraction3(newChis, newZnam);
    }

    // Деление дробей
    public Fraction3 del(Fraction3 fraction) {
        if (fraction.chis == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        int newChis = this.chis * fraction.znam;
        int newZnam = this.znam * fraction.chis;
        return new Fraction3(newChis, newZnam);
    }

    // Реализация методов класса Number
    @Override
    public int intValue() {
        return chis / znam;
    }

    @Override
    public long longValue() {
        return (long) chis / znam;
    }

    @Override
    public float floatValue() {
        return (float) chis / znam;
    }

    @Override
    public double doubleValue() {
        return (double) chis / znam;
    }
}
