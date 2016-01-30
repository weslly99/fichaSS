package br.edu.sededosaber.fichasededosaber.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by weslly on 19/01/16.
 */
public class BirthCertificate {

    private UUID mId;
    private String mName;
    private String mNameFather;
    private String mNameMother;
    private Date mBirthDay;
    private String mCity;
    private String mState;
    private String mNotaryOffice;
    private String mBook;
    private String mNumber;

    public BirthCertificate() {
        this(UUID.randomUUID());
    }

    public BirthCertificate(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getNameFather() {
        return mNameFather;
    }

    public void setNameFather(String nameFather) {
        mNameFather = nameFather;
    }

    public String getNameMother() {
        return mNameMother;
    }

    public void setNameMother(String nameMother) {
        mNameMother = nameMother;
    }

    public Date getBirthDay() {
        return mBirthDay;
    }

    public void setBirthDay(Date birthDay) {
        mBirthDay = birthDay;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getNotaryOffice() {
        return mNotaryOffice;
    }

    public void setNotaryOffice(String notaryOffice) {
        mNotaryOffice = notaryOffice;
    }

    public String getBook() {
        return mBook;
    }

    public void setBook(String book) {
        mBook = book;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }
}
