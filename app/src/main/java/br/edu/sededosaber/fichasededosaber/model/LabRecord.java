package br.edu.sededosaber.fichasededosaber.model;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weslly on 19/01/16.
 */
public class LabRecord {

    private static LabRecord sLabRecord;
    private List<Record> mRecords;
    private Context mContext;


    private LabRecord(Context context) {
        mContext = context.getApplicationContext();
       mRecords = new ArrayList<>();
    }

    public static LabRecord getLabRecord(Context context) {

        if (sLabRecord == null) {
            sLabRecord =
                    new LabRecord(context.getApplicationContext());
        }

        return sLabRecord;
    }

    public List<Record> getRecords() {
        return mRecords;
    }

    public Record getRecord(UUID id) {

        for(int i = 0; i< mRecords.size();i++){
            Record toReturn = mRecords.get(i);
            if(toReturn.getId().equals(id)){
                return toReturn;
            }
        }

        return null;
    }

    public void deleteRecord(UUID id){
       return;
    }

    public void addRecord(Record record){
        mRecords.add(record);
    }

    private ContentValues getContentValue(){

        return null;
    }

}
