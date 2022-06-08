package com.example.bmicalculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    Button calculateButton;
    RadioButton male, female;
    EditText fullNameText, ageText;
    Intent intent;
    Double slimness;
    EditText weight;
    Slider heightSlider;
    Button submit;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Spinner spinner = findViewById(R.id.bodyType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.body_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        //Links the right elements to the right elements in XML
        calculateButton = findViewById(R.id.calculate);

        male = findViewById(R.id.maleButton);
        female = findViewById(R.id.femaleButton);
        fullNameText = findViewById(R.id.fullNameText);
        ageText = findViewById(R.id.ageText);
        intent = getIntent();
        weight = findViewById(R.id.weightText);
        heightSlider = findViewById(R.id.heightSlider);

        //setting click listener to the calculate button
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //in case the user didn't put any data in the text field
        if (weight.getText().toString().equals("") || fullNameText.getText().toString().equals("") || ageText.getText().toString().equals(""))
            Toast.makeText(this, getResources().getString(R.string.errorMessage), Toast.LENGTH_SHORT).show();
        else {
            //setting up the 'slimness' variable
            slimness = findSelectedButton(group.getCheckedRadioButtonId());
            //pass the data field to the ResultActivity activity.
            intent.putExtra("height", (int) heightSlider.getValue());
            intent.putExtra("slimness", slimness);
            intent.putExtra("weight", Double.parseDouble(weight.getText().toString()));
            intent.setClass(this, ResultActivity.class);
            startActivity(intent);
            //closing the current activity
            finish();
        }
    }

    private Double findSelectedButton(int checkedRadioButtonId) {
        //getting the button that is benn checked
        if (checkedRadioButtonId == R.id.smallButton) {
            return 0.9;
        } else if (checkedRadioButtonId == R.id.mediumButton) {
            return 1.0;
        } else
            return 1.1;
    }
}