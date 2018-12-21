package my.edu.taruc.lab3_3input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        textViewPremium = findViewById(R.id.textViewPremium);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.age_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position=" + position, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public void calculatePremium(View view)
    {
        int premium=0;
        int ageGroup;
        ageGroup = spinnerAge.getSelectedItemPosition();
        int gender = radioGroupGender.getCheckedRadioButtonId();

        switch(ageGroup){
            case 0:
            premium = 50;
            break;
            case 1:
            premium = 55;
            break;
            case 2:
            premium = 60;
            if(gender == R.id.radioButtonMale)
            {
                premium +=50;
            }
            break;
            case 3:
            premium = 70;
            if(gender == R.id.radioButtonMale)
            {
                premium +=100;
            }
            if(checkBoxSmoker.isChecked())
            {
                premium +=100;
            }
            break;
            case 4:
            premium = 120;
            if(gender == R.id.radioButtonMale)
            {
                premium +=100;
            }
            if(checkBoxSmoker.isChecked())
            {
                premium +=150;
            }
            break;
            case 5:
            premium = 160;
            if(gender == R.id.radioButtonMale)
            {
                premium +=50;
            }
            if(checkBoxSmoker.isChecked())
            {
                premium +=150;
            }
            break;
            case 6:
            premium = 200;
            if(checkBoxSmoker.isChecked())
            {
                premium +=250;
            }
            break;
            case 7:
            premium = 250;
            if(checkBoxSmoker.isChecked())
            {
                premium +=250;
            }
            break;
        }

        textViewPremium.setText(getString(R.string.premium) + "= RM " + premium);

    }

    public void reset (View view)
    {
        spinnerAge.setSelection(-1); //-1 means not selected
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText("");
    }
}
