package autocool.sam.example.com.autocool.modele.adherents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

public class FormuleDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public FormuleDAO(Context context){
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

    public ArrayList<Formule> selectFormule(){
        String  sql = "SELECT codeFormule, libelleFormule, fraisAdhesion, tarifMensuel, partSociale," +
                " depotGarantie, caution FROM formule";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Formule>    listFormule = new ArrayList<>();
        while (c.moveToNext()){
            Formule uneFormule = new Formule(c.getInt(0), c.getString(1), c.getFloat(2),
                    c.getFloat(3), c.getFloat(4), c.getFloat(5), c.getFloat(6));
            listFormule.add(uneFormule);
        }
        c.close();
        return      listFormule;
    }

    public int              selectCodeFormule(String libelle){
        String sql = "SELECT codeFormule FROM formule WHERE libelleFormule = '" + libelle + "';";
        Cursor c = bdd.rawQuery(sql, null);
        int result = 0;

        if (c.getCount() == 1)
            result = c.getInt(0);
        c.close();
        return result;
    }

    public long     insertFormule(Formule uneFormule){
        ContentValues content = new ContentValues();
        content.put("codeFormule", uneFormule.getCodeFormule());
        content.put("libelleFormule", uneFormule.getLibelleFormule());
        content.put("fraisAdhesion", uneFormule.getFraisAdhesion());
        content.put("tarifMensuel", uneFormule.getTarifMensuel());
        content.put("partSociale", uneFormule.getPartSociale());
        content.put("depotGarantie", uneFormule.getDepotGarantie());
        content.put("caution", uneFormule.getCaution());
        return      bdd.insert("formule", null, content);
    }
}
