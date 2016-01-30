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
 * Created by weslly on 29/01/16.
 */
public class DocsFragment extends Fragment {

    private static final String ARG_DOC_ID = "arg_doc_id";
    private EditText mCpfFather;
    private EditText mRgFather;
    private EditText mCpfMother;
    private EditText mRgMother;
    private Record mRecord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        UUID uuid = (UUID ) getArguments().get(ARG_DOC_ID);
        mRecord = LabRecord.getLabRecord(getActivity()).getRecord(uuid);

        View view = inflater.inflate(R.layout.fragment_docs,container,false);


        mCpfFather = (EditText) view.findViewById(R.id.record_cpf_father_edit_text);
        mCpfFather.setText(mRecord.getDocs().getCpfFather());
        mCpfFather.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getDocs().setCpfFather(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRgFather = (EditText) view.findViewById(R.id.record_rg_father_edit_text);
        mRgFather.setText(mRecord.getDocs().getRgFather());
        mRgFather.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getDocs().setRgFather(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCpfMother = (EditText) view.findViewById(R.id.record_cpf_mother_edit_text);
        mCpfMother.setText(mRecord.getDocs().getCpfMother());
        mCpfMother.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getDocs().setCpfMother(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRgMother = (EditText) view.findViewById(R.id.record_rg_mother_edit_text);
        mRgMother.setText(mRecord.getDocs().getRgMother());
        mRgMother.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.getDocs().setRgMother(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    public static DocsFragment newInstance(Record record){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_DOC_ID,record.getId());
        DocsFragment docsFragment = new DocsFragment();
        docsFragment.setArguments(bundle);
        return docsFragment;
    }
}
