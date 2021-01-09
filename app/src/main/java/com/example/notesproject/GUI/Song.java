package com.example.notesproject.GUI;

import android.content.Context;
import android.util.Log;

import java.io.*;

public class Song {
    public static void saveSong(String name, String path, Context context) {

        String data = readFromFile(context) + name + ";;" + path + "~~";
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput( "songList.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private static String readFromFile(Context context) {
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("songList.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("songList.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write("");
                outputStreamWriter.close();
            } catch (IOException f) {
                Log.e("Exception", "File write failed: " + e.toString());
            }
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public static String[][] getSongList(Context context) {
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("songList.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }


        if (ret.equals("")) {
            return new String[0][0];
        } else {

            String[] temp1 = ret.split("~~");
            String[][] temp2 = new String[temp1.length][2];
            for (int i = 0; i < temp2.length; i++) {
                temp1[i] = temp1[i].replace("\n", "");
                temp2[i] = temp1[i].split(";;");
            }

            return temp2;
        }
    }

    public static void clearSongList(Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput( "songList.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write("");
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
