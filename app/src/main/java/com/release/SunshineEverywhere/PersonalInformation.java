package com.release.SunshineEverywhere;

import android.content.Context;

public class PersonalInformation extends FileService {

    private short information = 0;
    private String name = "";
    private short preferences = 0;

    public PersonalInformation(Context context) {
        super(context);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreferences(short preferences) {
        this.preferences = preferences;
    }

    public short ChangeInformation(int age_type, int sex_type, int grade_type, int faculty_type) {
        information += age_type;
        information = (short) (information << 1);
        information += sex_type;
        information = (short) (information << 2);
        information += grade_type;
        information = (short) (information << 4);
        information += faculty_type;
        return information;
    }

    public short ChangePreferences(int arg01, int arg02, int arg03, int arg04) {
        preferences += arg01;
        preferences = (short) (preferences << 4);
        preferences += arg02;
        preferences = (short) (preferences << 4);
        preferences += arg03;
        preferences = (short) (preferences << 4);
        preferences += arg04;
        return preferences;
    }

    public void InputInformation() {
        saveToRom(String.valueOf(information) + "\n" + name + "\n", "PersonalInformation.dbs");
    }

    public void InputPersonalPreferences() {
        saveToRom(String.valueOf(preferences) + "\n", "PersonalInformation.dbs");
    }

    public void UpdateName(String new_name) {
    }

    public void UpdateAge(int type) {
    }

    public void UpdateSex(int type) {
    }

    public void UpdateGrade(int type) {
    }

    public void UpdateFaculty(int type) {
    }
}
