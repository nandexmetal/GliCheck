package br.com.glicheck.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import br.com.glicheck.Class.Glicemia;

/**
 * Created by f.de.souza.filho on 9/15/2015.
 */
public class RepMedicaoGlicemia
{
    private SQLiteDatabase conexao;
    public RepMedicaoGlicemia(SQLiteDatabase conexao)
    {
        this.conexao = conexao;
    }



    public void Inserir(Glicemia glicemia)
    {
        try
        {
            ContentValues values = new ContentValues();

            values.put("USUARIO", glicemia.getUsuario());
            values.put("MEDICAO", glicemia.getMedicao_glicemia());
            values.put("TIPO_MEDICAO", glicemia.getTipoMedicao());
            values.put("DATA", glicemia.getDate().getTime());

            conexao.insertOrThrow("MEDICAO_GLICEMIA", null, values);

        }
        catch (Exception e)
        {
            Toast.makeText(null, e.toString(), Toast.LENGTH_LONG).show();

        }
    }



    public ArrayAdapter<Glicemia> getMedicaoGlicemia(Context context)
    {
        ArrayAdapter<Glicemia> adpMedicaoGlicemia = new ArrayAdapter<Glicemia>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conexao.query("MEDICAO_GLICEMIA", null, null, null, null, null, null);

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do
            {
                Glicemia glicemia = new Glicemia();
                glicemia.setMedicao_glicemia(Integer.parseInt(cursor.getString(1)));
                glicemia.setTipoMedicao(cursor.getString(1));
                adpMedicaoGlicemia.add(glicemia);

            }
            while (cursor.moveToNext());

        }


        return adpMedicaoGlicemia;

    }

    public void addMedicaoGlicemiaTest()
    {
        int glicemia = 120;
        for (int i = 0; i < 10; i++)
        {
            ContentValues values = new ContentValues();
            values.put("medicao", glicemia);
            conexao.insertOrThrow("MEDICAO_GLICEMIA", null, values);
            glicemia++;
        }

    }
}
