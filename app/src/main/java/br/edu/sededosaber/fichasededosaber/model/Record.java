package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 18/01/16.
 */
public class Record {

    private UUID mId;
    private BirthCertificate mCertificate;
    private Contact mContacts;
    private Docs mDocs;
    private Classroom mClassRoom;


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

    public Classroom getClassRoom() {
        return mClassRoom;
    }

    public void setClassRoom(Classroom classRoom) {
        mClassRoom = classRoom;
    }

    public Docs getDocs() {
        return mDocs;
    }

    public void setDocs(Docs docs) {
        mDocs = docs;
    }
}
