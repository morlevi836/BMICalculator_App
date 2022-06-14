package com.example.bmicalculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    Spinner spinner;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.body_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner = findViewById(R.id.bodyTypeSpinner);
        spinner.setAdapter(adapter);

        //Links the elements to their matching XML elements
        male = findViewById(R.id.maleButton);
        female = findViewById(R.id.femaleButton);
        fullNameText = findViewById(R.id.fullNameText);
        ageText = findViewById(R.id.ageText);
        weight = findViewById(R.id.weightText);
        heightSlider = findViewById(R.id.heightSlider);
        calculateButton = findViewById(R.id.calculate);
        result = spinner.toString();
        intent = getIntent();
        //setting the Calculate button's click listener
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //in case the user didn't enter the required fields to the system.
        if (weight.getText().toString().equals("") || ageText.getText().toString().equals(""))
            Toast.makeText(this, getResources().getString(R.string.errorMessage), Toast.LENGTH_SHORT).show();
        else {
            //setting up 'slimness' variable
            slimness = findSelectedButton(result);
            //handing the data to ResultActivity.
            intent.putExtra("height", (int) heightSlider.getValue());
            intent.putExtra("slimness", slimness);
            intent.putExtra("weight", Double.parseDouble(weight.getText().toString()));
            intent.setClass(this, ResultActivity.class);
            startActivity(intent);
        }
    }

    private Double findSelectedButton(String bodyType) {
        //getting the button that's been clicked
        if (bodyType.equals("small")) {
            return 0.9;
        } else if (bodyType.equals("medium")) {
            return 1.0;
        } else
            return 1.1;
    }
}