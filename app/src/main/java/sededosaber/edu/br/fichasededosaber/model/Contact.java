package sededosaber.edu.br.fichasededosaber.model;

import java.util.UUID;

/**
 * Created by weslly on 19/01/16.
 */
public class Contact {

    private UUID mId;
    private String mPhone;
    private String mEmail;


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

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
