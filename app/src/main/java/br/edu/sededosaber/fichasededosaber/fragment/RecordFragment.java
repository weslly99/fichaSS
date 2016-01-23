package br.edu.sededosaber.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;

/**
 * Created by weslly on 20/01/16.
 */
public class RecordFragment extends Fragment {

    private static final String ARG_ID_RECORD = "id_record";

    private EditText mNameET;
    private EditText mNameFatherET;
    private EditText mNameMotherET;
    private EditText mCityET;
    private EditText mStateET;
    private EditText mNotaryOfficeET;
    private EditText mNumber;
    private EditText mBook;
    private Button mDateButton;

    private Record mRecord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UUID id = (UUID) getArguments().getSerializable(ARG_ID_RECORD);
        mRecord = LabRecord.getLabRecord(getActivity()).getRecord(id);

        View view = inflater.inflate(R.layout.fragment_record,container,false);
        mNameET = (EditText) view.findViewById(R.id.record_name_edit_text);
        mNameET.setText(mRecord.getCertificate().getName());
        mNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNameFatherET =(EditText) view.findViewById(R.id.record_name_father_edit_text);
        mNameFatherET.setText(mRecord.getCertificate().getNameFather());
        mNameFatherET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setNameFather(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNameMotherET =(EditText) view.findViewById(R.id.record_name_mother_edit_text);
        mNameMotherET.setText(mRecord.getCertificate().getNameMother());
        mNameMotherET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setNameMother(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCityET = (EditText) view.findViewById(R.id.record_city_edit_text);
        mCityET.setText(mRecord.getCertificate().getCity());
        mCityET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStateET = (EditText) view.findViewById(R.id.record_state_edit_text);
        mStateET.setText(mRecord.getCertificate().getState());
        mStateET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setState(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNotaryOfficeET = (EditText) view.findViewById(R.id.record_notary_office_edit_text);
        mNotaryOfficeET.setText(mRecord.getCertificate().getNotaryOffice());
        mNotaryOfficeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setNotaryOffice(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBook = (EditText) view.findViewById(R.id.record_book_edit_text);
        mBook.setText(mRecord.getCertificate().getBook());
        mBook.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setBook(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNumber = (EditText) view.findViewById(R.id.record_number_edit_text);
        mNumber.setText(mRecord.getCertificate().getNumber());
        mNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getCertificate().setNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) view.findViewById(R.id.record_bith_day_button);
        configDate();

        return view;
    }

    public static RecordFragment newInstance(Record record) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_ID_RECORD,record.getId());

        RecordFragment fragment = new RecordFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    private void configDate(){
        Date date = mRecord.getCertificate().getBirthDay();
        if(date != null){
            mDateButton.setText(date.toString());
        }
    }
}