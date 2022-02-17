package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Auto extends AppCompatActivity {

    private TextView highCounterAutoTxt;
    private Button minusHighAutoPts;
    private Button plusHighAutoPts;
    private int highCounterAuto = 0;

    private TextView lowCounterAutoTxt;
    private Button minusLowAutoPts;
    private Button plusLowAutoPts;
    private int lowCounterAuto = 0;

    private Button FinishAuto;


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plusHighAutoPts:
                    System.out.println("sdkfkhsa");
                    plusHigh();
                    break;
                case R.id.minusHighAutoPts:
                    minusHigh();
                    break;
                case R.id.plusLowAutoPts:
                    plusLow();
                    break;
                case R.id.minusLowAutoPts:
                    minusLow();
                    break;
                case R.id.FinishAuto:
                    System.out.println("hhghghghghghghgghghghghhggh");
                    LeavingAuto();
                    break;
            }
        }
    };


    RadioGroup radioGroupDriving;
    RadioButton otherRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        radioGroupDriving = findViewById(R.id.RadioGroupDriving);


        highCounterAutoTxt = (TextView) findViewById(R.id.highCounterAutoTxt);
        minusHighAutoPts = (Button) findViewById(R.id.minusHighAutoPts);
        minusHighAutoPts.setOnClickListener(clickListener);
        plusHighAutoPts = (Button) findViewById(R.id.plusHighAutoPts);
        plusHighAutoPts.setOnClickListener(clickListener);

        lowCounterAutoTxt = (TextView) findViewById(R.id.lowCounterAutoTxt);
        minusLowAutoPts = (Button) findViewById(R.id.minusLowAutoPts);
        minusLowAutoPts.setOnClickListener(clickListener);
        plusLowAutoPts = (Button) findViewById(R.id.plusLowAutoPts);
        plusLowAutoPts.setOnClickListener(clickListener);

        FinishAuto = (Button) findViewById(R.id.FinishAuto);
        FinishAuto.setOnClickListener(clickListener);
    }

    public void SpotPicker(View v){

        int otherRadioId = radioGroupDriving.getCheckedRadioButtonId();
        otherRadioButton = findViewById(otherRadioId);
        System.out.println(otherRadioButton.getText());


    }

    private void plusHigh(){
        highCounterAuto++;
        highCounterAutoTxt.setText(String.valueOf(highCounterAuto));
    }
    private void minusHigh(){
        highCounterAuto--;
        highCounterAutoTxt.setText(String.valueOf(highCounterAuto));
    }

    private void plusLow(){
        lowCounterAuto++;
        lowCounterAutoTxt.setText(String.valueOf(lowCounterAuto));
    }
    private void minusLow(){
        lowCounterAuto--;
        lowCounterAutoTxt.setText(String.valueOf(lowCounterAuto));
    }

    public void LeavingAuto() {
        int otherRadioId = radioGroupDriving.getCheckedRadioButtonId();
        otherRadioButton = findViewById(otherRadioId);
        String driveAuto = (String) otherRadioButton.getText();
        String highCounterAutoStr = String.valueOf(highCounterAuto);
        String lowCounterAutoStr = String.valueOf(lowCounterAuto);




        Intent intent = new Intent(this, Scoring.class);
        String name = getIntent().getStringExtra("perName");
        String matchNum = getIntent().getStringExtra("matchNum");
        String teamNum = getIntent().getStringExtra("teamNum");
        String alliance = getIntent().getStringExtra("alliance");

        intent.putExtra("perName", name);
        intent.putExtra("matchNum", matchNum);
        intent.putExtra("teamNum", teamNum);
        intent.putExtra("alliance", alliance);
        intent.putExtra("highAuto", highCounterAutoStr);
        intent.putExtra("lowAuto", lowCounterAutoStr);
        intent.putExtra("drive", driveAuto);
        startActivity(intent);


        System.out.println(name);
        System.out.println(matchNum);
        System.out.println(teamNum);

        startActivity(intent);
    }
}