package br.edu.sededosaber.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 29/01/16.
 */
public class Docs {

    private UUID mId;
    private String mCpfFather;
    private String mRgFather;
    private String mRgMother;
    private String mCpfMother;


    public Docs(){
        this(UUID.randomUUID());
    }
    public Docs(UUID id){
        mId = id;
    }


    public String getCpfFather() {
        return mCpfFather;
    }

    public void setCpfFather(String cpfFather) {
        mCpfFather = cpfFather;
    }

    public String getRgFather() {
        return mRgFather;
    }

    public void setRgFather(String rgFather) {
        mRgFather = rgFather;
    }

    public String getRgMother() {
        return mRgMother;
    }

    public void setRgMother(String rgMother) {
        mRgMother = rgMother;
    }

    public String getCpfMother() {
        return mCpfMother;
    }

    public void setCpfMother(String cpfMother) {
        mCpfMother = cpfMother;
    }

    public UUID getId() {
        return mId;
    }
}

