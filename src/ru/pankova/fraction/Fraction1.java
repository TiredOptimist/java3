package ru.pankova.fraction;

// 1.4. Дробь не может быть изменена после создания
public class Fraction1 {
    private final int chis;
    private final int znam;

    int getChis(){
        return this.chis;
    }

    public int getZnam(){
        return this.znam;
    }

    // для целого числа
    public Fraction1(int chis){
        this(chis, 1);
    }

    public Fraction1(int chis, int znam){
        if (znam == 0) { // знаменатель не может равняться 0
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }

        if (znam < 0) { // знаменатель не может быть отрицательным
            chis = -chis;
            znam = -znam;
        }
        int nod = nod(chis, znam); // сокращаем дробь
        this.chis = chis / nod;
        this.znam = znam / nod;
    }

    public String toString() {
        return this.chis + "/" + this.znam;
    }

    // нахождение наибольшего общего делителя
    private int nod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // сложения дробей (с другом дробью или с целым числом)
    public Fraction1 summa(Fraction1 fraction) {
        int newChis = this.chis * fraction.znam + fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction1(newChis, newZnam);
    }

    // вычитание дробей (с другой дробью или с целым числом)
    public Fraction1 razn(Fraction1 fraction) {
        int newChis = this.chis * fraction.znam - fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction1(newChis, newZnam);
    }

    // умножение дробей (с другой дробью или целым числом)
    public Fraction1 umn(Fraction1 fraction) {
        int newChis = this.chis * fraction.chis;
        int newZnam = this.znam * fraction.znam;
        return new Fraction1(newChis, newZnam);
    }

    // деление дробей (с другой дробью или целым числом)
    public Fraction1 del(Fraction1 fraction) {
        if (fraction.chis == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        int newChis = this.chis * fraction.znam;
        int newZnam = this.znam * fraction.chis;
        return new Fraction1(newChis, newZnam);
    }
}
