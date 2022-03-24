package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class postData extends AppCompatActivity {

    RadioGroup DisabledGroup;
    RadioButton DisabledButtons;
    RadioGroup PenaltyGroup;
    RadioButton PenaltyButtons;
    Button intoSubmit;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.toSubmit:
                    toSubmit();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);

        DisabledGroup = findViewById(R.id.DisabledGroup);
        PenaltyGroup = findViewById(R.id.Penalties);

        intoSubmit = findViewById(R.id.toSubmit);
        intoSubmit.setOnClickListener(clickListener);
    }



    public void toSubmit(){
        int disId = DisabledGroup.getCheckedRadioButtonId();
        DisabledButtons = findViewById(disId);
        String dis = (String) DisabledButtons.getText();
        int disPts = 0;
        if (dis.equals("Disabled")){
            disPts = 1;
        }
        String disPtsStr = String.valueOf(disPts);

        int PnPts = PenaltyGroup.getCheckedRadioButtonId();
        PenaltyButtons = findViewById(PnPts);
        String pntly = (String) PenaltyButtons.getText();
        int pntlyPts = 0;
        if (pntly.equals("Penalties")){
            pntlyPts = 1;
        }
        String pntlyPtsStr = String.valueOf(pntlyPts);
        Intent intent = new Intent(this, endgame.class);
        String name = getIntent().getStringExtra("perName");
        String matchNum = getIntent().getStringExtra("matchNum");
        String teamNum = getIntent().getStringExtra("teamNum");
        String alliance = getIntent().getStringExtra("alliance");
        String highCounterAuto = getIntent().getStringExtra("highAuto");
        String lowCounterAuto = getIntent().getStringExtra("lowAuto");
        String driveAuto = getIntent().getStringExtra("drive");
        String highTele = getIntent().getStringExtra("highTele");
        String lowTele = getIntent().getStringExtra("lowTele");
        String rungs = getIntent().getStringExtra("rungs");
        String rungPts = getIntent().getStringExtra("rungPts");


        intent.putExtra("perName", name);
        intent.putExtra("matchNum", matchNum);
        intent.putExtra("teamNum", teamNum);
        intent.putExtra("alliance", alliance);
        intent.putExtra("highAuto", highCounterAuto);
        intent.putExtra("lowAuto", lowCounterAuto);
        intent.putExtra("drive", driveAuto);
        intent.putExtra("highTele", highTele);
        intent.putExtra("lowTele", lowTele);
        intent.putExtra("rungs", rungs);
        intent.putExtra("rungPts", rungPts);
        intent.putExtra("disabled", disPtsStr);
        intent.putExtra("penalties", pntlyPtsStr);

        startActivity(intent);
    }
}