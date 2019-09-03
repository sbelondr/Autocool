package autocool.sam.example.com.autocool.modele.tarifs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import autocool.sam.example.com.autocool.modele.MySQLiteHelper;

import java.util.ArrayList;

public class TrancheKMDAO {
    private MySQLiteHelper accesBD;
    protected SQLiteDatabase bdd = null;

    public TrancheKMDAO(Context context){
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

    public ArrayList<TrancheKM> selectTrancheKM(){
        String  sql = "SELECT codeTrancheKm, minKm, maxKM FROM tranche_km";
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<TrancheKM>    listTrancheKM = new ArrayList<>();
        while (c.moveToNext()){
            TrancheKM uneTrancheKM = new TrancheKM(c.getInt(0), c.getInt(1), c.getInt(2));
            listTrancheKM.add(uneTrancheKM);
        }
        c.close();
        return      listTrancheKM;
    }

    public int      selectCodeTranche(int min, int max){
        int     result = 0;
        String  sql = "SELECT codeTrancheKm FROM tranche_km WHERE minKm=" + min +
                " AND maxKM="+max;
        Cursor c = bdd.rawQuery(sql, null);
        if (c.getCount() == 0){
            c.close();
            return 0;
        }
        while (c.moveToNext()){
            result =  c.getInt(0);
        }
        c.close();
        return  result;
    }


    public long     insertTrancheKM(TrancheKM uneTrancheKM){
        ContentValues content = new ContentValues();
        content.put("codeTrancheKm", uneTrancheKM.getCodeTrancheKM());
        content.put("minKm", uneTrancheKM.getMinKM());
        content.put("maxKm", uneTrancheKM.getMaxKM());
        return      bdd.insert("tranche_km", null, content);
    }
}
