package com.example.thelifecoach;

public class Exercise {
    private String name;
    private int reps;
    private int sets;
    private int weight;
    private int restInSeconds;

    public Exercise(String name, int reps, int sets, int weight, int restInSeconds) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.restInSeconds = restInSeconds;
    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getWeight() {
        return weight;
    }

    public int getRestInSeconds() {
        return restInSeconds;
    }
}
