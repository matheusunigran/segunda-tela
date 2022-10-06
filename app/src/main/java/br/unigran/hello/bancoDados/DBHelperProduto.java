package br.unigran.hello.bancoDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperProduto extends SQLiteOpenHelper {
    public DBHelperProduto(@Nullable Context context) {
        super(context, "BancoProduto", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table agenda(" +
                "id integer primary key autoincrement," +
                "nome varchar(150)," +
                "marca varchar(150))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
