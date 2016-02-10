package br.edu.sededosaber.fichasededosaber.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.bd.RecordHelp;

/**
 * Created by weslly on 19/01/16.
 */
public class LabRecord {

    private static LabRecord sLabRecord;

    private SQLiteDatabase mDatabase;
    private Context mContext;


    private LabRecord(Context context) {
        mContext = context.getApplicationContext();
        mDatabase  = new RecordHelp(mContext)
                .getWritableDatabase();
    }

    public static LabRecord getLabRecord(Context context) {

        if (sLabRecord == null) {
            sLabRecord =
                    new LabRecord(context.getApplicationContext());
        }

        return sLabRecord;
    }

    public List<Record> getRecords() {
        return null;
    }

    public Record getRecord(UUID id) {

        return null;
    }

    public void deleteRecord(UUID id){
       return;
    }
    public void addRecord(Record record){


    }

    private ContentValues getContentValue(){

        return null;
    }

}
