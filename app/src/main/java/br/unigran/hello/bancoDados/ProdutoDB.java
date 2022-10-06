package br.unigran.hello.bancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.hello.Entidades.Produto;

public class ProdutoDB {
    private DBHelperProduto db;
    private SQLiteDatabase conexao;
    public ProdutoDB(DBHelperProduto db){
        this.db=db;
    }
    public void inserir(Produto produto){
        conexao = db.getWritableDatabase();//abre o bd
        ContentValues valores = new ContentValues();
        valores.put("nome",produto.getNome());
        valores.put("marca",produto.getMarca());
        conexao.insertOrThrow("Produto",null,valores);
        conexao.close();
    }
    public void atualizar(Produto produto){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome",produto.getNome());
        valores.put("marca",produto.getMarca());
        conexao.update("Produto",valores, "id=?", new String[]{produto.getId().toString()});
        conexao.close();
    }
    public void remover(int id){
        conexao=db.getWritableDatabase();
        conexao.delete("Produto","id=?",
                new String[]{id+""});
    }
    public void lista(List dados){
        dados.clear();
        conexao=db.getReadableDatabase();
        String names[]={"id","nome","marca"};
        Cursor query = conexao.query("Produto", names,
                null, null, null,
                null, "nome");
        while (query.moveToNext()){
            Produto produto = new Produto();
            produto.setId(Integer.parseInt(
                    query.getString(0)));
            produto.setNome(
                    query.getString(1));
            produto.setMarca(
                    query.getString(2));
            dados.add(produto);
        }
        conexao.close();
    }
}
