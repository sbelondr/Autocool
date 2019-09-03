package autocool.sam.example.com.autocool.adherents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import autocool.sam.example.com.autocool.R;
import autocool.sam.example.com.autocool.modele.adherents.Abonne;

/**
 * Created by samuel on 3/23/18.
 */

public class info_un_adherent extends AppCompatActivity {
    private String EXTRA_FILTRE = "Classique";
    private String formule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_un_adherent);

        Intent intent = getIntent();
        //      recup valeur de l'objet du click
        Abonne abo = this.getIntent().getExtras().getParcelable("unAbonne");
        formule = intent.getStringExtra(EXTRA_FILTRE);
        Log.d("form", formule);
//        Toast.makeText(getBaseContext(), formule, Toast.LENGTH_SHORT).show();


        final Button btnRetour = findViewById(R.id.btnRetInfAdhe);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retIntent = new Intent(info_un_adherent.this, liste_adherants.class);
                // dernier ajout
                retIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                retIntent.putExtra(EXTRA_FILTRE, formule);
                startActivity(retIntent);
            }
        });

        final TextView txtTitre = findViewById(R.id.txtNomPrenom);
        txtTitre.setText(abo.getNom() + " " + abo.getPrenom());

        final TextView txtDateNaissance = findViewById(R.id.txtDNaissance);
        txtDateNaissance.setText("Date de naissance: " + abo.getDateNaissance());

        final TextView txtAdresse = findViewById(R.id.txtRue);
        txtAdresse.setText("Adresse: " + abo.getRue());

        final TextView txtVilCP = findViewById(R.id.txtVille);
        txtVilCP.setText(abo.getCodePostal() + " " + abo.getVille());

        final TextView txtPhone = findViewById(R.id.txtNum);
        txtPhone.setText("Telephone fixe: " + abo.getTel());

        final TextView txtPhoneMobile = findViewById(R.id.txtNumDeux);
        txtPhoneMobile.setText("Telephone mobile: " + abo.getTelMobile());

        final TextView txtEmail = findViewById(R.id.txtMail);
        txtEmail.setText("Mail: " + abo.getEmail());

        final TextView txtTitreP = findViewById(R.id.txtTitrePermis);
        txtTitreP.setText("Permis");

        final TextView txtNumPer = findViewById(R.id.txtNumPermis);
        txtNumPer.setText("Num permis: " + abo.getNumPermis());

        final TextView txtLieuPer = findViewById(R.id.txtLieuPermis);
        txtLieuPer.setText("Ville permis: " + abo.getLieuPermis());

        final TextView txtDTPer = findViewById(R.id.txtDatePermis);
        txtDTPer.setText("Date permis: " + abo.getDatePermis());

        final TextView txtPaieAdhe = findViewById(R.id.txtPaiementAdhesion);
//        Toast.makeText(getBaseContext(), String.valueOf(abo.getPaiementAdhesion()), Toast.LENGTH_SHORT).show();
        if (abo.getPaiementAdhesion()==1)
            txtPaieAdhe.setText("Paiement adhésion: Oui");
        else
            txtPaieAdhe.setText("Paiement adhésion: Non");

        final TextView txtCaut = findViewById(R.id.txtCaution);
        if (abo.getPaiementCaution()==1)
            txtCaut.setText("Paiement caution: Oui");
        else
            txtCaut.setText("Paiement caution: Non");

        final TextView txtRIB = findViewById(R.id.txtRIB);
        if (abo.getRibFourni().equals(""))
            txtRIB.setText("RIB: Non");
        else
            txtRIB.setText("RIB: Oui");


    }
}
