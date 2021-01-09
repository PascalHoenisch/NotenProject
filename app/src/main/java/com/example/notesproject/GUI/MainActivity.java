package com.example.notesproject.GUI;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.notesproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tree = findViewById(R.id.Tree);
        final AppCompatActivity that = this;

        //TODO Delete Later:
        //Song.clearSongList(this);


        tree.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                /*
                Context context = getApplicationContext();
                CharSequence text = "Achtung sinnlos!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 250, 120);

                toast.show();
                 */

                /*
                GUILogin gui = new GUILogin(MainActivity.this);
                gui.init();
                 */



                Intent intent = new Intent(that, GUILogin.class);
                startActivity(intent);

            }
        });

    }
}