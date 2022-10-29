package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.text.format.DateFormat;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class endgame extends AppCompatActivity {

    private Button finish;
    private EditText matchNum, teamNum, perName, autoHigh, autoLow, teleHigh, teleLow;
    private RadioButton alliance, drive, rung;
    String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);





        Button Finish = findViewById(R.id.finishButton);
        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {
                        main();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                finish();
            }
        });


    }

    public void main() throws IOException {
        System.out.println("THIS BEAN IS WOOOORRRKKKIINNNGGG");
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
        String disabled = getIntent().getStringExtra("disabled");
        String penalties = getIntent().getStringExtra("penalties");

        try {
            File root = new File("/sdcard/Documents");
            if (!root.exists())
            {
                root.mkdir();
            }


            int highCounterAutoInt = (Integer.parseInt(highCounterAuto))*4;
            int lowCounterAutoInt = (Integer.parseInt(lowCounterAuto))*2;
            int highTeleInt = (Integer.parseInt(highTele))*2;
            int lowTeleInt = Integer.parseInt(lowTele);
            int rungPtsInt = Integer.parseInt(rungPts);
            int driveAutoInt = 0;
            if (driveAuto.equals("Drove")){driveAutoInt = 2;}
            int total = highCounterAutoInt+lowCounterAutoInt+highTeleInt+lowTeleInt+rungPtsInt+driveAutoInt;

            int autoTotal = highCounterAutoInt+lowCounterAutoInt;
            String autoTotalString = Integer.toString(autoTotal);
            int teleTotal = highTeleInt+lowTeleInt;
            String teleTotalString = Integer.toString(teleTotal);
            int autoClimb = autoTotal + rungPtsInt;
            String autoClimbString = Integer.toString(autoClimb);

            File filepath = new File(root, matchNum+"_"+teamNum+".csv");
            FileWriter writer = new FileWriter(filepath);
            System.out.println("what");
            writer.append("'"+teamNum+",");
            writer.append(matchNum+",");
            writer.append(name+",");
            writer.append(alliance+",");
            writer.append(highCounterAutoInt+",");
            writer.append(lowCounterAutoInt+",");
            writer.append(driveAutoInt+",");
            writer.append(highTeleInt+",");
            writer.append(lowTele+",");
            writer.append(rungPts);
            writer.append(","+disabled);
            writer.append(","+penalties);
            writer.append(","+total);
            writer.append(", ,'");
            writer.append(teamNum+",");
            writer.append(autoTotalString+",");
            writer.append(rungPts);
            writer.append(","+autoClimbString+",");
            writer.append(teleTotalString);
            writer.append(","+total);
            writer.flush();
            writer.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void finish(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}