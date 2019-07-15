package com.release.SunshineEverywhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.release.SunshineEverywhere.R;

public class Preference extends AppCompatActivity {

    private PersonalInformation information = new PersonalInformation(Preference.this);
    private short preferences = 0;

    private void setCheckBoxs() {
        CheckBox Book_1 = findViewById(R.id.checkBox3);
        CheckBox Book_2 = findViewById(R.id.checkBox4);
        CheckBox Book_3 = findViewById(R.id.checkBox5);
        CheckBox Book_4 = findViewById(R.id.checkBox6);
        CheckBox Game_1 = findViewById(R.id.checkBox7);
        CheckBox Game_2 = findViewById(R.id.checkBox8);
        CheckBox Game_3 = findViewById(R.id.checkBox9);
        CheckBox Game_4 = findViewById(R.id.checkBox10);

        Book_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 0;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Book_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 1;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Book_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 2;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Book_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 3;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Game_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 4;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Game_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 5;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Game_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 6;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });

        Game_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                short num = 1 << 7;
                if (isChecked)
                    if (preferences % (num * 2) / num == 0) preferences += num;
                    else ;
                else if (preferences % (num * 2) / num == 1) preferences -= num;
            }
        });
    }

    private void setRadioButton() {
        RadioGroup radiogroup = findViewById(R.id.radioGroup1);
        final RadioButton radio1 = findViewById(R.id.radioButton15);
        final RadioButton radio2 = findViewById(R.id.radioButton16);
        final RadioButton radio3 = findViewById(R.id.radioButton17);
        final RadioButton radio4 = findViewById(R.id.radioButton18);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radio1.getId()) {
                    preferences = (short) (preferences << 2);
                    preferences += 0;
                } else if (checkedId == radio2.getId()) {
                    preferences = (short) (preferences << 2);
                    preferences += 1;
                } else if (checkedId == radio3.getId()) {
                    preferences = (short) (preferences << 2);
                    preferences += 2;
                } else if (checkedId == radio4.getId()) {
                    preferences = (short) (preferences << 2);
                    preferences += 3;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        setCheckBoxs();
        setRadioButton();

        ImageButton btn = this.findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                information.saveToRom(String.valueOf(preferences) + "\n", "PersonalInformation.dbs");
                Intent intent = new Intent(Preference.this, Old_2_2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(Preference.this, "返回", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Preference.this, Lauch.class);
//        startActivity(intent);
        Intent intent = new Intent(Preference.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
