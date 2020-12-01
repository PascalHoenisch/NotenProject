package com.example.notesproject.GUI;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

public class GUILogin extends GUI{


    public GUILogin(AppCompatActivity app) {
        super(app);
    }

    @Override
    public void init() {
        app.setContentView(R.layout.login_screen);


        Button register = (Button) app.findViewById(R.id.button_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIRegister gui = new GUIRegister(app);
                gui.init();
            }
        });


        Button login = (Button) app.findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUISongList gui = new GUISongList(app);
                gui.init();
            }
        });


    }
}
