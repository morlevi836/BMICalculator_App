package com.example.bmicalculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    int age;
    double actualWeight, idealWeight, bmiValue, height, slimness;
    String WeightStatus;
    TextView bmiText, statusText, MessageDetails, MessageDetails2, MessageDetails3;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Links the elements
        bmiText = findViewById(R.id.bmiText);
        statusText = findViewById(R.id.statusText);
        MessageDetails = findViewById(R.id.messageText);
        MessageDetails2 = findViewById(R.id.messageText2);
        MessageDetails3 = findViewById(R.id.messageText3);
        homeButton = findViewById(R.id.mainPageButt);

        //getting all the data from the intent.
        age = getIntent().getIntExtra("age", 0);
        slimness = getIntent().getDoubleExtra("slimness", 0);
        actualWeight = getIntent().getDoubleExtra("weight", 0);
        height = (getIntent().getIntExtra("height", 0)) / 100.0;

        //calculation the BMI.
        bmiValue = actualWeight / (height * height);

        //calculation the ideal weight.
        idealWeight = ((height * 100) - 100 + (age / 10.0)) * 0.9 * slimness;

        //changing the bmi text view.
        bmiText.setText(getResources().getString(R.string.bmi_text, bmiValue));

        //calculation and changing the weight status text view.
        statusText(bmiValue);

        //writing a message to the user that compares the ideal weight to the current weight
        updateMessage(actualWeight, idealWeight);

        //setting click listener to the 'mainPage' button
        homeButton.setOnClickListener(e -> {
            //switching to the MainActivity.
            startActivity(new Intent(this, MainActivity.class));
            //closing the current activity
            finish();
        });
    }

    private void updateMessage(double actualWeight, double idealWeight) {
        //updating the message text view
        MessageDetails.setText(getResources().getString(R.string.message_text, actualWeight));
        MessageDetails2.setText(getResources().getString(R.string.message_text2, idealWeight));

        switch (WeightStatus) {
            case "Anorexic":
            case "Underweight":
                MessageDetails3.setText(getResources().getString(R.string.message_text3_1));
                break;
            case "Normal":
                MessageDetails3.setText(getResources().getString(R.string.message_text3_2));
                break;
            case "Overweight":
            case "Obese":
            case "Extreme Obese":
                MessageDetails3.setText(getResources().getString(R.string.message_text3_3));
                break;
        }
    }

    private void statusText(double bmiValue) {
        //calculation the weight status based on the bmi.
        if (bmiValue < 15)
            WeightStatus = "Anorexic";
        else if (15 <= bmiValue && bmiValue < 18.5)
            WeightStatus = "Underweight";
        else if (18.5 <= bmiValue && bmiValue < 25)
            WeightStatus = "Normal";
        else if (25 <= bmiValue && bmiValue < 30)
            WeightStatus = "Overweight";
        else if (30 <= bmiValue && bmiValue < 35)
            WeightStatus = "Obese";
        else if (35 <= bmiValue)
            WeightStatus = "Extreme Obese";

        //changing the weight status text view.
        statusText.setText(getResources().getString(R.string.status_text, WeightStatus));
    }
}