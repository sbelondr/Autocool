package autocool.sam.example.com.autocool.modele.tarifs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

public class HoraireDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public HoraireDAO(Context context){
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

    public ArrayList<Horaire> selectHoraire(){
        String  sql = "SELECT codeTrancheH, duree FROM tranche_horaire";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Horaire>    listHoraire = new ArrayList<>();
        while (c.moveToNext()){
            Horaire uneHoraire = new Horaire(c.getString(0), c.getInt(1));
            listHoraire.add(uneHoraire);
        }
        c.close();
        return      listHoraire;
    }

    public long     insertHoraire(Horaire uneHoraire){
        ContentValues content = new ContentValues();
        content.put("codeTrancheH", uneHoraire.getCodeTranche());
        content.put("duree", uneHoraire.getDuree());
        return      bdd.insert("tranche_horaire", null, content);
    }
}
