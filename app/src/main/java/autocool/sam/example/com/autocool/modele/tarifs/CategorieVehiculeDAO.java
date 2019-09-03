package autocool.sam.example.com.autocool.modele.tarifs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

public class CategorieVehiculeDAO {
    private MySQLiteHelper      accesBD;
    protected SQLiteDatabase    bdd = null;

    public CategorieVehiculeDAO(Context context){
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

    public ArrayList<CategorieVehicule>     selectCategorie(){
        String  sql = "SELECT codeCateg, libelleCateg FROM categorie_vehicule";
        Cursor  c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<CategorieVehicule>    listCateg = new ArrayList<>();
        while (c.moveToNext()){
            CategorieVehicule uneCateg = new CategorieVehicule(c.getString(0), c.getString(1));
            listCateg.add(uneCateg);
        }
        c.close();
        return      listCateg;
    }

    public long     insertCategorie(CategorieVehicule uneCateg){
        ContentValues content = new ContentValues();
        content.put("codeCateg", uneCateg.getCodeCateg());
        content.put("libelleCateg", uneCateg.getLibelleCateg());
        return      bdd.insert("categorie_vehicule", null, content);
    }
}
