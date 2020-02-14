package com.example.triangrandsquarenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class numbers{
        int number;

        boolean isSquare() {
            double sr = Math.sqrt(number);
            if(sr==Math.floor(sr))
                return true;
            else
                return false;
        }
        boolean isTriangle(){
            int x = 1;
            int tnumber = 1;
            while(number>tnumber)
            {
                x++;
                tnumber = x+tnumber;
            }
            if(number==tnumber)
                return true;
            else
                return false;

        }
    }

    public void testNumber(View view)
    {

        Log.i("info","button pressed");
        EditText number = (EditText) findViewById(R.id.editText2);


        String message;
        if(number.getText().toString().isEmpty())
            message ="please enter a number";
        else {
            int val = Integer.parseInt( number.getText().toString() );
            numbers newnumber = new numbers();

            newnumber.number = val;

            message = number.getText().toString() + "  ";
            if (newnumber.isSquare() == true && newnumber.isTriangle() == true)
                message += "is both square and triangular";
            if (newnumber.isSquare() == false && newnumber.isTriangle() == true)
                message += "is only triangular";
            if (newnumber.isSquare() == true && newnumber.isTriangle() == false)
                message += "is only square";
            if (newnumber.isSquare() == false && newnumber.isTriangle() == false)
                message += "is neighter square nor triangular";

        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
