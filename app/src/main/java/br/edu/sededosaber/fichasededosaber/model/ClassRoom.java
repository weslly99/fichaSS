package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 29/01/16.
 */
public class ClassRoom {

    private UUID mUUID;
    private Period mPeriod;
    private String mName;

    public ClassRoom(){
        this(UUID.randomUUID());
    }

    public ClassRoom(UUID id){
        mUUID = id;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public Period getPeriod() {
        return mPeriod;
    }

    public void setPeriod(Period period) {
        mPeriod = period;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
