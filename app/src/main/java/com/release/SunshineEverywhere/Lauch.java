package com.release.SunshineEverywhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.release.SunshineEverywhere.R;

import java.util.ArrayList;

public class Lauch extends AppCompatActivity {

    PersonalInformation myInformation = new PersonalInformation(Lauch.this);
    String name = "";
    int age_type = 0;
    int sex_type = 0;
    int grade_type = 0;
    int faculty_type = 0;
    //short information = 0;

    Spinner YPS_Age_Spinner;
    Spinner YPS_Grade_Spinner;
    Spinner YPS_Faculty_Spinner;

    private void setSpinner() {
        YPS_Age_Spinner = findViewById(R.id.spinner);
        YPS_Grade_Spinner = findViewById(R.id.spinner2);
        YPS_Faculty_Spinner = findViewById(R.id.spinner3);
        ArrayList<String> Age_list = new ArrayList<String>();
        ArrayList<String> Grade_list = new ArrayList<String>();
        ArrayList<String> Faculty_list = new ArrayList<String>();

        Age_list.add("10岁及以下");
        Age_list.add("10~18岁");
        Age_list.add("19~30岁");
        Age_list.add("31~40岁");
        Age_list.add("41~50岁");
        Age_list.add("51~60岁");
        Age_list.add("60岁以上");

        Grade_list.add("本科生");
        Grade_list.add("研究生");
        Grade_list.add("博士生");
        Grade_list.add("博士后");

        Faculty_list.add("生物医学工程与仪器学院");
        Faculty_list.add("计算机科学与技术学院");

        final ArrayAdapter<String> Age_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Age_list);
        final ArrayAdapter<String> Grade_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade_list);
        final ArrayAdapter<String> Faculty_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Faculty_list);

        Age_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Faculty_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        YPS_Age_Spinner.setAdapter(Age_adapter);
        YPS_Grade_Spinner.setAdapter(Grade_adapter);
        YPS_Faculty_Spinner.setAdapter(Faculty_adapter);

        YPS_Age_Spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.setVisibility(View.VISIBLE);
                String result = Age_adapter.getItem(i);
                if (result.equals("10岁及以下"))
                    age_type = 0;
                else if (result.equals("10~18岁"))
                    age_type = 1;
                else if (result.equals("19~30岁"))
                    age_type = 2;
                else if (result.equals("31~40岁"))
                    age_type = 3;
                else if (result.equals("41~50岁"))
                    age_type = 4;
                else if (result.equals("51~60岁"))
                    age_type = 5;
                else
                    age_type = 6;
            }

            public void onNothingSelected(AdapterView<?> argO) {
                argO.setVisibility(View.VISIBLE);
                age_type = 0;
            }
        });

        YPS_Grade_Spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.setVisibility(View.VISIBLE);
                String result = Grade_adapter.getItem(i);
                if (result.equals("本科生"))
                    grade_type = 0;
                else if (result.equals("研究生"))
                    grade_type = 1;
                else if (result.equals("博士生"))
                    grade_type = 2;
                else
                    grade_type = 3;
            }

            public void onNothingSelected(AdapterView<?> argO) {
                argO.setVisibility(View.VISIBLE);
                grade_type = 0;
            }
        });

        YPS_Faculty_Spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.setVisibility(View.VISIBLE);
                String result = Grade_adapter.getItem(i);
                if (result.equals("信息学院"))
                    faculty_type = 0;
                else
                    faculty_type = 1;
            }

            public void onNothingSelected(AdapterView<?> argO) {
                argO.setVisibility(View.VISIBLE);
                faculty_type = 0;
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch);

        Button YPS_Button_Next = findViewById(R.id.button);

        setSpinner();

        final EditText edittext_Name = findViewById(R.id.editText);

        RadioGroup radiogroup = findViewById(R.id.radioGroup);
        final RadioButton radio1 = findViewById(R.id.radioButton6);
        final RadioButton radio2 = findViewById(R.id.radioButton5);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radio1.getId())
                    sex_type = 0;
                else
                    sex_type = 1;
            }
        });

        YPS_Button_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lauch.this, Preference.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myInformation.ChangeInformation(age_type, sex_type, grade_type, faculty_type);
                myInformation.setName(edittext_Name.getText().toString());
                myInformation.InputInformation();
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(Lauch.this, "返回", Toast.LENGTH_SHORT).show();
        finish();
    }
}
