package com.sber.tasks.demosbertasks;

import com.sber.tasks.demosbertasks.model.City;
import com.sber.tasks.demosbertasks.service.CityService;
import com.sber.tasks.demosbertasks.service.FileLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static String filePath = "C:\\Users\\Desktop\\Cities.csv";
    public static void main(String[] args) {
        String csvFile = filePath;
        List<City> cities = FileLoader.read(csvFile);
        cities.forEach(System.out::println);
        System.out.println("*******************************************************************");
        CityService cityService = new CityService();
        List<City> sortedCitiesByName = cityService.sortByNameInAlphabeticalOrderInDescendingOrder(cities);
        sortedCitiesByName.forEach(System.out::println);
        System.out.println("*******************************************************************");
        List<City> sortedCitiesByDistrictAndByName = cityService.sortByDistrictAndNameInAlphabeticalOrderInDescendingOrder(cities);
        sortedCitiesByDistrictAndByName.forEach(System.out::println);
        System.out.println("*******************************************************************");
        System.out.println("Largest population");
        cityService.findIndexAndValueWithLargestPopulation(cities);
        System.out.println("*******************************************************************");
        System.out.println("Number of cities in each region");
        Map<String, Long> numberOfCitiesInEachRegion = cityService.findCountCitiesInEachRegion(cities);
        for (String key : numberOfCitiesInEachRegion.keySet()) {
            System.out.println(key + " - " + numberOfCitiesInEachRegion.get(key));
        }

    }
}
