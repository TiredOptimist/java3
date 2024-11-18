package ru.pankova.city;// 2.5. Маршрут. Обход в ширину

import java.util.*;

public class Route {
    private City2 startCity;
    private City2 endCity;

    public Route(City2 startCity, City2 endCity) {
        validateCity(startCity, "Начальный город должен быть указан.");
        validateCity(endCity, "Конечный город должен быть указан.");
        this.startCity = startCity;
        this.endCity = endCity;
    }

    public void setStartCity(City2 startCity) {
        validateCity(startCity, "Начальный город должен быть указан.");
        this.startCity = startCity;
    }

    public void setEndCity(City2 endCity) {
        validateCity(endCity, "Конечный город должен быть указан.");
        this.endCity = endCity;
    }


    // Метод реализует алгоритм обхода в ширину (BFS) для поиска маршрута.
    // Использует очередь для хранения вершин, которые нужно обследовать.
    public List<City2> getRoute() {
        Set<City2> visited = new HashSet<>(); // обеспечивает уникальность посещенных городов
        Queue<City2> queue = new LinkedList<>(); // Очередь для хранения городов для обследования
        Map<City2, City2> parentMap = new HashMap<>(); // Словарь для хранения родительских городов

        // Добавляем начальный город в очередь и помечаем его как посещенный
        queue.offer(startCity);
        visited.add(startCity);

        while (!queue.isEmpty()) {
            // Извлекаем следующий неисследованный город из очереди
            City2 current = queue.poll(); // Удаляет и возвращает элемент из головы очереди

            // Проверяем, является ли текущий город конечным
            if (current.equals(endCity)) {
                // Если да, реконструируем путь от начала до конца
                return reconstructPath(parentMap, startCity, endCity);
            }

            // Обрабатываем все непосещенные города соседа
            for (City2 neighbor : current.getWays()) {
                if (!visited.contains(neighbor)) {
                    // Добавляем незнакомый сосед в очередь и помечаем как посещенный
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    // Запоминаем родительского города для реконструкции пути
                    parentMap.put(neighbor, current);
                }
            }
        }

        // Если до конца не добрались, возвращаем пустой список
        return new ArrayList<>();
    }

    private List<City2> reconstructPath(Map<City2, City2> parentMap, City2 startCity, City2 endCity) {
        List<City2> path = new ArrayList<>();
        for (City2 at = endCity; at != null; at = parentMap.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        if (!path.isEmpty() && path.get(0).equals(startCity)) {
            return path;
        }
        return new ArrayList<>();
    }


    private void validateCity(City2 city, String message) {
        if (city == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public String toString() {
        List<City2> route = getRoute();
        if (route.isEmpty()) {
            return "Нет маршрута";
        }
        StringBuilder sb = new StringBuilder();
        for (City2 city : route) {
            sb.append(city.getCity()).append(" ");
        }
        return sb.toString().trim();
    }
}
