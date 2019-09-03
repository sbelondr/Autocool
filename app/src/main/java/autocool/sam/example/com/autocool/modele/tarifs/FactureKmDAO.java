package autocool.sam.example.com.autocool.modele.tarifs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

public class FactureKmDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public FactureKmDAO(Context context){
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

    public ArrayList<FactureKm> selectFacture(){
        String  sql = "SELECT codeTrancheKm, codeFormule, codeCateg, tarifKm FROM factureKm";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<FactureKm>    listFacture = new ArrayList<>();
        while (c.moveToNext()){
            FactureKm uneFacture = new FactureKm(c.getInt(0), c.getInt(1), c.getString(2),
                    c.getDouble(3));
            listFacture.add(uneFacture);
        }
        c.close();
        return      listFacture;
    }

    public ArrayList<FactureKm> selectFactureFiltre(int codeFormule){
        String  sql = "SELECT codeTrancheKm, codeFormule, codeCateg, tarifKm FROM factureKm " +
                "WHERE codeFormule = " + codeFormule;
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<FactureKm>    listFacture = new ArrayList<>();
        while (c.moveToNext()){
            FactureKm uneFacture = new FactureKm(c.getInt(0), c.getInt(1), c.getString(2),
                    c.getDouble(3));
            listFacture.add(uneFacture);
        }
        c.close();
        return      listFacture;
    }

    public void     updateFacture(FactureKm uneFacture){
        ContentValues   content = new ContentValues();
        String          where = "codeTrancheKm = '"+uneFacture.getCodeTrancheKm()+"' AND codeFormule = "
                +uneFacture.getCodeFormule()+" AND codeCateg = '"+uneFacture.getCodeCateg()+"'";

        content.put("tarifKm", uneFacture.getTarifKm());
        bdd.update("factureKm", content, where, null);
    }

    public long     insertFacture(FactureKm uneFacture){
        ContentValues content = new ContentValues();
        content.put("codeTrancheKm", uneFacture.getCodeTrancheKm());
        content.put("codeFormule", uneFacture.getCodeFormule());
        content.put("codeCateg", uneFacture.getCodeCateg());
        content.put("tarifKm", uneFacture.getTarifKm());
        return      bdd.insert("factureKm", null, content);
    }
}
