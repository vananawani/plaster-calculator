package com.example.plastercalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

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
        Button testButton = findViewById(R.id.testButton);
        TextView resultText = findViewById(R.id.resultText);

        testButton.setOnClickListener(v -> {

            double v1 = volume("cylinder", 10, 0, 5);
            resultText.setText("体積 = " + v1);

        });

    }


    private double volume(String shape, double w, double d, double h) {

        switch (shape) {
            case "cylinder":
                return Math.PI * Math.pow(w / 2.0, 2) * h;

            case "box":
                return w * d * h;

            case "cone":
                return Math.PI * Math.pow(w / 2.0, 2) * h / 3.0;

            default:
                return 0;
        }
    }
}
