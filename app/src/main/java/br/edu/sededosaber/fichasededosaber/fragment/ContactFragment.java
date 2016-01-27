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
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;

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


        View view = inflater.inflate(R.layout.fragment_contact,container,false);

        mPhone = (EditText) view.findViewById(R.id.contact_phone_edit_text);
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getContacts().setPhone(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        
        return view;
    }

    public static ContactFragment newInstance(Record record){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CONTACT_ID,record.getId());

        ContactFragment contactFragment = new ContactFragment();
        contactFragment.setArguments(bundle);

        return contactFragment;
    }
}
