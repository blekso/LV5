package com.example.lv5_mihael_istvan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageMark = (ImageView) findViewById(R.id.ivMark);
        ImageView imageMusk = (ImageView) findViewById(R.id.ivMusk);
        ImageView imageSteve = (ImageView) findViewById(R.id.ivSteve);

        imageMark.setOnClickListener(this);
        imageMusk.setOnClickListener(this);
        imageSteve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImageView imageMark = (ImageView) findViewById(R.id.ivMark);
        ImageView imageMusk = (ImageView) findViewById(R.id.ivMusk);
        ImageView imageSteve = (ImageView) findViewById(R.id.ivSteve);

        switch(v.getId()){
            case R.id.ivMark:
                imageMark.setImageDrawable(null);
                break;
            case R.id.ivMusk:
                imageMusk.setImageDrawable(null);
                break;
            case R.id.ivSteve:
                imageSteve.setImageDrawable(null);
                break;
        }
    }

    public void addDescription(View v)
    {

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        if(radioGroup.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select description", Toast.LENGTH_SHORT).show();
        }
        else
        {
            EditText editText = findViewById(R.id.etAddDescription);
            String description = editText.getText().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);

            switch(selectedRadioButton.getId()) {
                case R.id.rbMusk:
                    TextView muskDescription = findViewById(R.id.tvMuskDescription);
                    muskDescription.setText(description);
                    break;
                case R.id.rbMark:
                    TextView markDescription = findViewById(R.id.tvMarkDescription);
                    markDescription.setText(description);
                    break;
                case R.id.rbSteve:
                    TextView steveDescription = findViewById(R.id.tvSteveDescription);
                    steveDescription.setText(description);
                    break;
            }
        }
    }

    public void inspirationQuote(View v) {
        Button btnInspiration = findViewById(R.id.btnInspiration);
        String[] quotes = {"Every moment is a fresh beginning", "Die with memories, not dreams", "Aspire to inspire before we expire", "Love For All, Hatred For None"};
        int rnd = new Random().nextInt(quotes.length);
        Toast.makeText(this, quotes[rnd], Toast.LENGTH_SHORT).show();
    }
}