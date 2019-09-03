package autocool.sam.example.com.autocool.tarifs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import autocool.sam.example.com.autocool.R;
import autocool.sam.example.com.autocool.modele.tarifs.FactureH;
import autocool.sam.example.com.autocool.modele.tarifs.FactureHDAO;
import autocool.sam.example.com.autocool.modele.tarifs.FactureKm;
import autocool.sam.example.com.autocool.modele.tarifs.FactureKmDAO;

import java.util.ArrayList;

public class liste_tarifs extends AppCompatActivity {
    private final String    EXTRA_FORMULE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_tarifs);

        Intent intent = getIntent();
        String      filtre = "";
        if (null != getIntent()){
            if (intent.hasExtra(EXTRA_FORMULE)) {
                filtre = intent.getStringExtra(EXTRA_FORMULE);
            }
        }
        final TextView txtFormule = findViewById(R.id.txtFormule);
        txtFormule.setText("Formule <" + filtre + ">");

        FactureHDAO uneFac = new FactureHDAO(this);
        FactureKmDAO uneFacKM = new FactureKmDAO(this);

        uneFac.openForRead();
        uneFacKM.openForRead();
        ArrayList<FactureH> list = new ArrayList<>();
        ArrayList<FactureKm> listKM = new ArrayList<>();
        if (filtre.equals("Classique")){
            list = uneFac.selectFactureFiltre(0);
            listKM = uneFacKM.selectFactureFiltre(0);
        }
        else if (filtre.equals("Coopérative")){
            list = uneFac.selectFactureFiltre(1);
            listKM = uneFacKM.selectFactureFiltre(1);
        }
        else{
            list = uneFac.selectFactureFiltre(2);
            listKM = uneFacKM.selectFactureFiltre(2);
        }
        uneFac.close();
        uneFacKM.close();

        for (FactureH unH : list){
            if (unH.getCodeCateg().equals("S")){
                if(unH.getCodeTrancheH().equals("H")){
                    TextView unTest = findViewById(R.id.txtSH);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
                else if(unH.getCodeTrancheH().equals("J")){
                    TextView unTest = findViewById(R.id.txtSJ);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
                else{
                    TextView unTest = findViewById(R.id.txtSS);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
            }
            else if(unH.getCodeCateg().equals("M")){
                if(unH.getCodeTrancheH().equals("H")){
                    TextView unTest = findViewById(R.id.txtMH);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
                else if(unH.getCodeTrancheH().equals("J")){
                    TextView unTest = findViewById(R.id.txtMJ);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
                else{
                    TextView unTest = findViewById(R.id.txtMS);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
            }
            else{
                if(unH.getCodeTrancheH().equals("H")){
                    TextView unTest = findViewById(R.id.txtLH);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
                else if(unH.getCodeTrancheH().equals("J")){
                    TextView unTest = findViewById(R.id.txtLJ);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
                else{
                    TextView unTest = findViewById(R.id.txtLS);
                    unTest.setText(String.valueOf(unH.getTarifH()));
                }
            }
        }

        for (FactureKm unKm : listKM) {
            if (unKm.getCodeCateg().equals("S")) {
                if (unKm.getCodeTrancheKm() == 0) {
                    TextView unTest = findViewById(R.id.txtKMSH);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                } else if (unKm.getCodeTrancheKm() == 1) {
                    TextView unTest = findViewById(R.id.txtKMSJ);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                } else {
                    TextView unTest = findViewById(R.id.txtKMSS);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                }
            } else if (unKm.getCodeCateg().equals("M")) {
                if (unKm.getCodeTrancheKm() == 0) {
                    TextView unTest = findViewById(R.id.txtKMMH);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                } else if (unKm.getCodeTrancheKm() == 1) {
                    TextView unTest = findViewById(R.id.txtKMMJ);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                } else {
                    TextView unTest = findViewById(R.id.txtKMMS);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                }
            } else {
                if (unKm.getCodeTrancheKm() == 0) {
                    TextView unTest = findViewById(R.id.txtKMLH);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                } else if (unKm.getCodeTrancheKm() == 1) {
                    TextView unTest = findViewById(R.id.txtKMLJ);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                } else {
                    TextView unTest = findViewById(R.id.txtKMLS);
                    unTest.setText(String.valueOf(unKm.getTarifKm()));
                }
            }
        }

    }
}
