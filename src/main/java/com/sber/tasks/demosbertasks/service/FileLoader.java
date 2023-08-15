package com.sber.tasks.demosbertasks.service;

import com.sber.tasks.demosbertasks.model.City;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static final String delimiter = ",";

    public static List<City> read(String csvFile) {
        List<City> cities = new ArrayList<>();
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr : tempArr) {
                    String[] cityInfo = tempStr.split(";");
                    City city = new City.CityBuilder().createCity(cityInfo);
                    cities.add(city);
                }
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return cities;
    }
}
