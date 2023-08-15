package com.sber.tasks.demosbertasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String delimiter = ",";
    public static String filePath = "C:\\Users\\Desktop\\Tasks.csv";
    public static List<City> cities = new ArrayList<>();

    public static void read(String csvFile) {
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
    }
    public static void main(String[] args) {
        String csvFile = filePath;
        Main.read(csvFile);
        cities.forEach(System.out::println);
    }
}
