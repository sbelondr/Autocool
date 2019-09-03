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

public class AdhererDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public AdhererDAO(Context context) {
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

    public ArrayList<Adherer> selectAdherer(){
        String sql = "SELECT numAbonne, codeFormule FROM adherer";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Adherer> listAdherer = new ArrayList<Adherer>();
        while(c.moveToNext()){
            Adherer unAdherent = new Adherer(c.getInt(0), c.getInt(1));
            listAdherer.add(unAdherent);
        }
        c.close();
        return      listAdherer;
    }

    public long     insertAdherer(Adherer unAdherent){
        ContentValues enregistrement = new ContentValues();
        enregistrement.put("numAbonne", unAdherent.getNumAbonne());
        enregistrement.put("codeFormule", unAdherent.getCodeFormule());
        return bdd.insert("adherer", null, enregistrement);
    }

    public void     modifierAbonne(Abonne unAbonne){

    }

    public void     suppriemerAbonne(String nom, String prenom){

    }
}
