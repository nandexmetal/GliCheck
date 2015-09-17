package br.com.glicheck.Class;
import java.util.Date;

/**
 * Created by f.de.souza.filho on 9/14/2015.
 */
public class Glicemia {

    private int id;
    private String usuario;
    private int medicao_glicemia;
    private String tipoMedicao;
    private Date date;


    public Glicemia()
    {
        this.setId(id);
        this.setUsuario(usuario);
        this.setMedicao_glicemia(medicao_glicemia);
        this.setTipoMedicao(tipoMedicao);
        this.setDate(date);

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setMedicao_glicemia(int medicao_glicemia) {
        this.medicao_glicemia = medicao_glicemia;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoMedicao() {
        return tipoMedicao;
    }

    public void setTipoMedicao(String tipoMedicao) {
        this.tipoMedicao = tipoMedicao;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMedicao_glicemia() {
        return medicao_glicemia;
    }
}
