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
import android.widget.CheckBox;



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

        // ---------- 画面部品の取得 ----------
        Button testButton = findViewById(R.id.testButton);
        TextView resultText = findViewById(R.id.resultText);
        EditText inputW = findViewById(R.id.inputW);
        EditText inputH = findViewById(R.id.inputH);
        EditText inputD = findViewById(R.id.inputD);

        EditText inputMixWater = findViewById(R.id.inputMixWater);
        EditText inputYield = findViewById(R.id.inputYield);
        EditText inputCount = findViewById(R.id.inputCount);
        EditText inputLoss = findViewById(R.id.inputLoss);
        CheckBox checkHollow = findViewById(R.id.checkHollow);
        EditText inputIW = findViewById(R.id.inputIW);
        EditText inputIH = findViewById(R.id.inputIH);
        EditText inputID = findViewById(R.id.inputID);

        Spinner shapeSpinner = findViewById(R.id.shapeSpinner);
        Spinner innerShapeSpinner = findViewById(R.id.innerShapeSpinner);

        // ---------- 外側形状スピナー設定 ----------
        String[] shapes = {"円柱", "直方体", "円錐"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        shapes);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        shapeSpinner.setAdapter(adapter);

        // ---------- 内側形状スピナー設定 ----------
        String[] innerShapes = {"円柱", "直方体", "円錐"};

        ArrayAdapter<String> innerAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        innerShapes);

        innerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        innerShapeSpinner.setAdapter(innerAdapter);

        // ---------- 外側形状が直方体のときだけ奥行を表示 ----------
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

        // ---------- 内側形状が直方体のときだけ内奥行を表示 ----------
        innerShapeSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view,
                                               int position,
                                               long id) {

                        String s = parent.getItemAtPosition(position).toString();

                        if(s.equals("直方体")){
                            inputID.setVisibility(View.VISIBLE);
                        }else{
                            inputID.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                }
        );


        // ---------- 計算ボタン ----------
        testButton.setOnClickListener(v -> {

            // ===== ① 外側形状と外側サイズの取得 =====
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

            // 内側形状の決定
            String innerSelected = innerShapeSpinner.getSelectedItem().toString();

            String innerShape;

            if(innerSelected.equals("円柱")){
                innerShape = "cylinder";
            }else if(innerSelected.equals("直方体")){
                innerShape = "box";
            }else{
                innerShape = "cone";
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

            // ===== ② くり抜き・個数・ロス率などの取得 =====
            String mixStr = inputMixWater.getText().toString();
            String yieldStr = inputYield.getText().toString();

            if(mixStr.isEmpty() || yieldStr.isEmpty()){
                resultText.setText("素材情報を入力してください");
                return;
            }

            double mixWater = Double.parseDouble(mixStr);
            double yieldVal = Double.parseDouble(yieldStr);

            int count = 1;
            double loss = 0;

            if(!inputCount.getText().toString().isEmpty()){
                count = Integer.parseInt(inputCount.getText().toString());
            }

            if(!inputLoss.getText().toString().isEmpty()){
                loss = Double.parseDouble(inputLoss.getText().toString());
            }

            boolean hollow = checkHollow.isChecked();

            double iw = 0;
            double id2 = 0;
            double ih = 0;

            if(hollow){

                if(inputIW.getText().toString().isEmpty()
                        || inputIH.getText().toString().isEmpty()){
                    resultText.setText("内径と内高さを入力してください");
                    return;
                }

                iw = Double.parseDouble(inputIW.getText().toString());
                ih = Double.parseDouble(inputIH.getText().toString());

                if(innerShape.equals("box")){
                    if(inputID.getText().toString().isEmpty()){
                        resultText.setText("内奥行きを入力してください");
                        return;
                    }

                    id2 = Double.parseDouble(inputID.getText().toString());
                }
            }


            // ===== ③ 計算して結果を表示 =====
            Result r = calcPlaster(
                    shape,
                    innerShape,
                    w, d, h,
                    hollow,
                    iw, id2, ih,
                    count,
                    loss,
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

        // ---------- くり抜きON/OFFで内側UI表示切替 ----------
        checkHollow.setOnCheckedChangeListener((b, checked) -> {
            if(checked){
                innerShapeSpinner.setVisibility(View.VISIBLE);
                inputIW.setVisibility(View.VISIBLE);
                inputIH.setVisibility(View.VISIBLE);
            }else{
                innerShapeSpinner.setVisibility(View.GONE);
                inputIW.setVisibility(View.GONE);
                inputIH.setVisibility(View.GONE);
                inputD.setVisibility(View.GONE); // 念のため
            }
        });

    }


    // ---------- 体積計算 ----------
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

    // ---------- 石膏・水量計算ロジック本体 ----------
    private Result calcPlaster(
            String shape,
            String innerShape,
            double w, double d, double h,
            boolean hollow,
            double iw, double id, double ih,
            int count,
            double lossPercent,
            double yieldVal,
            double mixWater
    )
{
        double vol = volume(shape, w, d, h);

    if(hollow){
        vol -= volume(innerShape, iw, id, ih);
    }


        vol *= count * (1.0 + lossPercent / 100.0);

        double plasterKg = vol / yieldVal;
        double waterMl = plasterKg * mixWater;

        return new Result(vol, plasterKg, waterMl);
    }

    // ---------- 計算結果格納用クラス ----------
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


