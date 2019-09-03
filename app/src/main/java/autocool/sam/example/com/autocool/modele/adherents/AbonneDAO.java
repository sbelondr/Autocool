package autocool.sam.example.com.autocool.modele.adherents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

/**
 * Created by samuel on 3/23/18.
 */

public class AbonneDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public AbonneDAO(Context context) {
        this.accesBD = new MySQLiteHelper(context);
    }

    public void openForWrite(){
        bdd = accesBD.getWritableDatabase();
    }

    public void openForRead(){
        bdd = accesBD.getReadableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public ArrayList<Abonne>   selectAbonne(){
//        Cursor c = mDb.rawQuery("select  from  where salaire > ?", new String[]{"1"});
        String sql = "SELECT numAbonne, nom, prenom, dateNaissance, rue, ville, codePostal, tel, telMobile, email, numPermis, lieuPermis, datePermis, paiementAdhesion, paiementCaution, ribFourni FROM abonne";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Abonne> listAbo = new ArrayList<Abonne>();
        while(c.moveToNext()){
            Abonne unAbonne = new Abonne(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),
                    c.getString(4), c.getString(5), c.getString(6), c.getString(7),
                    c.getString(8), c.getString(9), c.getString(10), c.getString(11),
                    c.getString(12), c.getInt(13), c.getInt(14),
                    c.getString(15));
            listAbo.add(unAbonne);
        }
        c.close();
        return      listAbo;
    }

    public ArrayList<Abonne>   selectAbonneSansTarif(){
//        Cursor c = mDb.rawQuery("select  from  where salaire > ?", new String[]{"1"});
        String sql = "SELECT numAbonne, nom, prenom, dateNaissance, rue, ville, codePostal, tel, " +
                "telMobile, email, numPermis, lieuPermis, datePermis, paiementAdhesion," +
                " paiementCaution, ribFourni FROM abonne";
        String deuSql = "";
        Cursor deuC = null;
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Abonne> listAbo = new ArrayList<Abonne>();
        while(c.moveToNext()){
            deuSql = "SELECT numAbonne FROM adherer WHERE numAbonne = " + c.getInt(0);
            deuC = bdd.rawQuery(deuSql, null);
            if (deuC.getCount() == 0){
                Abonne unAbonne = new Abonne(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),
                        c.getString(4), c.getString(5), c.getString(6), c.getString(7),
                        c.getString(8), c.getString(9), c.getString(10), c.getString(11),
                        c.getString(12), c.getInt(13), c.getInt(14), c.getString(15));
                listAbo.add(unAbonne);
                deuC.close();
            }
        }
        c.close();
        return      listAbo;
    }

    public Abonne   selectUnAbonne(int valeur){
//        Cursor c = mDb.rawQuery("select  from  where salaire > ?", new String[]{"1"});
        String sql = "SELECT numAbonne, nom, prenom, dateNaissance, rue, ville, codePostal, tel, " +
                "telMobile, email, numPermis, lieuPermis, datePermis, paiementAdhesion, paiementCaution, " +
                "ribFourni FROM abonne WHERE numAbonne = " + valeur;
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        Abonne unAbonne = null;
        while(c.moveToNext()){
            unAbonne = new Abonne(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),
                    c.getString(4), c.getString(5), c.getString(6), c.getString(7),
                    c.getString(8), c.getString(9), c.getString(10), c.getString(11),
                    c.getString(12), c.getInt(13), c.getInt(14), c.getString(15));
        }
        c.close();
        return      unAbonne;
    }

    public ArrayList<Abonne>   selectAbonneFiltre(int valeur){
        String sql = "SELECT abonne.numAbonne, nom, prenom, dateNaissance, rue, ville, codePostal, tel, " +
                "telMobile, email, numPermis, lieuPermis, datePermis, paiementAdhesion, paiementCaution, " +
                "ribFourni FROM abonne, adherer WHERE abonne.numAbonne = adherer.numAbonne AND codeFormule = " + valeur;
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Abonne> listAbo = new ArrayList<Abonne>();
        while(c.moveToNext()){
            Abonne unAbonne = new Abonne(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),
                    c.getString(4), c.getString(5), c.getString(6), c.getString(7),
                    c.getString(8), c.getString(9), c.getString(10), c.getString(11),
                    c.getString(12), c.getInt(13), c.getInt(14), c.getString(15));
            listAbo.add(unAbonne);
        }
        c.close();
        return      listAbo;
    }

    public long     ajouterAbonne(Abonne unAbonne){
        if (!unAbonne.getNom().isEmpty()){
            SQLiteDatabase bd = accesBD.getWritableDatabase();
            ContentValues   enregistrement = new ContentValues();
            enregistrement.put("nom", unAbonne.getNom());
            return bd.insert("abonne", null, enregistrement);
        }
        return -1;
    }

    public long     insertAbonne(Abonne unAbonne){
        ContentValues content = new ContentValues();
        content.put("numAbonne", unAbonne.getNumAbonne());
        content.put("nom", unAbonne.getNom());
        content.put("prenom", unAbonne.getPrenom());
        content.put("dateNaissance", unAbonne.getDateNaissance());
        content.put("rue", unAbonne.getRue());
        content.put("ville", unAbonne.getVille());
        content.put("codePostal", unAbonne.getCodePostal());
        content.put("tel", unAbonne.getTel());
        content.put("telMobile", unAbonne.getTelMobile());
        content.put("email", unAbonne.getEmail());
        content.put("numPermis", unAbonne.getNumPermis());
        content.put("lieuPermis", unAbonne.getLieuPermis());
        content.put("datePermis", unAbonne.getDatePermis());
        content.put("paiementAdhesion", unAbonne.getPaiementAdhesion());
        content.put("paiementCaution", unAbonne.getPaiementCaution());
        content.put("ribFourni", unAbonne.getRibFourni());
        return bdd.insert("abonne", null, content);
    }

    public void     modifierAbonne(Abonne unAbonne){

    }

    public void     suppriemerAbonne(String nom, String prenom){

    }


}
