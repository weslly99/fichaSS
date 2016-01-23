package br.edu.sededosaber.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.model.Record;

/**
 * Created by weslly on 23/01/16.
 */
public class ContactFragment extends Fragment {

    private static final String ARG_CONTACT_ID = "arg_contact_id";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact,container,false);

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
