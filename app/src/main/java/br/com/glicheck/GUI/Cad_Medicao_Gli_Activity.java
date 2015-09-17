package br.com.glicheck.GUI;

import android.app.DatePickerDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import br.com.glicheck.Class.Glicemia;
import br.com.glicheck.DAO.RepMedicaoGlicemia;
import br.com.glicheck.DataBase.DBHandler;
import br.com.glicheck.R;


public class Cad_Medicao_Gli_Activity extends AppCompatActivity  {

    private TextView lblDate;
    private Button btnDatePicker;
    private DBHandler dbHandler;
    private EditText edtGlicemia;
    private Button btnSalvar;
    private SQLiteDatabase conexao;
    private RadioButton rdbGejum;
    private RadioButton rdbPosPrandial;
    private RadioButton rdbRotina;
    private RadioGroup rdgMedicaoGlicemia;

    int dia, mes, ano;
    private Date Data;

    static final int DATE_DIALOG_ID = 999;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_med_gli);

        dbHandler = new DBHandler(this);
        conexao = dbHandler.getWritableDatabase();

        btnDatePicker = (Button)findViewById(R.id.btnDataPicker);
        edtGlicemia = (EditText)findViewById(R.id.edtGlicemia);

        Toast.makeText(getApplicationContext(), "Conexão com o BD OK", Toast.LENGTH_SHORT).show();
        btnSalvar = (Button)findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserir();

            }
        });
        rdbGejum = (RadioButton)findViewById(R.id.rdbGejum);
        rdbPosPrandial = (RadioButton)findViewById(R.id.rdbPosPrandial);
        rdbRotina = (RadioButton)findViewById(R.id.rdpRotina);
        rdgMedicaoGlicemia = (RadioGroup)findViewById(R.id.rdgMedicaoGlicemia);




        Calendar calendar = Calendar.getInstance();
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        ano = calendar.get(Calendar.YEAR);

        btnDatePicker = (Button)findViewById(R.id.btnDataPicker);
        btnDatePicker.setText(dia + "/" + (mes + 1) + "/" + ano);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private String getRadioButtonChecked(){

        if (rdbGejum.isChecked()){
            return "Gejum";

        }
        else if (rdbPosPrandial.isChecked())
        {
            return "Pos-Prandial";

        }
        else
            return "Rotina";

    }

    private void inserir(){

        Glicemia glicemia = new Glicemia();

        glicemia.setUsuario("Usuario Teste");
        glicemia.setMedicao_glicemia(Integer.parseInt(edtGlicemia.getText().toString()));
        glicemia.setTipoMedicao(getRadioButtonChecked());
        glicemia.setDate(new Date());
        if (edtGlicemia.getText().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Preencher Glicemia", Toast.LENGTH_SHORT).show();
        }
        else
        {
            try {
                RepMedicaoGlicemia repMedicaoGlicemia = new RepMedicaoGlicemia(conexao);
                repMedicaoGlicemia.Inserir(glicemia);
            }
            catch (SQLException e)
            {
                Toast.makeText(getApplicationContext(), "Falha ao Inserir", Toast.LENGTH_SHORT).show();
            }
        }



    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker v, int year, int monthOfYear, int dayOfMonth)
        {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            btnDatePicker.setText(dia + "/" + (mes + 1) + "/" + ano);
            criarData(dia, mes, ano);
        }

    };


    private Date criarData(int anoSelecionado, int mesSelecionado, int diaSelecionado) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoSelecionado, mesSelecionado, diaSelecionado);
        return calendar.getTime();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cad_med_gli, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
