package com.example.jose.text_switcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static TextSwitcher textSwitcher;
    private static Button button;

    String Text[] = { "Ejemplo Practico", "de como desarrollar",
            "TextSwitcher", "en Android Studio", "Comenzamos con el video..." };

    int size = Text.length;

    int indice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setFactory();
        setListener();
        loadAnimations();

    }

    void init(){
        button=(Button)findViewById(R.id.button);
        textSwitcher=(TextSwitcher)findViewById(R.id.textswitcher);
    }

    void loadAnimations(){
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);

    }

    void setFactory(){
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView myText = new TextView(MainActivity.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(25);
                myText.setTextColor(Color.RED);
                return myText;
            }
        });

    }

    void setListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indice ++;
                if(indice==size)
                    indice=0;
                    textSwitcher.setText(Text[indice]);

            }
        });
    }
}
