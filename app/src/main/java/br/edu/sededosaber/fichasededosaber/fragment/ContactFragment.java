package br.edu.sededosaber.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.model.Contact;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;
import br.edu.sededosaber.fichasededosaber.tools.MaskTextWatcher;

/**
 * Created by weslly on 23/01/16.
 */
public class ContactFragment extends Fragment {

    private static final String ARG_CONTACT_ID = "arg_contact_id";
    private Record mRecord;
    private EditText mPhone;
    private EditText mStreet;
    private EditText mNumber;
    private EditText mNeighborhood;
    private EditText mCity;
    private EditText mState;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UUID id = (UUID) getArguments().getSerializable(ARG_CONTACT_ID);
        mRecord = LabRecord.getLabRecord(getActivity()).getRecord(id);


        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        mPhone = (EditText) view.findViewById(R.id.contact_phone_edit_text);
        mPhone.addTextChangedListener(new MaskTextWatcher("(##)####-####",
                "(##)#####-####", mPhone));

        mNumber = (EditText) view.findViewById(R.id.contact_number_edit_text);
        mNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getContacts().setNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStreet = (EditText) view.findViewById(R.id.contact_street_edit_text);
        mStreet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getContacts().setStreet(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNeighborhood = (EditText) view.findViewById(R.id.contact_neighborhood_edit_text);
        mNeighborhood.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getContacts().setNeighborhood(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCity = (EditText) view.findViewById(R.id.contact_city_edit_text);
        mCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getContacts().setCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mState = (EditText) view.findViewById(R.id.contact_state_edit_text);
        mState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getContacts().setState(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        updateUI(mRecord.getContacts());

        return view;
    }

    private void updateUI(Contact contact) {

        mPhone.setText(contact.getPhone());
        mNumber.setText(contact.getNumber());
        mStreet.setText(contact.getStreet());
        mNeighborhood.setText(contact.getNeighborhood());
        mCity.setText(contact.getCity());
        mStreet.setText(contact.getState());
        mState.setText(contact.getState());

    }

    public static ContactFragment newInstance(Record record) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CONTACT_ID, record.getId());

        ContactFragment contactFragment = new ContactFragment();
        contactFragment.setArguments(bundle);

        return contactFragment;
    }

    @Override
    public void onPause() {
        super.onPause();
        mRecord.getContacts().setPhone(MaskTextWatcher.removeMask(mPhone.getText().toString()));

    }
}
