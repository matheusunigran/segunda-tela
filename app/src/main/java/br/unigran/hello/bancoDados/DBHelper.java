package br.unigran.hello.bancoDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context content) {
        super(content, "BancoHello", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table cliente(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120)," +
                        "numero varchar(20));"
        );

        sqLiteDatabase.execSQL(
                "create table produto(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120)," +
                        "marca varchar(20));"
        );

        sqLiteDatabase.execSQL(
                "create table fornecedor(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120)," +
                        "numero varchar(20));"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
