package com.example.kpilszak.southafricanid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String idNumber = etID.getText().toString().trim();
                String dateOfBirth = idNumber.substring(0, 6);
                int genderNumber = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if (genderNumber < 5){
                    sGender = getString(R.string.female);
                } else {
                    sGender = getString(R.string.male);
                }
                int nationalityNumber = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if (nationalityNumber == 0) {
                    sNationality = getString(R.string.SACitizen);
                } else {
                    sNationality = getString(R.string.permanentResident);
                }
                String textResult = "\n" + getString(R.string.dateOfBirth) + dateOfBirth + "\n\n" +
                        getString(R.string.gender) + sGender + "\n\n" +
                        getString(R.string.nationality) + sNationality;
                tvResults.setText(textResult);
                tvResults.setVisibility(View.VISIBLE);
           }
        });
    }
}
