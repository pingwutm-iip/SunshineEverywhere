package com.release.yps00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private FileService fileOperate = new FileService(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button YPS_Button_StartAPP = findViewById(R.id.button2);


        YPS_Button_StartAPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File data = new File("data/data/com.release.yps00/files/PersonalInformation.dbs");
                if (data.exists()) {
                    byte[] buffer = fileOperate.readFile(data.getName());
                    String buf = new String(buffer);
                    int count = 0, start = 0;
                    while ((start = buf.indexOf("\n", start)) >= 0) {
                        start += "\n".length();
                        count++;
                    }
                    System.out.println(count + "---------------------------------------------------------------------------------");
                    if (count == 0) {
                        Intent intent = new Intent(MainActivity.this, Lauch.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else if (count == 1 || count > 3) {
                        data.delete();
                        Intent intent = new Intent(MainActivity.this, Lauch.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else if (count == 2) {
                        Intent intent = new Intent(MainActivity.this, Preference.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else if (count == 3) {
                        Intent intent = new Intent(MainActivity.this, Old_2_2.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(MainActivity.this, Lauch.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }

}
