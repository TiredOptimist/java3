package ru.pankova.city;// Для задачи Маршрут 2.5. из решения 1.4.8.
import java.util.ArrayList;
import java.util.List;

public class City2 {
    private String city;
    private List<City2> ways;
    private List<Integer> prices;

    String setCity(String city) {
        this.city = city;
        return this.city;
    }

    String getCity() {
        return this.city;
    }

    List<City2> setWays(List<City2> ways) {
        this.ways = ways;
        return this.ways;
    }

    List<City2> getWays() {
        return ways;
    }

    List<Integer> setPrices(List<Integer> prices) {
        this.prices = prices;
        return this.prices;
    }

    List<Integer> getPrices() {
        return prices;
    }

    City2() {
        this.city = "Unnamed City";
        this.ways = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public City2(String city) {
        this.city = city;
        this.ways = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    City2(String city, List<City2> ways, List<Integer> prices) {
        this.city = city;
        this.ways = new ArrayList<>(ways);
        this.prices = new ArrayList<>(prices);
    }

    public void addWay(City2 way, int price) {
        ways.add(way);
        prices.add(price);
    }

    public String toString() {
        StringBuilder rez = new StringBuilder("Маршруты из города " + city + ": " + "\n");
        for (int i = 0; i < ways.size(); i++) {
            rez.append("Куда: ").append(ways.get(i).getCity()).append(" Стоимость поездки: ").append(prices.get(i)).append("\n");
        }
        return rez.toString();
    }
}
