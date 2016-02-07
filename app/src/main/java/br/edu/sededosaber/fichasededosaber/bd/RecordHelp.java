package br.edu.sededosaber.fichasededosaber.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by weslly on 07/02/16.
 */
public class RecordHelp extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "record.db";


    public RecordHelp(Context context) {
        super(context,DB_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
