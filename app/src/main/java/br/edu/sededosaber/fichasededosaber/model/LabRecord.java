package br.edu.sededosaber.fichasededosaber.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weslly on 19/01/16.
 */
public class LabRecord {
    private List<Record> mRecords;
    public static LabRecord sLabRecord;

    private LabRecord(Context context) {
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
        for (int i = 0; i < mRecords.size(); i++) {
            if (mRecords.get(i).getId().equals(id)) {
                return mRecords.get(i);
            }
        }
        return null;
    }

    public void deleteRecord(UUID id){
        for(int i  = 0; i<mRecords.size();i++){
            if(mRecords.get(i).getId().equals(id)){
                mRecords.remove(i);
                return;
            }
        }
    }
    public void addRecord(Record record){
        mRecords.add(record);
    }

}
