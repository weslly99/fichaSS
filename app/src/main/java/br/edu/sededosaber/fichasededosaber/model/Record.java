package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 18/01/16.
 */
public class Record {

    private UUID mId;
    private BirthCertificate mCertificate;
    private Contact mContacts;
    private String mClassRoom;
    private Shift mShift;


    public Record() {
        this(UUID.randomUUID());
    }

    public Record(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public BirthCertificate getCertificate() {
        return mCertificate;
    }

    public void setCertificate(BirthCertificate certificate) {
        mCertificate = certificate;
    }

    public Contact getContacts() {
        return mContacts;
    }

    public void setContacts(Contact contacts) {
        mContacts = contacts;
    }

    public String getClassRoom() {
        return mClassRoom;
    }

    public void setClassRoom(String classRoom) {
        mClassRoom = classRoom;
    }

    public Shift getShift() {
        return mShift;
    }

    public void setShift(Shift shift) {
        mShift = shift;
    }
}
