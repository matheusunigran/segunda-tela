package br.unigran.hello.bancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.hello.Entidades.Cliente;

public class ClienteDB {
    private DBHelper db;
    private SQLiteDatabase conexao;
    public ClienteDB(DBHelper db){
        this.db=db;
    }
    public void inserir(Cliente cliente){
        conexao = db.getWritableDatabase();//abre o bd
        ContentValues valores = new ContentValues();
        valores.put("nome",cliente.getNome());
        valores.put("numero",cliente.getNumero());
        conexao.insertOrThrow("cliente",null,valores);
        conexao.close();
    }
    public void atualizar(Cliente cliente){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome",cliente.getNome());
        valores.put("numero",cliente.getNumero());
        conexao.update("cliente",valores, "id=?", new String[]{cliente.getId().toString()});
        conexao.close();
    }
    public void remover(int id){
        conexao=db.getWritableDatabase();
        conexao.delete("cliente","id=?",
                new String[]{id+""});
    }
    public void lista(List dados){
        dados.clear();
        conexao=db.getReadableDatabase();
        String names[]={"id","nome","numero"};
        Cursor query = conexao.query("cliente", names,
                null, null, null,
                null, "nome");
        while (query.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(
                    query.getString(0)));
            cliente.setNome(
                    query.getString(1));
            cliente.setNumero(
                    query.getString(2));
            dados.add(cliente);
        }
        conexao.close();
    }
}
