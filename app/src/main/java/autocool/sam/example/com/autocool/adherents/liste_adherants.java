package autocool.sam.example.com.autocool.adherents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import autocool.sam.example.com.autocool.R;
import autocool.sam.example.com.autocool.modele.adherents.Abonne;
import autocool.sam.example.com.autocool.modele.adherents.AbonneDAO;

import java.util.ArrayList;

/**
 * Created by samuel on 3/23/18.
 */

public class liste_adherants extends AppCompatActivity {
    private final String    EXTRA_FILTRE = "Classique";
    private       String    filtre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_adherants);

        //      recup valeur du choix
        Intent      intent = getIntent();
        if (null != getIntent()){
            if (intent.hasExtra(EXTRA_FILTRE)) {
                filtre = intent.getStringExtra(EXTRA_FILTRE);
            }
        }


        final TextView txtTitre = findViewById(R.id.txtvTitre);
        txtTitre.setText("Catégorie: " + filtre);

        //      affiche les adherents suivant le choix
        AbonneDAO abonneDAO = new AbonneDAO(this);
        abonneDAO.openForWrite();
        ArrayList<Abonne> listAbo = null;
        if (filtre.equals("Classique"))
            listAbo = abonneDAO.selectAbonneFiltre(1);
        else if (filtre.equals("Coopérative"))
            listAbo = abonneDAO.selectAbonneFiltre(2);
        else
            listAbo = abonneDAO.selectAbonneFiltre(3);
        abonneDAO.close();

        //      recup le listview
        ListView list = findViewById(R.id.lvAdherant);
        //      format les donnees
        ArrayAdapter<Abonne> adapter = new ArrayAdapter<Abonne>(this, android.R.layout.simple_list_item_1, listAbo);
        //      affiche
        list.setAdapter(adapter);

        //      event click sur element list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //      recup objet du click
                Abonne clickAbo = (Abonne)parent.getAdapter().getItem(position);
                Intent intent = new Intent(liste_adherants.this, info_un_adherent.class);
                intent.putExtra("unAbonne", clickAbo);
                intent.putExtra(EXTRA_FILTRE, filtre);
                Log.d("formule", EXTRA_FILTRE);
                startActivity(intent);
//                liste_adherants.this.startActivity(intent);
            }
        });

        final Button btnRet = findViewById(R.id.btnRetLsAdhe);
        btnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRet = new Intent(liste_adherants.this, menu_adherants.class);
                intentRet.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentRet);
            }
        });
    }
}
