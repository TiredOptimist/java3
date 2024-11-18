package ru.pankova.city;// 1.10. Между городами только одна дорога
import java.util.ArrayList;
import java.util.List;

public class City1 {
    private String city;
    private List<City1> ways;
    private List<Integer> prices;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<City1> getWays() {
        return ways;
    }

    public void setWays(List<City1> ways) {
        this.ways = new ArrayList<>(ways);
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = new ArrayList<>(prices);
    }

    public City1(String city) {
        this.city = city;
        this.ways = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public City1(String city, List<City1> ways, List<Integer> prices) {
        this.city = city;
        this.ways = new ArrayList<>(ways);
        this.prices = new ArrayList<>(prices);
    }

    public void addWay(City1 way, int price) {
        if (ways.contains(way)) {
            throw new IllegalArgumentException("Дорога между городами " + city + " и " + way.getCity() + " уже существует.");
        }
        ways.add(way);
        prices.add(price);
    }

    public void removeWay(City1 way) {
        int index = ways.indexOf(way);
        if (index == -1) {
            throw new IllegalArgumentException("Дорога между городами " + city + " и " + way.getCity() + " не существует.");
        }
        ways.remove(index);
        prices.remove(index);
    }

    public String toString() {
        StringBuilder rez = new StringBuilder("Маршруты из города " + city + ": " + "\n");
        for (int i = 0; i < ways.size(); i++) {
            rez.append("Куда: ").append(ways.get(i).getCity()).append(" Стоимость поездки: ").append(prices.get(i)).append("\n");
        }
        return rez.toString();
    }
}
