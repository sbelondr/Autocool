package autocool.sam.example.com.autocool;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import autocool.sam.example.com.autocool.adherents.menu_adherants;
import autocool.sam.example.com.autocool.modele.MySQLiteHelper;
import autocool.sam.example.com.autocool.modele.adherents.Abonne;
import autocool.sam.example.com.autocool.modele.adherents.AbonneDAO;
import autocool.sam.example.com.autocool.modele.adherents.Adherer;
import autocool.sam.example.com.autocool.modele.adherents.AdhererDAO;
import autocool.sam.example.com.autocool.modele.adherents.Formule;
import autocool.sam.example.com.autocool.modele.adherents.FormuleDAO;
import autocool.sam.example.com.autocool.modele.tarifs.CategorieVehicule;
import autocool.sam.example.com.autocool.modele.tarifs.CategorieVehiculeDAO;
import autocool.sam.example.com.autocool.modele.tarifs.FactureH;
import autocool.sam.example.com.autocool.modele.tarifs.FactureHDAO;
import autocool.sam.example.com.autocool.modele.tarifs.FactureKm;
import autocool.sam.example.com.autocool.modele.tarifs.FactureKmDAO;
import autocool.sam.example.com.autocool.modele.tarifs.Horaire;
import autocool.sam.example.com.autocool.modele.tarifs.HoraireDAO;
import autocool.sam.example.com.autocool.modele.tarifs.TrancheKM;
import autocool.sam.example.com.autocool.modele.tarifs.TrancheKMDAO;
import autocool.sam.example.com.autocool.tarifs.menu_tarifs;


/**
 * Created by samuel on 3/23/18.
 */

public class MainActivity extends AppCompatActivity {

