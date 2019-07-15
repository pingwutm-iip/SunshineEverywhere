package com.release.yps00;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

public class FileService {
    public Context context;

    public FileService(Context context) {
        this.context = context;
    }

    public boolean saveToRom(String data, String fileName) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE|Context.MODE_APPEND);
            //System.out.println("debug03-----------------------------------------------------------------");
            fos.write(data.getBytes());
            //System.out.println("debug04-----------------------------------------------------------------");
            fos.flush();
            fos.close();
        } catch (Exception e) {
            //System.out.println("debug05-----------------------------------------------------------------");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public byte[] readFile(String fileName) {
        byte[] buffer = null;
        try {
            FileInputStream fis = context.openFileInput(fileName);
            buffer = new byte[fis.available()];
            fis.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
