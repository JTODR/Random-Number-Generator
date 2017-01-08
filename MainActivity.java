package com.joeysapp.joseph.numbergenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title_app = "Simple Number Generator";
        setTitle(title_app);
        setContentView(R.layout.activity_main);

        Button GenerateNumButton;
        GenerateNumButton = (Button) findViewById(R.id.GenerateNumButton);

        GenerateNumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //In here we want to write what we want happening when the button gets clicked
                EditText Lower_Num = (EditText) findViewById(R.id.LowerNum);
                EditText Upper_Num = (EditText) findViewById(R.id.UpperNum);

                //converting input to a string
                String lower_number_string = Lower_Num.getText().toString();
                String upper_number_string = Upper_Num.getText().toString();

                //check strings are not empty
                if(lower_number_string.matches("") || upper_number_string.matches("")) {

                    String no_input = "Input numbers into both text fields";
                    Toast.makeText(MainActivity.this, no_input, Toast.LENGTH_LONG).show();

                }

                else {
                    int lower_number = 0;
                    int upper_number = 0;

                    //converting input strings to ints
                    lower_number = Integer.parseInt(lower_number_string);
                    upper_number = Integer.parseInt(upper_number_string);

                    if (upper_number != 0) {

                        if (upper_number > lower_number) {
                            //Making the random number
                            Random rn = new Random();
                            int range = upper_number - lower_number + 1;
                            final int random_number = rn.nextInt(range) + lower_number;
                            String random_str = String.valueOf(random_number);

                            //Displaying the number
                            TextView DisplayTextView = (TextView) findViewById(R.id.DisplayTextView);
                            DisplayTextView.setText(random_str);

                        } else {
                            String invalid_upper_number = "Lower number cannot be greater than upper number";
                            Toast.makeText(MainActivity.this, invalid_upper_number, Toast.LENGTH_LONG).show();
                        }
                    } else {
                        String invalid_number = "Upper number cannot be 0";
                        Toast.makeText(MainActivity.this, invalid_number, Toast.LENGTH_LONG).show();
                    }
                }

            }

        });


    }

}
