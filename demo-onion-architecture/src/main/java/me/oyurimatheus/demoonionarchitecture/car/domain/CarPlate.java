package me.oyurimatheus.demoonionarchitecture.car.domain;

public class CarPlate {

    private final String letters;
    private final String numbers;
    private final String state;
    private final String city;

    public CarPlate(String letters, String numbers, String state, String city) {
        this.letters = letters;
        this.numbers = numbers;
        this.state = state;
        this.city = city;
    }

    public String getLetters() {
        return letters;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
