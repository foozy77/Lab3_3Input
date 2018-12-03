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
        float premium=0;
        int ageGroup;
        ageGroup = spinnerAge.getSelectedItemPosition();
        int gender = radioGroupGender.getCheckedRadioButtonId();
        if(ageGroup ==0 )
        {
            premium = 50;
            //to calculate extra premium for male
        }
        else if (ageGroup ==1)
        {
            premium = 55;
        }
        else if(ageGroup == 2)
        {
            premium =60;
        }
        else if(ageGroup == 3 && gender == R.id.radioButtonMale && checkBoxSmoker.isChecked())
        {

        }
        else if(ageGroup==4)
        {

        }
        else if(ageGroup==5)
        {

        }
        else if(ageGroup==6)
        {

        }
        else if(ageGroup==7)
        {

        }
        else if(ageGroup==8)
        {

        }

        if(gender == R.id.radioButtonMale) {

            //to calculate extra premium for male
        }

        if(checkBoxSmoker.isChecked())
        {
            //TO DO  MANY CALCULATE EXTRA PREMIUM FOR SMOKER
        }

        textViewPremium.setText(getString(R.string.premium) + "= RM " + premium);

    }

    public void reset (View view)
    {
        spinnerAge.setSelection(-1); //-1 means not selected
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText(getString(R.string.premium));
    }
}
