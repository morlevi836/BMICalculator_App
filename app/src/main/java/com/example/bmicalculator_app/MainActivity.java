/*
Exercise 2 android
David Gruzmark ID 324825454 Davidgro100@gmail.com
Mor Levi ID 21875207, Morlevimail@gmail.com
David - Second year, Computer Science Department - Ashkelon College.
Mor - Second year, Computer Science Department - Ashkelon College.

Assignment details:
Writing an Android application that calculates the BMI of a person based on weight, height and body type.
It also calculates your ideal weight and gives you some advice on how to get there.
The user has to enter all the details to get to the results. Otherwise, he gets a toast message telling him to fill everything.

 Algorithm:
BMI = Weight / Height^2 .
The weight and the height are given by the user.
Ideal weight = (height - 100 + (age / 10)) * 0.9 * slimness.
Slimness is calculated by body-frame: small =  0.9, medium = 1, large = 1.1.
The formulas apply for both genders.

Sources:
BMI formula: https://en.wikipedia.org/wiki/Body_mass_index#cite_ref-nhsob_10-0
Ideal weight formula: https://www.vcalc.com/wiki/MichaelBartmess/CREFF+Formula

Main Goals:
Using android elements (TextView, EditText, buttons, sliders, radio buttons etc.).
learning to work with XML files to design the project.
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

        //Links the elements to their matching XML elements
        startButton = findViewById(R.id.startButton);
        quitButton = findViewById(R.id.quitButton);

        //setting click listener to the start button
        startButton.setOnClickListener(e -> {
            //Defining intent element to switch to InfoActivity.
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        });

        //setting the quit button's click listener
        quitButton.setOnClickListener(e -> finishAffinity());
    }
}