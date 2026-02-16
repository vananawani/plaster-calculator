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
import android.view.View;
import android.widget.AdapterView;



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
        EditText inputD = findViewById(R.id.inputD);
        Spinner shapeSpinner = findViewById(R.id.shapeSpinner);
        String[] shapes = {"円柱", "直方体", "円錐"};
        EditText inputMixWater = findViewById(R.id.inputMixWater);
        EditText inputYield = findViewById(R.id.inputYield);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        shapes);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        shapeSpinner.setAdapter(adapter);

        shapeSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view,
                                               int position,
                                               long id) {

                        String s = parent.getItemAtPosition(position).toString();

                        if(s.equals("直方体")){
                            inputD.setVisibility(View.VISIBLE);
                        }else{
                            inputD.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                }
        );



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

            double d = 0;

            if(shape.equals("box")){
                String dStr = inputD.getText().toString();

                if(dStr.isEmpty()){
                    resultText.setText("奥行きを入力してください");
                    return;
                }

                d = Double.parseDouble(dStr);
            }

            String mixStr = inputMixWater.getText().toString();
            String yieldStr = inputYield.getText().toString();

            if(mixStr.isEmpty() || yieldStr.isEmpty()){
                resultText.setText("素材情報を入力してください");
                return;
            }

            double mixWater = Double.parseDouble(mixStr);
            double yieldVal = Double.parseDouble(yieldStr);

            Result r = calcPlaster(
                    shape,
                    w, d, h,
                    false,
                    0, 0, 0,
                    1,
                    0,
                    yieldVal,
                    mixWater
            );

            resultText.setText(
                    String.format(
                            "完成体積：%.1f cm3\n石膏：約 %.0f g\n水：約 %.0f ml",
                            r.volume,
                            r.plasterKg * 1000,
                            r.waterMl
                    )
            );


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
    private Result calcPlaster(
            String shape,
            double w, double d, double h,
            boolean hollow,
            double iw, double id, double ih,
            int count,
            double lossPercent,
            double yieldVal,
            double mixWater
    ){
        double vol = volume(shape, w, d, h);

        if(hollow){
            vol -= volume(shape, iw, id, ih);
        }

        vol *= count * (1.0 + lossPercent / 100.0);

        double plasterKg = vol / yieldVal;
        double waterMl = plasterKg * mixWater;

        return new Result(vol, plasterKg, waterMl);
    }

    static class Result {
        double volume;
        double plasterKg;
        double waterMl;

        Result(double volume, double plasterKg, double waterMl) {
            this.volume = volume;
            this.plasterKg = plasterKg;
            this.waterMl = waterMl;
        }
    }

}


