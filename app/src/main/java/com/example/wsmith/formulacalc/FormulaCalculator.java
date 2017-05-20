package com.example.wsmith.formulacalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math;

public class FormulaCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_calculator);

    }

    public void onClick_Calculate(View view) {
        // get references to the views

        EditText txtNumSelections = (EditText) findViewById(R.id.txtNumChoices);
        EditText txtNumSuccesses = (EditText) findViewById(R.id.txtNumSuccesses);
        EditText txtProbSuccess = (EditText) findViewById(R.id.txtSuccessProbability);


        int numSelections, numSuccesses;
        double probSuccesses;
        String strNumSelections = txtNumSelections.getText().toString();
        if (!strNumSelections.isEmpty())
            numSelections = Integer.parseInt(strNumSelections);
        else
            numSelections = 0;

        String strNumSuccesses = txtNumSuccesses.getText().toString();
        if (!strNumSelections.isEmpty())
            numSuccesses = Integer.parseInt(strNumSuccesses);
        else
            numSuccesses = 0;

        String strProbSuccesses = txtProbSuccess.getText().toString();
        if (!strProbSuccesses.isEmpty())
            probSuccesses = Double.parseDouble(strProbSuccesses);
        else
            probSuccesses = 0;


        TextView txtOutputField = (TextView) findViewById(R.id.txtVwResult);

        //txtOutputField.setText("test success!!! " + numSelections + " "
        //                       + numSuccesses + " " + probSuccesses);

        txtOutputField.setText(
                Double.toString(binomialProbability(numSelections, numSuccesses, probSuccesses)));
    }

    public static double binomialProbability (int totalNum, int numSelect, double probSuccess)
    {
        if (numSelect>totalNum || totalNum <0 || numSelect<0 || probSuccess < 0 || probSuccess > 1)
            return Double.NaN;

        return n_choose_r(totalNum, numSelect) * Math.pow(probSuccess,numSelect) *
                    Math.pow(1-probSuccess, totalNum-numSelect);

    }

    public static int factorial( int num )
    {
        if( num==0)
                return 0;
        if (num==1)
            return 1;

        return num * factorial(num-1);
    }

    public static int n_choose_r(int n, int r)
    {
        if(n==r || r==0)
            return 1;

        if(r>n)
            return 0;


        return factorial (n) / ( factorial(r)*factorial(n-r) );
    }
}
