package sededosaber.edu.br.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 18/01/16.
 */
public class Record {

    private UUID mId;
    private String mShelf;
    private String mBookcase;
    private BirthCertificate mCertificate;
    private Address mAddress;

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

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }
}
