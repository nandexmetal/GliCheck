package br.com.glicheck.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by f.de.souza.filho on 9/14/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "GliCheckDB";

    public DBHandler (Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        //db.execSQL(scriptSql.deletarTabela());
        db.execSQL(scriptSql.getCriarMedicaoGlicemia());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


    public int getMedicaoCount()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DB_NAME, null);
        cursor.close();

        return cursor.getCount();
    }


}
