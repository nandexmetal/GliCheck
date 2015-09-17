package br.com.glicheck.DataBase;

/**
 * Created by f.de.souza.filho on 9/15/2015.
 */
public class scriptSql {

    public static String getCriarMedicaoGlicemia()
    {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS MEDICAO_GLICEMIA  ");
        sqlBuilder.append(" (_id     INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sqlBuilder.append("USUARIO VARCHAR (40), ");
        sqlBuilder.append("MEDICAO INTEGER NOT NULL, ");
        sqlBuilder.append("TIPO_MEDICAO VARCHAR (10) , ");
        sqlBuilder.append("DATA    DATE); ");

        return sqlBuilder.toString();

    }

    public static  String deletarTabela(){
        StringBuilder query = new StringBuilder();
        query.append("DROP TABLE IF EXISTS GliCheck.MEDICAO_GLICEMIA");
        return query.toString();


    }

}
