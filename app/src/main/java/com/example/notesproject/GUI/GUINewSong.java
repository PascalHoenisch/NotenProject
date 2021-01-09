package com.example.notesproject.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

public class GUINewSong extends AppCompatActivity {
    private static String songPath;

    public static void setSongPath(String songPath) {
        GUINewSong.songPath = songPath;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_song);
        final AppCompatActivity that = this;

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tvName = findViewById(R.id.songName);
                String name = tvName.getText().toString();

                Song.saveSong(name, songPath, that);


                Intent intent = new Intent(that, GUISongList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
