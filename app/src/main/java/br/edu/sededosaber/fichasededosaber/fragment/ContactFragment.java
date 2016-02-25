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
    private EditText mPhoneField;
    private EditText mStreetField;
    private EditText mNumberField;
    private EditText mNeighborhoodField;
    private EditText mCityField;
    private EditText mStateField;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UUID id = (UUID) getArguments().getSerializable(ARG_CONTACT_ID);
        mContact = LabRecord.getLabRecord(getActivity())
                            .getRecord(id).getContacts();


        View view = inflater.inflate(R.layout.fragment_contact_tab, container, false);

        mPhoneField = (EditText) view.findViewById(R.id.contact_phone_edit_text);
        mPhoneField.addTextChangedListener(new MaskTextWatcher("(##)####-####",
                "(##)#####-####", mPhoneField));

        mNumberField = (EditText) view.findViewById(R.id.contact_number_edit_text);
        mStreetField = (EditText) view.findViewById(R.id.contact_street_edit_text);
        mNeighborhoodField = (EditText) view.findViewById(R.id.contact_neighborhood_edit_text);
        mCityField = (EditText) view.findViewById(R.id.contact_city_edit_text);
        mStateField = (EditText) view.findViewById(R.id.contact_state_edit_text);

        updateUI();

        return view;
    }

    private void updateUI() {

        mPhoneField.setText(mContact.getPhone());
        mNumberField.setText(mContact.getNumber());
        mStreetField.setText(mContact.getStreet());
        mNeighborhoodField.setText(mContact.getNeighborhood());
        mCityField.setText(mContact.getCity());
        mStreetField.setText(mContact.getState());
        mStateField.setText(mContact.getState());

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
        mContact.setPhone(MaskTextWatcher.removeMask(mPhoneField.getText().toString()));
        mContact.setNumber(mNumberField.getText().toString());
        mContact.setStreet(mStreetField.getText().toString());
        mContact.setNeighborhood(mNeighborhoodField.getText().toString());
        mContact.setCity(mCityField.getText().toString());
        mContact.setState(mStateField.getText().toString());
    }
}
