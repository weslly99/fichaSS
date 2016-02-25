package br.edu.sededosaber.fichasededosaber.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.model.BirthCertificate;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;

/**
 * Created by weslly on 20/01/16.
 */
public class CertificateFragment extends Fragment {

    private static final String ARG_ID_RECORD = "id_record";
    private static final String DATE_ID = "date";
    private static final int DATE_CODE = 0;

    private EditText mNameField;
    private EditText mNameFatherField;
    private EditText mNameMotherField;
    private EditText mCityField;
    private EditText mStateField;
    private EditText mNotaryOfficeField;
    private EditText mNumberField;
    private EditText mBookField;
    private Button mDateButton;

    private BirthCertificate mBirthCertificate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UUID id = (UUID) getArguments().getSerializable(ARG_ID_RECORD);
        mBirthCertificate = LabRecord.getLabRecord(getActivity())
                .getRecord(id).getCertificate();

        View view = inflater.inflate(R.layout.fragment_certificate_tab, container, false);

        mNameField = (EditText) view.findViewById(R.id.record_name_edit_text);
        mNameFatherField = (EditText) view.findViewById(R.id.record_name_father_edit_text);
        mNameMotherField = (EditText) view.findViewById(R.id.record_name_mother_edit_text);
        mCityField = (EditText) view.findViewById(R.id.record_city_edit_text);
        mStateField = (EditText) view.findViewById(R.id.record_state_edit_text);
        mNotaryOfficeField = (EditText) view.findViewById(R.id.record_notary_office_edit_text);
        mBookField = (EditText) view.findViewById(R.id.record_book_edit_text);
        mNumberField = (EditText) view.findViewById(R.id.record_number_edit_text);
        mDateButton = (Button) view.findViewById(R.id.record_bith_day_button);

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

        updateUI();

        return view;
    }

    private void setupDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        if (date != null) {
            mDateButton.setText(dateFormat.format(date));
        }
    }

    private void updateUI() {
        mNameField.setText(mBirthCertificate.getName());
        mNameFatherField.setText(mBirthCertificate.getNameFather());
        mNameMotherField.setText(mBirthCertificate.getNameMother());
        mCityField.setText(mBirthCertificate.getCity());
        mStateField.setText(mBirthCertificate.getState());
        mNotaryOfficeField.setText(mBirthCertificate.getNotaryOffice());
        mBookField.setText(mBirthCertificate.getBook());
        mNumberField.setText(mBirthCertificate.getNumber());
        setupDate(mBirthCertificate.getBirthDay());
    }

    @Override
    public void onPause() {
        super.onPause();
        mBirthCertificate.setName(mNameField.getText().toString());
        mBirthCertificate.setNameFather(mNameFatherField.getText().toString());
        mBirthCertificate.setNameMother(mNameMotherField.getText().toString());
        mBirthCertificate.setCity(mCityField.getText().toString());
        mBirthCertificate.setState(mStateField.getText().toString());
        mBirthCertificate.setNotaryOffice(mNotaryOfficeField.getText().toString());
        mBirthCertificate.setBook(mBookField.getText().toString());
        mBirthCertificate.setNumber(mNumberField.getText().toString());
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
                mBirthCertificate.setBirthDay(date);
                setupDate(date);

        }
    }
}
