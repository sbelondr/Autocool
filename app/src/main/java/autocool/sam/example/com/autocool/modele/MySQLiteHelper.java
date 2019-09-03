package autocool.sam.example.com.autocool.modele;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by samuel on 3/23/18.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final int    versionBD = 2;
    private static final String nomBD = "abonne.db";

    // Mission 1
    private static String   requeteAbonne = "CREATE TABLE abonne(numAbonne INTEGER NOT NULL, nom VARCHAR(100), " +
            "prenom VARCHAR(100), dateNaissance VARCHAR(100), rue VARCHAR(100), ville VARCHAR(100), " +
            "codePostal VARCHAR(100), tel VARCHAR(100), telMobile VARCHAR(100), email VARCHAR(100), " +
            "numPermis VARCHAR(100), lieuPermis VARCHAR(100), datePermis VARCHAR(100), " +
            "paiementAdhesion BOOLEAN, paiementCaution BOOLEAN, ribFourni VARCHAR(100), " +
            "PRIMARY KEY (numAbonne));";
    private static String   requeteAbonneDrop = "DROP TABLE IF EXISTS abonne;";

    private static String   requeteFormule = "CREATE TABLE formule(codeFormule INTEGER NOT NULL, " +
            "libelleFormule VARCHAR(100), fraisAdhesion DECIMAL(5,2), tarifMensuel DECIMAL(5,2), " +
            "partSociale DECIMAL(5,2), depotGarantie DECIMAL(5,2), caution DECIMAL(5,2), " +
            "PRIMARY KEY(codeFormule));";
    private static String   requeteFormuleDrop = "DROP TABLE IF EXISTS formule;";

    private static String   requeteAdherer = "CREATE TABLE adherer(numAbonne INTEGER NOT NULL, " +
            "codeFormule INTEGER NOT NULL, PRIMARY KEY (numAbonne, codeFormule));";
    private String  requeteAdhererDrop = "DROP TABLE IF EXISTS adherer";

    // Mission 2
    private static String   requeteTrancheHoraire = "CREATE TABLE tranche_horaire(codeTrancheH VARCHAR(1) NOT NULL, " +
            "duree INTEGER, PRIMARY KEY(codeTrancheH));";
    private static String   requeteTrancheHoraireDrop = "DROP TABLE IF EXISTS tranche_horaire";

    private static String   requeteTrancheKM = "CREATE TABLE tranche_km(codeTrancheKm INTEGER NOT NULL, " +
            "minKm INTEGER, maxKm INTEGER, PRIMARY KEY(codeTrancheKm));";
    private static String   requeteTrancheKMDrop = "DROP TABLE IF EXISTS tranche_km";

    private static String   requeteCategorieVehicule = "CREATE TABLE categorie_vehicule(codeCateg VARCHAR(1) NOT NULL, " +
            "libelleCateg VARCHAR(100), PRIMARY KEY(codeCateg))";
    private static String   requeteCategorieVehiculeDrop = "DROP TABLE IF EXISTS categorie_vehicule";

    private static String   requeteFactureH = "CREATE TABLE factureH(codeTrancheH VARCHAR(1) NOT NULL, " +
            "codeFormule INTEGER NOT NULL, codeCateg VARCHAR(1) NOT NULL, tarifH DECIMAL(5,2), " +
            "PRIMARY KEY(codeTrancheH, codeFormule, codeCateg), FOREIGN KEY(codeTrancheH) REFERENCES tranche_horaire(codeTrancheH)," +
            "FOREIGN KEY(codeFormule) REFERENCES formule(codeFormule), FOREIGN KEY(codeCateg) REFERENCES categorie_vehicule(codeCateg));";

    private static String   requeteFactureHDrop = "DROP TABLE IF EXISTS factureH";

    private static String   requeteFactureKm = "CREATE TABLE factureKm(codeTrancheKm INTEGER NOT NULL, " +
            "codeFormule INTEGER NOT NULL, codeCateg VARCHAR(1) NOT NULL, tarifKm DECIMAL(5,2), " +
            "PRIMARY KEY(codeTrancheKm, codeFormule, codeCateg), FOREIGN KEY(codeTrancheKm) REFERENCES tranche_km(codeTrancheKm)," +
            "FOREIGN KEY(codeFormule) REFERENCES formule(codeFormule), FOREIGN KEY(codeCateg) REFERENCES categorie_vehicule(codeCateg));";
    private static String   requeteFactureKmDrop = "DROP TABLE IF EXISTS factureKm";

    // Mission 3
    private static String   requeteVehicule = "CREATE TABLE vehicule(numVehicule INTEGER NOT NULL, " +
            "kilometrage DECIMAL(5,2), niveauEssence INTEGER, PRIMARY KEY(numVehicule))";
    private static String   requeteVehiculeDrop = "DROP TABLE IF EXISTS vehicule";

    private static String   requeteTypeVehicule = "CREATE TABLE type_vehicule(codeTypeV INTEGER NOT NULL, " +
            "libelleTypeV VARCHAR(100), nbPlaces INTEGER, automatique BOOLEAN, PRIMARY KEY(codeTypeV))";
    private static String   requeteTypeVehiculeDrop = "DROP TABLE IF EXISTS type_vehicule";


    private static String   requeteStation = "CREATE TABLE station(numStation INTEGER, lieuStation VARCHAR(100), " +
            "villeStation VARCHAR(100), cpStation  VARCHAR(100), PRIMARY KEY(numStation));";
    private static String   requeteStationDrop = "DROP TABLE IF EXISTS station";


    public MySQLiteHelper(Context context){
        super(context, nomBD, null, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.d("Test", "Passage dans onCreate");
        // Mission 1
        db.execSQL(requeteAbonne);
        db.execSQL(requeteAdherer);
        db.execSQL(requeteFormule);
        // Mission 2
        db.execSQL(requeteTrancheHoraire);
        db.execSQL(requeteTrancheKM);
        db.execSQL(requeteCategorieVehicule);
        db.execSQL(requeteFactureH);
        db.execSQL(requeteFactureKm);
        // Mission 3
        db.execSQL(requeteVehicule);
        db.execSQL(requeteTypeVehicule);
        db.execSQL(requeteStation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("Test", "Passage dans onUpgrade");
        // Mission 1
        db.execSQL(requeteAbonneDrop);
        db.execSQL(requeteAdhererDrop);
        db.execSQL(requeteFormuleDrop);
        // Mission 2
        db.execSQL(requeteTrancheHoraireDrop);
        db.execSQL(requeteTrancheKMDrop);
        db.execSQL(requeteCategorieVehiculeDrop);
        db.execSQL(requeteFactureHDrop);
        db.execSQL(requeteFactureKmDrop);
        // Mission 3
        db.execSQL(requeteVehiculeDrop);
        db.execSQL(requeteTypeVehiculeDrop);
        db.execSQL(requeteStationDrop);

        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.d("Test", "Passage dans onDowngrade");
        onUpgrade(db, oldVersion, newVersion);
    }
}
