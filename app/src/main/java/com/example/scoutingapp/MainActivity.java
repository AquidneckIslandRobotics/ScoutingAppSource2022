package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;


    private Button button;
    private Spinner spinnerName, spinnerTeam;
    public TextView matchNum, perName, teamNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerName = findViewById(R.id.nameDropdown);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.names, R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.color_spinner_layout);
        spinnerName.setAdapter(adapter);

        Spinner spinnerTeam = (Spinner) findViewById(R.id.teamDropdown);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.teams, R.layout.color_spinner_layout);
        adapter1.setDropDownViewResource(R.layout.color_spinner_layout);
        spinnerTeam.setAdapter(adapter1);

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
            spinnerTeam = findViewById(R.id.teamDropdown);
            spinnerName = findViewById(R.id.nameDropdown);

        String alliance = radioButton.getText().toString();
        String perNameStr = spinnerName.getSelectedItem().toString();
        String teamNumStr = spinnerTeam.getSelectedItem().toString();
        String matchNumStr = matchNum.getText().toString();

        if (perNameStr.equals("Names")
        || teamNumStr.equals("Team Number")
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

            startActivity(intent);


        }
    }
    public void Alliance(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        }
}
