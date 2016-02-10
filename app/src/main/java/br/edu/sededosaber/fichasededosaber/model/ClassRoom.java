package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 29/01/16.
 */
public class ClassRoom {

    private UUID mUUID;
    private Shift mShift;
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

    public Shift getShift() {
        return mShift;
    }

    public void setShift(Shift shift) {
        mShift = shift;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
