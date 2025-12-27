package com.example.thelifecoach;

import android.annotation.SuppressLint;
import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Recipe> recipesList = new ArrayList<>();
        recipesList.add(new Recipe("Omelette", 15, 200, "Fry eggs"));
        recipesList.add(new Recipe("Chicken", 30, 400, "Grill it"));
        TextView resultDisplay = findViewById(R.id.resultDisplay);
        TextView WelcomeText = findViewById(R.id.WelcomeText);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        Button MotivationButton = findViewById(R.id.MotivationButton);
        ArrayList<String> motivationList = new ArrayList<>();
        motivationList.add("Success starts with self-discipline.");
        motivationList.add("Don't stop when you're tired, stop when you're done!");
        motivationList.add("Your only limit is you.");
        motivationList.add("Focus on your goal. Don't look in any direction but ahead.");
        MotivationButton.setOnClickListener(v -> {
            int randomIndex = (int) (Math.random() * motivationList.size());
            String randomMotivation = motivationList.get(randomIndex);
            resultDisplay.setText(randomMotivation);
            resultDisplay.setTextColor(android.graphics.Color.parseColor("#6200EE"));

        });

        // comment to delete

        int hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            WelcomeText.setText("Good Morning, Athlete!");
        } else if (hour < 18) {
            WelcomeText.setText("Good Afternoon, Athlete!");
        } else {
            WelcomeText.setText("Good Evening, Athlete!");
        }
        btnCalculate.setOnClickListener(v -> {
            Recipe bestProtienRecipe = recipesList.get(0);
            for (int i = 0; i < recipesList.size(); i++) {
                if (recipesList.get(i).getProtein() > bestProtienRecipe.getProtein()) {
                    bestProtienRecipe = recipesList.get(i);
                }
            }
            resultDisplay.setAlpha(0f);
            resultDisplay.setText(bestProtienRecipe.getName());
            resultDisplay.animate().alpha(1f).setDuration(500);
        });
    }
}
