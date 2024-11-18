package ru.pankova.city;// Задание 6.5. из задания 2.3.3.

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City2_6_5 implements City {
    private String city;
    private List<City> ways;
    private List<Integer> prices;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<City> getWays() {
        return ways;
    }

    public void setWays(List<City> ways) {
        this.ways = new ArrayList<>(ways);
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = new ArrayList<>(prices);
    }

    public City2_6_5(String city) {
        this.city = city;
        this.ways = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public City2_6_5(String city, List<City> ways, List<Integer> prices) {
        this.city = city;
        this.ways = new ArrayList<>(ways);
        this.prices = new ArrayList<>(prices);
    }

    @Override
    public void addWay(City way, int price) {
        if (ways.contains(way)) {
            throw new IllegalArgumentException("Дорога между городами " + city + " и " + way.getCity() + " уже существует.");
        }
        ways.add(way);
        prices.add(price);

        // добавляем обратный путь
        if (way instanceof City2_6_5) { // instanceof проверяет принадлежность к классу
            ((City2_6_5) way).addReverse(this, price);
        }
    }

    private void addReverse(City way, int price) {
        ways.add(way);
        prices.add(price);
    }

    @Override
    public void removeWay(City way) {
        int index = ways.indexOf(way);
        if (index == -1) {
            throw new IllegalArgumentException("Дорога между городами " + city + " и " + way.getCity() + " не существует.");
        }
        ways.remove(index);
        prices.remove(index);

        // удаляем обратный путь
        if (way instanceof City2_6_5) { // instanceof проверяет принадлежность к классу
            ((City2_6_5) way).removeReverse(this);
        }
    }

    private void removeReverse(City way) {
        int index = ways.indexOf(way);
        if (index != -1) {
            ways.remove(index);
            prices.remove(index);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(ways, city.getWays()) && Objects.equals(prices, city.getPrices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ways);
    }

    public String toString() {
        StringBuilder rez = new StringBuilder("Маршруты из города " + city + ": " + "\n");
        for (int i = 0; i < ways.size(); i++) {
            rez.append("Куда: ").append(ways.get(i).getCity()).append(" Стоимость поездки: ").append(prices.get(i)).append("\n");
        }
        return rez.toString();
    }
}
