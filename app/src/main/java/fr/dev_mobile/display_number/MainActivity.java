package fr.dev_mobile.display_number;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.m4104.display_number.R;

/**
 * @author B. LEMAIRE
 * Activité pour la saisi d'un nombre entier
 */
public class MainActivity extends Activity {
    // Pour la saisi du nombre
    private EditText et_number;

    // Bouton pour l'affichage
    private Button bt_dispay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /**
         * Désérialisation des ressources
         */

        deserialiserRessources();

        /**
         * Mise en place de l'écouteur du bouton calculer
         */
        initConnection();



    }

    /**
     * Désérialise les ressources
     * Permet d'instancier les instances Java à partir des ressources
     * XML des composants graphiques (widgets)
     */
    private void deserialiserRessources() {

        /**
         * this.et_number contient la référence du widget Editext
         * où l'utilisateur saisira le nombre
         */

        this.et_number = (EditText) this.findViewById(R.id.et_number);
        this.bt_dispay = (Button) this.findViewById(R.id.bt_display);


    }

    /**
     * Mise en place des écouteurs
     * Permet de mettre en place les fonctions de call-back
     * liées aux évènements
     */
    private void initConnection() {
        /** Dans l'écouteur il faut :
         *
         * - Instancier un Intent explicite
         * - Charger les extras dans l'Intent pour l'affichage
         * - Lancer l'activité d'affichage
         */


        Intent intent = new Intent(this, Display.class);
        bt_dispay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** On récupère le nombre de l'EditText
                 * sous forme d'une chaine de caractère à partir du
                 * widget EditText
                 *
                 * Important : le toString est obligatoire

                 */
                String sNb = et_number.getText().toString();

                try {
                    // Conversion de sNb en un nombre entier
                    int NombreInt=Integer.parseInt(sNb);
                    intent.putExtra("Saisir", NombreInt);
                    startActivity(intent);

                    // A compléter
                }
                catch (NumberFormatException e){
                    // Affiche un pop-pup indiquant que la conversion n'a pas pu avoir lieu
                    Toast.makeText(MainActivity.this, R.string.invalid_number, Toast.LENGTH_LONG).show();
                }
            }


        });


    }
}
