package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 18/01/16.
 */
public class Record {

    private UUID mId;
    private String mShelf;
    private String mBookcase;
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

    public String getShelf() {
        return mShelf;
    }

    public void setShelf(String shelf) {
        mShelf = shelf;
    }

    public String getBookcase() {
        return mBookcase;
    }

    public void setBookcase(String bookcase) {
        mBookcase = bookcase;
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
