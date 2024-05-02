package fr.dev_mobile.display_number;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import fr.m4104.display_number.R;

/**
 * @author B. LEMAIRE
 * Activité pour l'affichage d'un nombre entier
 */
public class Display extends Activity {

    // Pour l'affichage du nombre
    private TextView tv_display_number;

    private Button back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display);

        // A compléter

        /**
         * Désérialisation des ressources
         */

        this.deserialiserRessources();
        this.back = (Button) this.findViewById(R.id.bt_display);

            Intent intent = getIntent();
            int nb = intent.getIntExtra("Saisir", 0);
            TextView textView = (TextView) findViewById(R.id.tv_display);
            textView.setText(Integer.toString(nb));



        // A compléter

    }




    /**
     * Désérialise les ressources
     * Permet d'intancier les instances à partir des ressources
     * XML des composants graphiques (widgets)
     */
    private void deserialiserRessources() {
        this.tv_display_number = (TextView) this.findViewById(R.id.tv_display);
    }
    private void initConnection() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.this.finish();
            }

        });
}
}
