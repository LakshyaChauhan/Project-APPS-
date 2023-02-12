package com.example.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FILEHELPER {

    public static  final String FILENAME ="listinfo.dat";

    public static void writeData(ArrayList<String> list, Context context) {

        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(list);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readData(Context context){

        ArrayList<String> list = null;

        try {
            FileInputStream fio = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fio);
            list = (ArrayList<String>) ois.readObject();

        } catch (FileNotFoundException e) {
            list = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
