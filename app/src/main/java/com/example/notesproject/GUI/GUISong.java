package com.example.notesproject.GUI;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

public class GUISong extends GUI {
    public GUISong(AppCompatActivity app) {
        super(app);
    }

    @Override
    public void init() {
        app.setContentView(R.layout.song);

        Button back = (Button) app.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUISongList gui = new GUISongList(app);
                gui.init();
            }
        });
    }
}
