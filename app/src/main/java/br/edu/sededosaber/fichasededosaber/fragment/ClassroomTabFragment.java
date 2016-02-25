package br.edu.sededosaber.fichasededosaber.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.model.ClassRoom;

/**
 * Created by weslly on 24/02/16.
 */
public class ClassroomTabFragment extends Fragment {

    private static final String ARG_ID_CLASS_ROOM="argIdClassRoom";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_classroom_tab,container,false);


        return view;
    }

    public static ClassroomTabFragment newInstance(ClassRoom classRoom){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_ID_CLASS_ROOM, classRoom.getUUID());
        ClassroomTabFragment fragment = new ClassroomTabFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
}
