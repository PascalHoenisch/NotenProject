package com.example.notesproject.GUI;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

public class GUIRegister extends GUI{
    public GUIRegister(AppCompatActivity app) {
        super(app);
    }

    @Override
    public void init() {
        app.setContentView(R.layout.register_screen);

        Button back = (Button) app.findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUILogin gui = new GUILogin(app);
                gui.init();
            }
        });
    }
}
