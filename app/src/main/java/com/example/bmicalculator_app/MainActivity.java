/*
Exercise 2 android
Uriya Hadad ID 315571125 ooria47@gmail.com
Avioo Hadad ID 313559866 avioo360@gmail.com
Uriya - First year, Computer Science Department - Ashqelon College.
Avioo - Second year, Computer Science Department - Ashqelon College.

Assignment details:
Writing a program using Android application that calculates the BMI of a person base on the weight and height.
Also calculates the ideal weight of a human base on the height, age and body frame.

The user has to enter all the necessary information to calculate the BMI and the Ideal-weight,
else he will get a Toast message that will tell him to to that.

Algorithm:
Calculation the BMI by the formula: BMI = W / H^2.
The weight and the height are given by the user.
The ideal weight is calculated according to the

Creff formula: (height - 100 + (age / 10)) * 0.9 * slimness.
slimness is calculated by body-frame:
•	1 for normal body-type.
•	1.1 for large body-type.
•	0.9 for small body-type.
Notice that both formulas are for all gender.

Sources:
BMI formula: https://en.wikipedia.org/wiki/Body_mass_index#cite_ref-nhsob_10-0.
Ideal weight formula: https://www.vcalc.com/wiki/MichaelBartmess/CREFF+Formula.

Main Goals:
Using android elements (buttons, TextView, EditText, sliders, radio buttons etc.).
learning to work with the XML files that are existing in the project.
learning to switch from one activity to another and pass data along with it.
Using action listener to interact with the user.
 */

package com.example.bmicalculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startButton, quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Links the right elements to the right elements in XML
        startButton = findViewById(R.id.startButton);
        quitButton = findViewById(R.id.quitButton);

        //setting click listener to the quit button
        quitButton.setOnClickListener(e -> finish());

        //setting click listener to the start button
        startButton.setOnClickListener(view -> {
            //Defining intent element to switch to InfoActivity.
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
            //closing the current activity
            finish();
        });
    }
}