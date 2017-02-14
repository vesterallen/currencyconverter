package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText inputAmountField;
    private double inputAmt;
    private double ausD=1.34;
    private double canD=1.32;
    private double indR=68.14;
    private double briP=0.32;
    private double convRateUS;
    private double convRateGB;
    private Button convertButton;
    private Button clearButton;
    private EditText outputAmountField;
    RadioGroup inputRadioGroup;
    RadioGroup outputRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            inputRadioGroup = (RadioGroup) findViewById(R.id.inputCurrencyType);
            outputRadioGroup = (RadioGroup) findViewById(R.id.outputCurrencyType);
            convertButton = (Button) findViewById(R.id.convert);
            clearButton = (Button) findViewById(R.id.clear);
            inputAmountField = (EditText) findViewById(R.id.inputAmount);
            outputAmountField = (EditText) findViewById(R.id.convertedAmount);
            convertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!inputAmountField.getText().toString().matches(".*\\d+.*")){
                        Toast.makeText(MainActivity.this,"Enter a proper numeric value",Toast.LENGTH_LONG).show();

                    }
                    else {
                        inputAmt = Double.parseDouble(inputAmountField.getText().toString());
                    if (inputRadioGroup.getCheckedRadioButtonId() == R.id.ausDollar) {
                        convRateUS = inputAmt / ausD;
                        if (outputRadioGroup.getCheckedRadioButtonId() == R.id.briPound) {
                            convRateGB = convRateUS / briP;
                            outputAmountField.setText(String.valueOf(convRateGB));
                        } else {
                            Log.d("mass", String.valueOf(inputAmt));
                            outputAmountField.setText(String.valueOf(convRateUS));
                        }
                    } else if (inputRadioGroup.getCheckedRadioButtonId() == R.id.canDollar) {
                        convRateUS = inputAmt / canD;
                        if (outputRadioGroup.getCheckedRadioButtonId() == R.id.briPound) {
                            convRateGB = convRateUS / briP;
                            outputAmountField.setText(String.valueOf(convRateGB));
                        } else {
                            outputAmountField.setText(String.valueOf(convRateUS));
                        }
                    } else if (inputRadioGroup.getCheckedRadioButtonId() == R.id.indRupee) {
                        convRateUS = inputAmt / indR;
                        if (outputRadioGroup.getCheckedRadioButtonId() == R.id.briPound) {
                            convRateGB = convRateUS / briP;
                            outputAmountField.setText(String.valueOf(convRateGB));
                        } else {
                            outputAmountField.setText(String.valueOf(convRateUS));
                        }
                    }
                }
                }
            });
            clearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inputAmountField.setText("");
                    outputAmountField.setText("");
                    inputRadioGroup.clearCheck();
                    outputRadioGroup.clearCheck();
                }
            });


    }
}
