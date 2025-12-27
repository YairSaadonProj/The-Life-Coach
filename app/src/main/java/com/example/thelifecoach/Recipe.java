package com.example.thelifecoach;

public class Recipe {
    private String name;
    private double protein;
    private int calories;
    private String instructions;

    public Recipe(String name, double protein, int calories, String instructions) {
        this.name = name;
        this.protein = protein;
        this.calories = calories;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public int getCalories() {
        return calories;
    }

    public String getInstructions() {
        return instructions;
    }
}
