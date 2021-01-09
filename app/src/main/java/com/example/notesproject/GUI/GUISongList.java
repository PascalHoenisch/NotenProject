package com.example.notesproject.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

public class GUISongList extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        final AppCompatActivity that = this;

        Button newSong = findViewById(R.id.newSong);
        newSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        //-----------------------------------------------------------------------------------
        //Example for a Songlist
        /*
        LinearLayout songList = (LinearLayout) findViewById(R.id.songlist_list);

        Button sampleSong = new Button(this);
        sampleSong.setText("Sample Song");
        sampleSong.setId(1);

        sampleSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(that, GUISong.class);
                startActivity(intent);
            }
        });

        songList.addView(sampleSong);
         */
        //-------------------------------------------------------------------------------------
        LinearLayout songList = findViewById(R.id.songlist_list);
        String[][] songs = Song.getSongList(this);


        for (int i = 0; i < songs.length; i++) {
            Button songButton = new Button(this);
            songButton.setText(songs[i][0]);
            songButton.setId(1);

            final String name = songs[i][0];
            final String path = songs[i][1];

            songButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GUISong.setSongName(name);
                    GUISong.setSongPath(path);
                    Intent intent = new Intent(that, GUISong.class);
                    startActivity(intent);
                }
            });

            songList.addView(songButton);
        }


    }


    private void showFileChooser() {
        //Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);



        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    7);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode){
            case 7:
                if(resultCode==RESULT_OK){

                    GUINewSong.setSongPath(data.getData().toString());

                    Intent intent = new Intent(this, GUINewSong.class);
                    startActivity(intent);


                    //finish();
                    //startActivity(getIntent());
                }
                break;

        }
    }

}

