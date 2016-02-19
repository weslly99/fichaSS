package br.edu.sededosaber.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private Contact mContact;
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
        mContact = LabRecord.getLabRecord(getActivity())
                            .getRecord(id).getContacts();


        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        mPhone = (EditText) view.findViewById(R.id.contact_phone_edit_text);
        mPhone.addTextChangedListener(new MaskTextWatcher("(##)####-####",
                "(##)#####-####", mPhone));

        mNumber = (EditText) view.findViewById(R.id.contact_number_edit_text);
        mStreet = (EditText) view.findViewById(R.id.contact_street_edit_text);
        mNeighborhood = (EditText) view.findViewById(R.id.contact_neighborhood_edit_text);
        mCity = (EditText) view.findViewById(R.id.contact_city_edit_text);
        mState = (EditText) view.findViewById(R.id.contact_state_edit_text);

        updateUI();

        return view;
    }

    private void updateUI() {

        mPhone.setText(mContact.getPhone());
        mNumber.setText(mContact.getNumber());
        mStreet.setText(mContact.getStreet());
        mNeighborhood.setText(mContact.getNeighborhood());
        mCity.setText(mContact.getCity());
        mStreet.setText(mContact.getState());
        mState.setText(mContact.getState());

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
        mContact.setPhone(MaskTextWatcher.removeMask(mPhone.getText().toString()));
        mContact.setNumber(mNumber.getText().toString());
        mContact.setStreet(mStreet.getText().toString());
        mContact.setNeighborhood(mNeighborhood.getText().toString());
        mContact.setCity(mCity.getText().toString());
        mContact.setState(mState.getText().toString());
    }
}
