package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.text.TextWatcher;
import android.text.Editable;

public class MainActivity extends AppCompatActivity {
    TextView gpaText;
    EditText editText1, editText2, editText3, editText4, editText5;
    Button gpaButton;
    boolean calculated = false;
    double gpa;
    View background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gpaText = findViewById(R.id.textViewGPA);
        gpaButton = findViewById(R.id.button);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        background = this.getWindow().getDecorView();
    }

    public void clearAll() {
        editText1.setText(getResources().getString(R.string.blank));
        editText2.setText(getResources().getString(R.string.blank));
        editText3.setText(getResources().getString(R.string.blank));
        editText4.setText(getResources().getString(R.string.blank));
        editText5.setText(getResources().getString(R.string.blank));
        gpaText.setText(getResources().getString(R.string.blank));
        background.setBackgroundColor(getResources().getColor(R.color.white));
        gpaButton.setText(getResources().getString(R.string.compute_gpa));
    }

    public void compute(View view) {
        if(calculated) {
            if(!(editText1.getText().toString().isEmpty() && editText2.getText().toString().isEmpty() && editText3.getText().toString().isEmpty() && editText4.getText().toString().isEmpty() && editText5.getText().toString().isEmpty())) {
                calculated = false;
                gpa = (Double.parseDouble(editText1.getText().toString())
                        + Double.parseDouble(editText2.getText().toString())
                        + Double.parseDouble(editText3.getText().toString())
                        + Double.parseDouble(editText4.getText().toString())
                        + Double.parseDouble(editText5.getText().toString()))/5;
                if(gpa <= 60) {
                    background.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(gpa > 60 && gpa < 80) {
                    background.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else if(gpa >= 80) {
                    background.setBackgroundColor(getResources().getColor(R.color.green));
                }
                gpaButton.setText(getResources().getString(R.string.clear));
            }
        }
        else {
            calculated = true;
            clearAll();
        }
    }

    /*TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(!calculated) {
                calculated = true;
                clearAll();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    editText1.addTextChangedListener(watcher);
    editText2.addTextChangedListener(watcher);
    editText3.addTextChangedListener(watcher);
    editText3.addTextChangedListener(watcher);
    editText4.addTextChangedListener(watcher);*/
}
