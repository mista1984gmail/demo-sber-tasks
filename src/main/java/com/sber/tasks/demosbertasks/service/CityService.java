package com.sber.tasks.demosbertasks.service;

import com.sber.tasks.demosbertasks.model.City;
import com.sber.tasks.demosbertasks.service.comparing.CityDistrictComparator;
import com.sber.tasks.demosbertasks.service.comparing.CityNameComparator;
import com.sber.tasks.demosbertasks.service.comparing.CityNameComparatorWithOrder;
import com.sber.tasks.demosbertasks.service.comparing.CityRegionComparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CityService {

    public List<City> sortByNameInAlphabeticalOrderInDescendingOrder(List<City>cities){
        cities.sort(new CityNameComparator());
        return cities;
    }
    public List<City> sortByRegionInAlphabeticalOrderInDescendingOrder(List<City>cities){
        cities.sort(new CityRegionComparator());
        return cities;
    }

    public List<City> sortByDistrictAndNameInAlphabeticalOrderInDescendingOrder(List<City>cities){
        Comparator<City> comparator = new CityDistrictComparator().thenComparing(new CityNameComparatorWithOrder());
        cities.sort(comparator);
        return cities;
    }

    public Map<String, Long> findCountCitiesInEachRegionWithStreams(List<City>cities){
        return cities.stream().collect(groupingBy(City::getRegion, counting()));
    }

    public Map<String, Long> findCountCitiesInEachRegion(List<City>cities){
        Map<String, Long> numberOfCitiesInEachRegion = new HashMap<>();
        sortByRegionInAlphabeticalOrderInDescendingOrder(cities);
        String region = cities.get(0).getRegion();
        Long numberOfCities = 1L;
        for (int i = 1; i < cities.size(); i++) {
            if (region.equals(cities.get(i).getRegion())){
               numberOfCities++;
            } else {
                numberOfCitiesInEachRegion.put(region, numberOfCities);
                region = cities.get(i).getRegion();
                numberOfCities = 1L;
            }
        }
        return numberOfCitiesInEachRegion;
    }

    public void findIndexAndValueWithLargestPopulation(List<City> cities) {
        if (cities.size() > 0) {
            City[] citiesArrays = new City[cities.size()];
            for (int i = 0; i < cities.size(); i++) {
                citiesArrays[i] = cities.get(i);
            }
            long maxPopulation = citiesArrays[0].getPopulation();
            int index = 0;
            for (int i = 1; i < citiesArrays.length; i++) {
                if (maxPopulation < citiesArrays[i].getPopulation()) {
                    maxPopulation = citiesArrays[i].getPopulation();
                    index = i;
                }
            }
            System.out.println("[" + index + "] = " + maxPopulation);
        } else {
            System.out.println("[0] = 0");
        }
    }


    public List<City>sortByNameInAlphabeticalOrderInDescendingOrderWithStreams(List<City>cities){
        return cities.stream().sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());
    }
}
