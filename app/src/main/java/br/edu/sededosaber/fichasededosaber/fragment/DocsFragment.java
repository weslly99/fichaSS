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
import br.edu.sededosaber.fichasededosaber.model.Docs;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;
import br.edu.sededosaber.fichasededosaber.tools.MaskTextWatcher;

/**
 * Created by weslly on 29/01/16.
 */
public class DocsFragment extends Fragment {

    private static final String ARG_DOC_ID = "arg_doc_id";
    private Docs mDocs;
    private EditText mCpfFatherField;
    private EditText mRgFatherField;
    private EditText mCpfMotherField;
    private EditText mRgMotherField;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        UUID uuid = (UUID) getArguments().get(ARG_DOC_ID);
        mDocs = LabRecord.getLabRecord(getActivity())
                .getRecord(uuid).getDocs();

        View view = inflater.inflate(R.layout.fragment_docs, container, false);


        mCpfFatherField = (EditText) view.findViewById(R.id.record_cpf_father_edit_text);
        mCpfFatherField.setText(mDocs.getCpfFather());
        mCpfFatherField.addTextChangedListener(
                new MaskTextWatcher<EditText>("###.###.###-##", mCpfFatherField));

        mRgFatherField = (EditText) view.findViewById(R.id.record_rg_father_edit_text);
        mRgFatherField.setText(mDocs.getRgFather());

        mCpfMotherField = (EditText) view.findViewById(R.id.record_cpf_mother_edit_text);
        mCpfMotherField.setText(mDocs.getCpfMother());
        mCpfMotherField.addTextChangedListener(
                new MaskTextWatcher<EditText>("###.###.###-##", mCpfMotherField));

        mRgMotherField = (EditText) view.findViewById(R.id.record_rg_mother_edit_text);
        mRgMotherField.setText(mDocs.getRgMother());

        updateUI();

        return view;
    }


    private void updateUI() {
        mCpfFatherField.setText(mDocs.getCpfFather());
        mRgFatherField.setText(mDocs.getRgFather());
        mCpfMotherField.setText(mDocs.getCpfMother());
        mRgMotherField.setText(mDocs.getRgMother());
    }

    @Override
    public void onPause() {
        super.onPause();
        mDocs.setCpfFather(MaskTextWatcher.removeMask(mCpfFatherField.getText().toString()));
        mDocs.setCpfMother(MaskTextWatcher.removeMask(mCpfMotherField.getText().toString()));
        mDocs.setRgMother(mRgMotherField.getText().toString());
        mDocs.setRgFather(mRgFatherField.getText().toString());
    }

    public static DocsFragment newInstance(Record record) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_DOC_ID, record.getId());
        DocsFragment docsFragment = new DocsFragment();
        docsFragment.setArguments(bundle);
        return docsFragment;
    }
}
