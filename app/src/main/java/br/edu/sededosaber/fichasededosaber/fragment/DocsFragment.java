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
    private EditText mCpfFather;
    private EditText mRgFather;
    private EditText mCpfMother;
    private EditText mRgMother;
    private Docs mDocs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        UUID uuid = (UUID) getArguments().get(ARG_DOC_ID);
        mDocs = LabRecord.getLabRecord(getActivity()).getRecord(uuid).getDocs();

        View view = inflater.inflate(R.layout.fragment_docs, container, false);


        mCpfFather = (EditText) view.findViewById(R.id.record_cpf_father_edit_text);
        mCpfFather.setText(mDocs.getCpfFather());
        mCpfFather.addTextChangedListener(
                new MaskTextWatcher<EditText>("###.###.###-##", mCpfFather));

        mRgFather = (EditText) view.findViewById(R.id.record_rg_father_edit_text);
        mRgFather.setText(mDocs.getRgFather());

        mCpfMother = (EditText) view.findViewById(R.id.record_cpf_mother_edit_text);
        mCpfMother.setText(mDocs.getCpfMother());
        mCpfMother.addTextChangedListener(
                new MaskTextWatcher<EditText>("###.###.###-##", mCpfMother));

        mRgMother = (EditText) view.findViewById(R.id.record_rg_mother_edit_text);
        mRgMother.setText(mDocs.getRgMother());

        updateUI();

        return view;
    }


    private void updateUI() {
        mCpfFather.setText(mDocs.getCpfFather());
        mRgFather.setText(mDocs.getRgFather());
        mCpfMother.setText(mDocs.getCpfMother());
        mRgMother.setText(mDocs.getRgMother());
    }

    @Override
    public void onPause() {
        super.onPause();
        mDocs.setCpfFather(MaskTextWatcher.removeMask(mCpfFather.getText().toString()));
        mDocs.setCpfMother(MaskTextWatcher.removeMask(mCpfMother.getText().toString()));
        mDocs.setRgMother(mRgMother.getText().toString());
        mDocs.setRgFather(mRgFather.getText().toString());
    }

    public static DocsFragment newInstance(Record record) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_DOC_ID, record.getId());
        DocsFragment docsFragment = new DocsFragment();
        docsFragment.setArguments(bundle);
        return docsFragment;
    }
}
