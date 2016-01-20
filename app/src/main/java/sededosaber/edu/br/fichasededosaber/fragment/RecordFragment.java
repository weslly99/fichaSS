package sededosaber.edu.br.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

import sededosaber.edu.br.fichasededosaber.R;
import sededosaber.edu.br.fichasededosaber.model.LabRecord;
import sededosaber.edu.br.fichasededosaber.model.Record;

/**
 * Created by weslly on 20/01/16.
 */
public class RecordFragment extends Fragment {

    private static final String ARG_ID_RECORD = "id_record";

    private EditText mNameET;

    private Record mRecord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UUID id = (UUID) getArguments().getSerializable(ARG_ID_RECORD);
        mRecord = LabRecord.getLabRecord(getActivity()).getRecord(id);

        View view = inflater.inflate(R.layout.fragment_record,container,false);
        mNameET = (EditText) view.findViewById(R.id.record_name);
        mNameET.setText(mRecord.getCertificate().getName());

        return view;
    }

    public static RecordFragment newInstance(Record record) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_ID_RECORD,record.getId());

        RecordFragment fragment = new RecordFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

}
