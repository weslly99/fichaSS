package br.edu.sededosaber.fichasededosaber.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;

/**
 * Created by weslly on 20/01/16.
 */
public class CertificateFragment extends Fragment {

    private static final String ARG_ID_RECORD = "id_record";
    private static final String DATE_ID = "date";
    private static final int DATE_CODE = 0;

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

        View view = inflater.inflate(R.layout.fragment_certificate, container, false);

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

        mNameFatherET = (EditText) view.findViewById(R.id.record_name_father_edit_text);
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

        mNameMotherET = (EditText) view.findViewById(R.id.record_name_mother_edit_text);
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
        setupDate(mRecord.getCertificate().getBirthDay());

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DateFragment dateFragment =
                        DateFragment.newInstance(new Date());
                dateFragment.setTargetFragment(CertificateFragment.this, DATE_CODE);
                dateFragment.show(fm, DATE_ID);
            }
        });

        return view;
    }

    private void setupDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        if (date != null) {
            mDateButton.setText(dateFormat.format(date));
        }
    }

    public static CertificateFragment newInstance(Record record) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_ID_RECORD, record.getId());

        CertificateFragment fragment = new CertificateFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case DATE_CODE:
                Date date = (Date)
                        data.getSerializableExtra(DateFragment.EXTRA_DATE);
                mRecord.getCertificate().setBirthDay(date);
                setupDate(date);

        }
    }
}
