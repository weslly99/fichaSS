package br.edu.sededosaber.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.R;

/**
 * Created by weslly on 23/01/16.
 */
public class ClassroomFragment extends Fragment {
   private static final String ARG_CLASSROOM_ID = "arg_classroom_id";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classroom,container,false);

        return view;
    }


    public static ClassroomFragment newInstance(UUID idClassRoom){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CLASSROOM_ID, idClassRoom);

        ClassroomFragment fragment = new ClassroomFragment();
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_classroom,menu);
    }
}
