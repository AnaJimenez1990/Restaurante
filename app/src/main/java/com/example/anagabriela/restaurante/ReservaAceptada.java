package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 17/3/2017.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ReservaAceptada extends Activity {
    private Button bOk;

    public ReservaAceptada() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903050);
        this.bOk = (Button)this.findViewById(2131034148);
        this.bOk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReservaAceptada.this.finish();
            }
        });
    }
}
