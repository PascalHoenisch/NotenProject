package com.example.notesproject.GUI;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

public class GUISongList extends GUI {
    public GUISongList(AppCompatActivity app) {
        super(app);
    }

    @Override
    public void init() {
        app.setContentView(R.layout.song_list);

        LinearLayout songList = (LinearLayout) app.findViewById(R.id.songlist_list);

        Button sampleSong = new Button(app);
        sampleSong.setText("Sample Song");
        sampleSong.setId(1);

        sampleSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUISong gui = new GUISong(app);
                gui.init();
            }
        });

        songList.addView(sampleSong);


    }
}
