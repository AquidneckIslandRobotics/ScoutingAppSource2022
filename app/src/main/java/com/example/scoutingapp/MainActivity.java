package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;


    private Button button;

    private TextView matchNum, perName, teamNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        radioGroup = findViewById(R.id.RadioGroup);
        textView = findViewById(R.id.text_view_selected);



        Button StartMatch = findViewById(R.id.StartMatch);
        StartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textView.setText("Alliance " + radioButton.getText() );
                StartingMatch();







            button = (Button) findViewById(R.id.StartMatch);
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartingMatch();
            }
                });
            }

        });
    }
    public void StartingMatch() {
        matchNum = findViewById(R.id.MatchNumber);
        perName = findViewById(R.id.Name);
        teamNum = findViewById(R.id.TeamNumber);

        String alliance = radioButton.getText().toString();
        String perNameStr = perName.getText().toString();
        String teamNumStr = teamNum.getText().toString();
        String matchNumStr = matchNum.getText().toString();

        if (perNameStr.equals("")
        || teamNumStr.equals("")
        ||matchNumStr.equals("")){
            Toast.makeText(MainActivity.this, "NOT ALL FEILDS FILLED", Toast.LENGTH_SHORT).show();
        }else {

            Intent intent = new Intent(MainActivity.this, Auto.class);
            intent.putExtra("perName", perNameStr);
            intent.putExtra("matchNum", matchNumStr);
            intent.putExtra("teamNum", teamNumStr);
            intent.putExtra("alliance", alliance);

            int matchNumInt = Integer.parseInt(matchNumStr);
            matchNumInt++;
            matchNum.setText(String.valueOf(matchNumInt));
            teamNum.setText("");

            startActivity(intent);


        }
    }
    public void Alliance(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        }
}
