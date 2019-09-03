package autocool.sam.example.com.autocool.tarifs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import autocool.sam.example.com.autocool.R;
import autocool.sam.example.com.autocool.modele.tarifs.FactureH;
import autocool.sam.example.com.autocool.modele.tarifs.FactureHDAO;
import autocool.sam.example.com.autocool.modele.tarifs.FactureKm;
import autocool.sam.example.com.autocool.modele.tarifs.FactureKmDAO;
import autocool.sam.example.com.autocool.modele.tarifs.Horaire;
import autocool.sam.example.com.autocool.modele.tarifs.HoraireDAO;
import autocool.sam.example.com.autocool.modele.tarifs.TrancheKM;
import autocool.sam.example.com.autocool.modele.tarifs.TrancheKMDAO;

import java.util.ArrayList;

public class menu_tarifs extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private final String    EXTRA_FORMULE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tarifs);

        // visualiser son choix
        final Button btnChoix = findViewById(R.id.btnChFormTarifs);
        btnChoix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Spinner spnFormule = findViewById(R.id.spnFormuleTarifs);
                Intent intent = new Intent(menu_tarifs.this, liste_tarifs.class);
                intent.putExtra(EXTRA_FORMULE, spnFormule.getSelectedItem().toString());
                startActivity(intent);
            }
        });


        // enregistrer la mise à jour
        final Button    btnSave = findViewById(R.id.btnEditPrixSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTarifs();
            }
        });


        final Spinner spnChangeHKM = findViewById(R.id.spnEditPrixHKM);
        spnChangeHKM.setOnItemSelectedListener(this);


    }

    public void     updateTarifs(){
        Spinner     spnForm = findViewById(R.id.spnEditPrixForm);
        Spinner     spnHKM = findViewById(R.id.spnEditPrixHKM);
        Spinner     spnCateg = findViewById(R.id.spnEditPrixCateg);
        Spinner     spnColo = findViewById(R.id.spnEditPrixColo);
        TextView    prix = findViewById(R.id.txtEditPrix);

        // recup la formule
        String      formule = spnForm.getSelectedItem().toString();

        // convertir le textview en double
        double prixDouble = Double.parseDouble(prix.getText().toString());
        // recup le bon id
        int         formID = (formule.equals("Classique")?0:(formule.equals("Coopérative")?1:2));
        // sauvegarder
        if (spnHKM.getSelectedItem().toString().equals("Horaires")){
            FactureH    uneFacture = new FactureH(spnColo.getSelectedItem().toString(), formID,
                    spnCateg.getSelectedItem().toString(), prixDouble);
            FactureHDAO openDAO = new FactureHDAO(menu_tarifs.this);
            openDAO.openForWrite();
            openDAO.updateFacture(uneFacture);
            Toast.makeText(getBaseContext(), "Sauvegardé", Toast.LENGTH_SHORT).show();
            prix.setText(null);
        }
        else {
            String[] str = spnColo.getSelectedItem().toString().split(" ");
            TrancheKMDAO    openTrancheDAO = new TrancheKMDAO(menu_tarifs.this);
            openTrancheDAO.openForWrite();
            int      codeTranche = openTrancheDAO.selectCodeTranche(Integer.parseInt(str[1]), Integer.parseInt(str[3]));
            FactureKmDAO    openDAO = new FactureKmDAO(menu_tarifs.this);
            openDAO.openForWrite();
            FactureKm   uneFacture = new FactureKm(codeTranche, formID,
                    spnCateg.getSelectedItem().toString(), prixDouble);
            openDAO.updateFacture(uneFacture);


        }
    }

    // Choix si on modifie un tarif horaire ou km pour visualiser les horaires ou les kms
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        final Spinner spnEditPrixFiltre = findViewById(R.id.spnEditPrixColo);
        ArrayAdapter<String>    stringColo = new ArrayAdapter<String>(menu_tarifs.this, android.R.layout.simple_spinner_item, android.R.id.text1);
        stringColo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEditPrixFiltre.setAdapter(stringColo);

        final Spinner   spnFormule = findViewById(R.id.spnEditPrixHKM);
        if (spnFormule.getSelectedItem().toString().equals("Horaires")){
            HoraireDAO  uneH = new HoraireDAO(menu_tarifs.this);
            uneH.openForRead();
            ArrayList<Horaire>  list = new ArrayList<>();
            list = uneH.selectHoraire();
            int     i = -1;
            while(list.size() > ++i){
                stringColo.add(String.valueOf(list.get(i).getCodeTranche()));
            }
            stringColo.notifyDataSetChanged();
        }
        else{
            int     i = -1;
            TrancheKMDAO   uneTranche = new TrancheKMDAO(menu_tarifs.this);
            uneTranche.openForRead();
            ArrayList<TrancheKM>    list = new ArrayList<>();
            list = uneTranche.selectTrancheKM();
            while(list.size() > ++i){
                stringColo.add("Entre " + String.valueOf(list.get(i).getMinKM()) + " et " + String.valueOf(list.get(i).getMaxKM()));
            }
            stringColo.notifyDataSetChanged();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
