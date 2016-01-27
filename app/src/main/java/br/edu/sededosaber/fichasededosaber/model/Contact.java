package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 19/01/16.
 */
public class Contact {

    private UUID mId;
    private String mPhone;
    private String mState;
    private String mCity;
    private String mNeighborhood;
    private String mStreet;
    private String mNumber;


    public Contact(){
       this(UUID.randomUUID());
    }

    public Contact(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getNeighborhood() {
        return mNeighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        mNeighborhood = neighborhood;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }
}
