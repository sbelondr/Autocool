package autocool.sam.example.com.autocool.adherents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.util.Log;
import android.widget.Toast;

import autocool.sam.example.com.autocool.MainActivity;
import autocool.sam.example.com.autocool.R;
import autocool.sam.example.com.autocool.modele.adherents.Abonne;
import autocool.sam.example.com.autocool.modele.adherents.AbonneDAO;
import autocool.sam.example.com.autocool.modele.adherents.Adherer;
import autocool.sam.example.com.autocool.modele.adherents.AdhererDAO;

import java.util.ArrayList;

/**
 * Created by samuel on 3/23/18.
 */

public class menu_adherants extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private final String    EXTRA_FILTRE = "Classique";
    private       Abonne    unAb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adherants);

        //        Toast.makeText(getBaseContext(), adapt.getItem(0), Toast.LENGTH_SHORT).show();

        //      btn Recherche
        final Button btnEntrerFiltre = findViewById(R.id.btnEntrer);
        //      event click btn
        btnEntrerFiltre.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //      declare spinner
                final Spinner spinFormule = (Spinner)findViewById(R.id.spinnerChangeAdherant);
                Log.d("spinner", spinFormule.getSelectedItem().toString());
                //      prepare changement page
                Intent intent = new Intent(menu_adherants.this, liste_adherants.class);
                //      place le choix dans EXTRA_FILTRE
                intent.putExtra(EXTRA_FILTRE, spinFormule.getSelectedItem().toString());
                startActivity(intent);

            }
        });



        //  lister les abonnes pour pouvoir ensuite les modifier
        AbonneDAO abonneDAO = new AbonneDAO(this);
        abonneDAO.openForWrite();
        ArrayList<Abonne> listAbo = null;
        listAbo = abonneDAO.selectAbonneSansTarif();

        final Spinner spnModifAdhe = findViewById(R.id.spnListeAdhe);
        //      formater les donnees
        ArrayAdapter<Abonne> adapter = new ArrayAdapter<Abonne>(this, android.R.layout.simple_list_item_1, listAbo);
        //      inserer les donnees dans le spiner
        if (listAbo.size() > 0){
            spnModifAdhe.setAdapter(adapter);
        }

        spnModifAdhe.setOnItemSelectedListener(this);

        //      click btn pour modifier un abonne
        final Button btnModifAdhe = findViewById(R.id.btnModifAdhe);
        btnModifAdhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final Spinner spnModifAdheRepet = findViewById(R.id.spnListeAdhe);
                final Spinner spnFormule = findViewById(R.id.spnFrmAddAdhe);

                int     formule = 1;
                final Spinner spnTarif = findViewById(R.id.spnFrmAddAdhe);
                if (spnTarif.getSelectedItem().toString().equals("Classique"))
                    formule = 1;
                else if (spnTarif.getSelectedItem().toString().equals("Coopérative"))
                    formule = 2;
                else
                    formule = 3;
                AdhererDAO adhererDAO = new AdhererDAO(menu_adherants.this);
                Adherer newAdherer = new Adherer(unAb.getNumAbonne(), formule);
                adhererDAO.openForWrite();
                adhererDAO.insertAdherer(newAdherer);
                Log.d("id personne", newAdherer.getNumAbonne() + " - " + newAdherer.getCodeFormule());
                adhererDAO.close();
                Toast.makeText(getBaseContext(), "Enregistré", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(menu_adherants.this, menu_adherants.class);
                startActivity(intent);
            }
        });

        final Button btnQuit = findViewById(R.id.btnQMenuAdhe);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_adherants.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        unAb = (Abonne)parent.getAdapter().getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
