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
public class ClassroomFragment extends Fragment {
   private static final String ARG_CLASSROOM_ID = "arg_classroom_id";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classroom,container,false);

        return view;
    }

    public static ClassroomFragment newInstance(Record record){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CLASSROOM_ID, record.getId());

        ClassroomFragment fragment = new ClassroomFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
}
