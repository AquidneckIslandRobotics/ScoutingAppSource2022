package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Scoring extends AppCompatActivity {

    private TextView highCounterTxt;
    private Button minusHighPts;
    private Button plusHighPts;
    public int highCounter = 0;

    private TextView lowCounterTxt;
    private Button minusLowPts;
    private Button plusLowPts;
    public int lowCounter = 0;

    private Button intoEndgame;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plusHighPts:
                    plusHigh();
                    break;
                case R.id.minusHighPts:
                    minusHigh();
                    break;

                case R.id.plusLowPts:
                    plusLow();
                    break;
                case R.id.minusLowPts:
                    minusLow();
                    break;
                case R.id.IntoEndgame:
                    IntoEndgame();
                    break;

            }
        }
    };

    RadioGroup RungGroup;
    RadioButton RungButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        highCounterTxt = (TextView) findViewById(R.id.highCounterTxt);
        minusHighPts = (Button) findViewById(R.id.minusHighPts);
        minusHighPts.setOnClickListener(clickListener);
        plusHighPts = (Button) findViewById(R.id.plusHighPts);
        plusHighPts.setOnClickListener(clickListener);

        lowCounterTxt = (TextView) findViewById(R.id.lowCounterTxt);
        plusLowPts = (Button) findViewById(R.id.plusLowPts);
        plusLowPts.setOnClickListener(clickListener);
        minusLowPts = (Button) findViewById(R.id.minusLowPts);
        minusLowPts.setOnClickListener(clickListener);

        intoEndgame = (Button) findViewById(R.id.IntoEndgame);
        intoEndgame.setOnClickListener(clickListener);

        RungGroup = findViewById(R.id.Rungs);
    }


    private void plusHigh(){
        highCounter++;
        highCounterTxt.setText(String.valueOf(highCounter));
    }
    private void minusHigh(){
        highCounter--;
        highCounterTxt.setText((String.valueOf(highCounter)));
    }

    private void plusLow(){
        lowCounter++;
        lowCounterTxt.setText(String.valueOf(lowCounter));
    }
    private void  minusLow(){
        lowCounter--;
        lowCounterTxt.setText(String.valueOf(lowCounter));
    }

    public void IntoEndgame() {
        int rungId = RungGroup.getCheckedRadioButtonId();
        RungButtons = findViewById(rungId);
        String rung = (String) RungButtons.getText();
        int rungPts = 0;
        if (rung.equals("Low (4)")){
            rungPts = 4;
        }else if (rung.equals("Mid (6)")) {
            rungPts = 6;
        }else if (rung.equals("High (10)")){
            rungPts = 10;
        }else if (rung.equals("Transversal (15)")){
            rungPts = 15;
        }else{
            rungPts = 0;
        }
        System.out.println(rungPts);
        String highCounterStr = String.valueOf(highCounter);
        String lowCounterStr = String.valueOf(lowCounter);
        String rungPtsStr = String.valueOf(rungPts);

        if (highCounterStr.equals("")){highCounterStr = "0";}
        if (lowCounterStr.equals("")){lowCounterStr = "0";}

        Intent intent = new Intent(this, endgame.class);
        String name = getIntent().getStringExtra("perName");
        String matchNum = getIntent().getStringExtra("matchNum");
        String teamNum = getIntent().getStringExtra("teamNum");
        String alliance = getIntent().getStringExtra("alliance");
        String highCounterAuto = getIntent().getStringExtra("highAuto");
        String lowCounterAuto = getIntent().getStringExtra("lowAuto");
        String driveAuto = getIntent().getStringExtra("drive");

        intent.putExtra("perName", name);
        intent.putExtra("matchNum", matchNum);
        intent.putExtra("teamNum", teamNum);
        intent.putExtra("alliance", alliance);
        intent.putExtra("highAuto", highCounterAuto);
        intent.putExtra("lowAuto", lowCounterAuto);
        intent.putExtra("drive", driveAuto);
        intent.putExtra("highTele", highCounterStr);
        intent.putExtra("lowTele", lowCounterStr);
        intent.putExtra("rungs", rung);
        intent.putExtra("rungPts", rungPtsStr);

        startActivity(intent);

    }

    public void RungSpots(View v) {
        int rungId = RungGroup.getCheckedRadioButtonId();
        RungButtons = findViewById(rungId);
        System.out.println(RungButtons.getText());
    }
}