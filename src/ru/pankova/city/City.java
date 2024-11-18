package ru.pankova.city;// Интерфейс для задачи 6.5.
import java.util.List;

public interface City {
    String getCity();
    List<City> getWays();
    List<Integer> getPrices();
    void addWay(City way, int price);
    void removeWay(City way);
}
