package com.example.plastercalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;



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
        EditText inputW = findViewById(R.id.inputW);
        EditText inputH = findViewById(R.id.inputH);
        Spinner shapeSpinner = findViewById(R.id.shapeSpinner);
        String[] shapes = {"円柱", "直方体", "円錐"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        shapes);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        shapeSpinner.setAdapter(adapter);



        testButton.setOnClickListener(v -> {

            String wStr = inputW.getText().toString();
            String hStr = inputH.getText().toString();

            if(wStr.isEmpty() || hStr.isEmpty()){
                resultText.setText("数値を入力してください");
                return;
            }

            double w = Double.parseDouble(wStr);
            double h = Double.parseDouble(hStr);

            String selected = shapeSpinner.getSelectedItem().toString();

            String shape;

            if(selected.equals("円柱")){
                shape = "cylinder";
            }else if(selected.equals("直方体")){
                shape = "box";
            }else{
                shape = "cone";
            }

            double v1 = volume(shape, w, 0, h);


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