    public void     insertMesAbonnes(){
        //      insert des donnees Abonnes
        AbonneDAO abonneDAO = new AbonneDAO(this);
        Abonne aboUn = new Abonne(0,"BEORADE", "Samuel", "20/01/1998",
                "10 rue de la", "MIOSIS", "33350", "0695069999",
                "0605095444", "belon@autocool.com", "FSS3VW4CSUVVQFV6L9SC",
                "BIGANOS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboDeux = new Abonne(1,"BEADE", "Tristan", "20/11/1998",
                "11 rue de la", "MIOSIS", "33350", "0695069999",
                "0605068484", "bead.lppdg@gmail.com", "L75DJ3J4N1114PC3D4P3",
                "BIGANOS", "02/02/2019", 1,
                0,"233535533442rib");
        Abonne aboTrois = new Abonne(2,"MARCEAU", "Alice", "05/06/1946",
                "75, rue Charles Corbeau", "EVREUX", "23000", "02.52.75.58.18",
                "02.52.75.58.18", "BriceMarseau@dayrep.com ", "HV3WO1CIMXVHOTH88HG1",
                "EVREUX", "02/02/2000", 0,
                0,"233535533442rib");
        Abonne aboQuatre = new Abonne(3,"LAPRESSE", "Michèle", "24/09/1933",
                "15, rue Gouin de Beauchesne", "SAINT-NAZAIRE", "44600", "0695069999",
                "0605068484", "MicheleLapresse@teleworm.us", "W2JTIF6KFIOZ15HOBGVN",
                "PARIS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboCinq = new Abonne(4,"PARENTEAU", "Caroline", "20/11/1998",
                "86, Rue Joseph Vernet", "BAGNOLET", "93170", "01.76.14.07.03",
                "0605068484", "parenteau@gmail.com", "BLREROPMG9O78MJXKISC",
                "BIGANOS", "02/12/1997", 1,
                1,"233535533442rib");
        Abonne aboSix = new Abonne(5,"CHARPENTIER", "Philippe", "03/04/1987",
                "87, rue Bonneterie", "MIRAMAS", "13140", "04.78.58.98.98",
                "0605068484", "PhilippeCharpentier@rhyta.com", "IBZ9V6ABHKAN5DG2QFIJ",
                "BREST", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboSept = new Abonne(6,"Laframboise", "Adrien", "06/03/1961",
                "97, boulevard de la Liberation", "MARSEILLE", "13013", "04.88.47.75.84",
                "04.09.92.70.11", "AdrienLaframboise@rhyta.com ", "UQM96PMB2VR0UUAC6O6F",
                "BIGANOS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboHuit = new Abonne(7,"MELANSON", "Clara", "20/01/1989",
                "17, boulevard de la Liberation", "BORDEAUX", "33000", "04.09.92.70.11",
                "04.09.92.70.11", "LeverettMelanson@armyspy.com", "YC5IKUO70UTQU9163AT3",
                "BIGANOS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboNeuf = new Abonne(8,"BON", "Jean", "20/01/1989",
                "17, boulevard de la Liberation", "BORDEAUX", "33000", "04.09.92.70.11",
                "04.09.92.70.11", "LeverettMelanson@armyspy.com", "AEOJTTWFAEY80UD6KD0O",
                "BIGANOS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboDix = new Abonne(9,"MALA", "Celine", "20/01/1989",
                "17, boulevard de la Liberation", "BORDEAUX", "33000", "04.09.92.70.11",
                "04.09.92.70.11", "LeverettMelanson@armyspy.com", "KGXTOHEFE1GP6OA94U7C",
                "BIGANOS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboOnze = new Abonne(10,"AQUA", "Paul", "20/01/1989",
                "17, boulevard de la Liberation", "BORDEAUX", "33000", "04.09.92.70.11",
                "04.09.92.70.11", "LeverettMelanson@armyspy.com", "0N2ZKSSJZTT0NEZNRVNP",
                "BIGANOS", "02/02/2017", 1,
                1,"233535533442rib");
        Abonne aboDouze = new Abonne(11, "PERRIN", "Rene", "10/08/1959", "45, rue Bonneterie", "MONTBÉLIARD",
                "25200", "03.25.56.32.59", "05.25.56.32.59", "PerrinRene@rhyta.com", "ICSVWMEQLRWO6S9TXX34",
                "MONTBÉLIARD", "20/02/1990", 1, 1, "2548kk52654156");
        Abonne aboTreize = new Abonne(12, "OLIVIER", "Lucas", "10/08/1989", "45, rue jas", "LA TESTE",
                "33320", "03.25.56.32.59", "05.25.56.32.59", "olivierlucas@rhyta.com", "X903RIYWQN73K7LNX9WH",
                "MARCHEPRIME", "20/02/2000", 1, 1, "25487654156");
        Abonne aboQuato = new Abonne(13, "JUA", "Hector", "10/08/1999", "2, rue java", "ARCACHON",
                "33360", "03.25.56.32.59", "05.25.56.32.59", "lopaanne@rhyta.com", "5BBIH98V3BWBN2P60AD1",
                "MARCHEPRIME", "20/02/2010", 1, 1, "25495552654156");
        Abonne aboCin = new Abonne(14, "ALO", "Julie", "10/08/1990", "9, rue android", "MARCHEPRIME",
                "33420", "03.25.56.32.59", "05.25.56.32.59", "derefsophie@rhyta.com", "AV6ILVSPVDK6QWCSVYD0",
                "MARCHEPRIME", "20/02/2010", 1, 1, "254285552654156");
        Abonne aboSei = new Abonne(15, "QWER", "Arthur", "10/08/1977", "29, rue duc", "MARCHEPRIME",
                "33420", "03.25.56.32.59", "05.25.56.32.59", "derefsophie@rhyta.com", "M7KEN1NOETMCZM7ZGGG7",
                "MARCHEPRIME", "20/02/2010", 1, 1, "254285552654156");
        Abonne aboDixS = new Abonne(16, "POU", "Céline", "23/07/1971", "4, rue col", "MARCHEPRIME",
                "33420", "03.25.56.32.59", "05.25.56.32.59", "derefsophie@rhyta.com", "9YMPDAIX9GRU1L47IIFZ",
                "MARCHEPRIME", "20/02/2010", 1, 1, "254285552654156");
        Abonne aboDixH = new Abonne(17, "DODO", "Francois", "29/09/1970", "14, rue du sud", "MARCHEPRIME",
                "33420", "03.25.56.32.59", "05.25.56.32.59", "derefsophie@rhyta.com", "SAZSTEF6INBVX34WPYOR",
                "MARCHEPRIME", "20/02/2010", 1, 1, "254285552654156");
        Abonne aboDixN = new Abonne(18, "JER", "Tania", "23/07/1997", "32, rue cava", "MARCHEPRIME",
                "33420", "03.25.56.32.59", "05.25.56.32.59", "derefsophie@rhyta.com", "7KV5ZI24WQ1CNPBB2WRR",
                "MARCHEPRIME", "20/02/2010", 1, 1, "254285552654156");
        Abonne aboVin = new Abonne(19, "VER", "Tom", "10/11/1983", "9, rue tulipe", "MARCHEPRIME",
                "33420", "03.25.56.32.59", "05.25.56.32.59", "derefsophie@rhyta.com", "01GO384X2C1X09N9FA3J",
                "MARCHEPRIME", "20/02/2010", 1, 1, "A1JKSJLKYVT3VEERE6AW");

        abonneDAO.openForWrite();
        abonneDAO.insertAbonne(aboUn);
        abonneDAO.insertAbonne(aboDeux);
        abonneDAO.insertAbonne(aboTrois);
        abonneDAO.insertAbonne(aboQuatre);
        abonneDAO.insertAbonne(aboCinq);
        abonneDAO.insertAbonne(aboSix);
        abonneDAO.insertAbonne(aboSept);
        abonneDAO.insertAbonne(aboHuit);
        abonneDAO.insertAbonne(aboNeuf);
        abonneDAO.insertAbonne(aboDix);
        abonneDAO.insertAbonne(aboOnze);
        abonneDAO.insertAbonne(aboTreize);
        abonneDAO.insertAbonne(aboQuato);
        abonneDAO.insertAbonne(aboCin);
        abonneDAO.insertAbonne(aboSei);
        abonneDAO.insertAbonne(aboDixS);
        abonneDAO.insertAbonne(aboDixH);
        abonneDAO.insertAbonne(aboDixN);
        abonneDAO.insertAbonne(aboVin);
        abonneDAO.close();
    }

    public void     insertMesAdherents(){
        //  insert des formules
        AdhererDAO adhererDAO = new AdhererDAO(this);
        Adherer adherentUn = new Adherer(0,1);
        Adherer adherentDeux = new Adherer(1,1);
        Adherer adherentTrois = new Adherer(2,1);
        Adherer adherentQuatre = new Adherer(3,2);
        Adherer adherentCinq = new Adherer(4,2);
        Adherer adherentSix = new Adherer(5,2);
        Adherer adherentSept = new Adherer(6,3);
        Adherer adherentHuit = new Adherer(7,3);

        adhererDAO.openForWrite();
        adhererDAO.insertAdherer(adherentUn);
        adhererDAO.insertAdherer(adherentDeux);
        adhererDAO.insertAdherer(adherentTrois);
        adhererDAO.insertAdherer(adherentQuatre);
        adhererDAO.insertAdherer(adherentCinq);
        adhererDAO.insertAdherer(adherentSix);
        adhererDAO.insertAdherer(adherentSept);
        adhererDAO.insertAdherer(adherentHuit);
        adhererDAO.close();
    }

    public void     insertMesFormules(){
        FormuleDAO formuleDAO = new FormuleDAO(this);
        Formule formUn = new Formule(0, "Classique", 50, 10,
                500, 150, 50);
        Formule formDe = new Formule(1, "Coopérative", 50, 8.5,
                500, 0, 50);
        Formule formTro = new Formule(2, "Liberté", 50, 15,
                500, 150, 50);
        formuleDAO.openForWrite();
        formuleDAO.insertFormule(formUn);
        formuleDAO.insertFormule(formDe);
        formuleDAO.insertFormule(formTro);
        formuleDAO.close();
    }

    public void     insertMesHoraires(){
        HoraireDAO horaireDAO = new HoraireDAO(this);
        Horaire hoUn = new Horaire("H", 1);
        Horaire hoDe = new Horaire("J", 1);
        Horaire hoTr = new Horaire("S", 1);
        horaireDAO.openForWrite();
        horaireDAO.insertHoraire(hoUn);
        horaireDAO.insertHoraire(hoDe);
        horaireDAO.insertHoraire(hoTr);
        horaireDAO.close();
    }

    public void     insertMesKM(){
        TrancheKMDAO uneTranche = new TrancheKMDAO(this);
        TrancheKM tUn = new TrancheKM(0, 1, 50);
        TrancheKM tDe = new TrancheKM(1, 51, 200);
        TrancheKM tTr = new TrancheKM(2, 201, 0);
        uneTranche.openForWrite();
        uneTranche.insertTrancheKM(tUn);
        uneTranche.insertTrancheKM(tDe);
        uneTranche.insertTrancheKM(tTr);
        uneTranche.close();
    }

    public void     insertMesCategories(){
        CategorieVehiculeDAO uneCateg = new CategorieVehiculeDAO(this);
        CategorieVehicule cUn = new CategorieVehicule("S", "Citadines");
        CategorieVehicule cDe = new CategorieVehicule("M", "Polyvalentes");
        CategorieVehicule cTr = new CategorieVehicule("L", "Ludospaces, Utilitaires, Familales");
        uneCateg.openForWrite();
        uneCateg.insertCategorie(cUn);
        uneCateg.insertCategorie(cDe);
        uneCateg.insertCategorie(cTr);
        uneCateg.close();
    }

    public void     insertMesFacturesH(){
        FactureHDAO     uneFacture = new FactureHDAO(this);
        FactureH        fUn = new FactureH("H", 0, "S", 2.4);
        FactureH        fDe = new FactureH("J", 0, "S", 28.8);
        FactureH        fTr = new FactureH("S", 0, "S", 159.0);
        FactureH        fQu = new FactureH("H", 0, "M", 2.7);
        FactureH        fC = new FactureH("J", 0, "M", 32.4);
        FactureH        fS = new FactureH("S", 0, "M", 179.0);
        FactureH        fH = new FactureH("H", 0, "L", 3.0);
        FactureH        fN = new FactureH("J", 0, "L", 36.0);
        FactureH        fD = new FactureH("S", 0, "L", 198.0);
        FactureH        fOnze = new FactureH("H", 1, "S", 2.4);
        FactureH        fDou = new FactureH("J", 1, "S", 28.8);
        FactureH        fTrei = new FactureH("S", 1, "S", 159.0);
        FactureH        fQua = new FactureH("H", 1, "M", 2.7);
        FactureH        fQui = new FactureH("J", 1, "M", 32.4);
        FactureH        fSei = new FactureH("S", 1, "M", 179.0);
        FactureH        fDS = new FactureH("H", 1, "L", 3.0);
        FactureH        fDH = new FactureH("J", 1, "L", 36.0);
        FactureH        fDN = new FactureH("S", 1, "L", 198.0);
        FactureH        fVi = new FactureH("H", 2, "S", 2.4);
        FactureH        fVUN = new FactureH("J", 2, "S", 28.8);
        FactureH        fVD = new FactureH("S", 2, "S", 159.0);
        FactureH        fVT = new FactureH("H", 2, "M", 2.7);
        FactureH        fVQ = new FactureH("J", 2, "M", 32.4);
        FactureH        fVC = new FactureH("S", 2, "M", 179.0);
        FactureH        fVS = new FactureH("H", 2, "L", 3.0);
        FactureH        fVH = new FactureH("J", 2, "L", 36.0);
        FactureH        fVN = new FactureH("S", 2, "L", 198.0);
        uneFacture.openForWrite();
        uneFacture.insertFacture(fUn);
        uneFacture.insertFacture(fDe);
        uneFacture.insertFacture(fTr);
        uneFacture.insertFacture(fQu);
        uneFacture.insertFacture(fC);
        uneFacture.insertFacture(fS);
        uneFacture.insertFacture(fH);
        uneFacture.insertFacture(fN);
        uneFacture.insertFacture(fD);
        uneFacture.insertFacture(fOnze);
        uneFacture.insertFacture(fDou);
        uneFacture.insertFacture(fTrei);
        uneFacture.insertFacture(fQua);
        uneFacture.insertFacture(fQui);
        uneFacture.insertFacture(fSei);
        uneFacture.insertFacture(fDS);
        uneFacture.insertFacture(fDH);
        uneFacture.insertFacture(fDN);
        uneFacture.insertFacture(fVi);
        uneFacture.insertFacture(fVUN);
        uneFacture.insertFacture(fVD);
        uneFacture.insertFacture(fVT);
        uneFacture.insertFacture(fVQ);
        uneFacture.insertFacture(fVC);
        uneFacture.insertFacture(fVS);
        uneFacture.insertFacture(fVH);
        uneFacture.insertFacture(fVN);
        uneFacture.close();
    }

    public void     insertMesFacturesKm(){
        FactureKmDAO uneFacture = new FactureKmDAO(this);
        FactureKm        fUn = new FactureKm(0, 0, "S", 0.35);
        FactureKm        fDe = new FactureKm(1, 0, "S", 0.24);
        FactureKm        fTr = new FactureKm(2, 0, "S", 0.18);
        FactureKm        fQu = new FactureKm(0, 0, "M", 0.35);
        FactureKm        fC = new FactureKm(1, 0, "M", 0.21);
        FactureKm        fS = new FactureKm(2, 0, "M", 0.15);
        FactureKm        fH = new FactureKm(0, 0, "L", 0.4);
        FactureKm        fN = new FactureKm(1, 0, "L", 0.24);
        FactureKm        fD = new FactureKm(2, 0, "L", 0.18);
        FactureKm fUnD = new FactureKm(0, 1, "S", 0.45);
        FactureKm        fDeD = new FactureKm(1, 1, "S", 0.24);
        FactureKm        fTrD = new FactureKm(2, 1, "S", 0.18);
        FactureKm        fQuD = new FactureKm(0, 1, "M", 0.35);
        FactureKm        fCD = new FactureKm(1, 1, "M", 0.21);
        FactureKm        fSD = new FactureKm(2, 1, "M", 0.15);
        FactureKm        fHD = new FactureKm(0, 1, "L", 0.4);
        FactureKm        fND = new FactureKm(1, 1, "L", 0.24);
        FactureKm        fDD = new FactureKm(2, 1, "L", 0.18);
        FactureKm        fUnT = new FactureKm(0, 2, "S", 0.75);
        FactureKm        fDeT = new FactureKm(1, 2, "S", 0.24);
        FactureKm        fTrT = new FactureKm(2, 2, "S", 0.18);
        FactureKm        fQuT = new FactureKm(0, 2, "M", 0.35);
        FactureKm        fCT = new FactureKm(1, 2, "M", 0.21);
        FactureKm        fST = new FactureKm(2, 2, "M", 0.15);
        FactureKm        fHT = new FactureKm(0, 2, "L", 0.4);
        FactureKm        fNT = new FactureKm(1, 2, "L", 0.24);
        FactureKm        fDT = new FactureKm(2, 2, "L", 0.18);
        uneFacture.openForWrite();
        uneFacture.insertFacture(fUn);
        uneFacture.insertFacture(fDe);
        uneFacture.insertFacture(fTr);
        uneFacture.insertFacture(fQu);
        uneFacture.insertFacture(fC);
        uneFacture.insertFacture(fS);
        uneFacture.insertFacture(fH);
        uneFacture.insertFacture(fN);
        uneFacture.insertFacture(fD);
        uneFacture.insertFacture(fUnD);
        uneFacture.insertFacture(fDeD);
        uneFacture.insertFacture(fTrD);
        uneFacture.insertFacture(fQuD);
        uneFacture.insertFacture(fCD);
        uneFacture.insertFacture(fSD);
        uneFacture.insertFacture(fHD);
        uneFacture.insertFacture(fND);
        uneFacture.insertFacture(fDD);
        uneFacture.insertFacture(fUnT);
        uneFacture.insertFacture(fDeT);
        uneFacture.insertFacture(fTrT);
        uneFacture.insertFacture(fQuT);
        uneFacture.insertFacture(fCT);
        uneFacture.insertFacture(fST);
        uneFacture.insertFacture(fHT);
        uneFacture.insertFacture(fNT);
        uneFacture.insertFacture(fDT);
        uneFacture.close();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //      insert des donnees
        insertMesAbonnes();
        insertMesAdherents();
        insertMesFormules();
        insertMesHoraires();
        insertMesKM();
        insertMesCategories();
        insertMesFacturesH();
        insertMesFacturesKm();


        //      aller aux adherents
        final Button btnAbon = findViewById(R.id.btnAdherants);
        btnAbon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, menu_adherants.class));
            }
        });

        final Button    btnTarifs = findViewById(R.id.btnTarifs);
        btnTarifs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, menu_tarifs.class));
            }
        });
    }
}
