package autocool.sam.example.com.autocool.modele.tarifs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

public class FactureHDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public FactureHDAO(Context context){
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

    public ArrayList<FactureH> selectFacture(){
        String  sql = "SELECT codeTrancheH, codeFormule, codeCateg, tarifH FROM factureH";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<FactureH>    listFacture = new ArrayList<>();
        while (c.moveToNext()){
            FactureH uneFacture = new FactureH(c.getString(0), c.getInt(1), c.getString(2),
                    c.getDouble(3));
            listFacture.add(uneFacture);
        }
        c.close();
        return      listFacture;
    }

    public ArrayList<FactureH> selectFactureFiltre(int codeFormule){
        String  sql = "SELECT codeTrancheH, codeFormule, codeCateg, tarifH FROM factureH " +
                "WHERE codeFormule = " + codeFormule;
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<FactureH>    listFacture = new ArrayList<>();
        while (c.moveToNext()){
            Log.d("facture", "ok");
            FactureH uneFacture = new FactureH(c.getString(0), c.getInt(1), c.getString(2),
                    c.getDouble(3));
            listFacture.add(uneFacture);
        }
        c.close();
        Log.d("fin facture", "ici");
        return      listFacture;
    }

    public long     insertFacture(FactureH uneFacture){
        ContentValues content = new ContentValues();
        content.put("codeTrancheH", uneFacture.getCodeTrancheH());
        content.put("codeFormule", uneFacture.getCodeFormule());
        content.put("codeCateg", uneFacture.getCodeCateg());
        content.put("tarifH", uneFacture.getTarifH());
        return      bdd.insert("factureH", null, content);
    }

    public void     updateFacture(FactureH uneFacture){
        ContentValues content = new ContentValues();
        content.put("tarifH", uneFacture.getTarifH());
        String      where = "codeTrancheH = '"+uneFacture.getCodeTrancheH()+"' AND codeFormule = "
                +uneFacture.getCodeFormule()+" AND codeCateg = '"+uneFacture.getCodeCateg()+"'";
        bdd.update("factureH", content, where, null);
    }
}
