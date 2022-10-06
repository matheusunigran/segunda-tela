package br.unigran.hello.bancoDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperCliente extends SQLiteOpenHelper {
    public DBHelperCliente(@Nullable Context context) {
        super(context, "BancoCliente", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table agenda(" +
                "id integer primary key autoincrement," +
                "nome varchar(150)," +
                "numero varchar(15))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
