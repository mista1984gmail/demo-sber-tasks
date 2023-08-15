package com.sber.tasks.demosbertasks;

public class City {
    private String name;
    private String region;
    private String district;
    private Long population;
    private String foundation ;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }
    public City(String name, String region) {
        this.name = name;
        this.region = region;
    }
    public City(String name, String region, String district ){
        this.name = name;
        this.region = region;
        this.district = district;
    }
    public City(String name, String region, String district, Long population) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
    }
    public City(String name, String region, String district, Long population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    public static class CityBuilder {
        private City city;

        public CityBuilder() {
            city = new City();
        }

        public City createCity(String [] initArrays){
            switch (initArrays.length){
                case 6:
                    city.setFoundation(initArrays[5]);
                case 5:
                    city.setPopulation(Long.parseLong(initArrays[4]));
                case 4:
                    city.setDistrict(initArrays[3]);
                case 3:
                    city.setRegion(initArrays[2]);
                case 2:
                    city.setName(initArrays[1]);
                default:
                    break;
            }
            return city;
        }

        public CityBuilder withName(String name){
            city.setName(name);
            return this;
        }
        public CityBuilder withRegion(String region){
            city.setRegion(region);
            return this;
        }
        public CityBuilder withDistrict(String district){
            city.setDistrict(district);
            return this;
        }
        public CityBuilder withPopulation(Long population){
            city.setPopulation(population);
            return this;
        }
        public CityBuilder withFoundation(String foundation ){
            city.setFoundation (foundation );
            return this;
        }
        public City build(){
            return city;
        }
    }
}
