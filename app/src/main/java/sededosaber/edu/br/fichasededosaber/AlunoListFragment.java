package sededosaber.edu.br.fichasededosaber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by weslly on 18/01/16.
 */
public class AlunoListFragment extends Fragment{

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aluno_list,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.aluno_recycler_view);

        return view;
    }


    public static AlunoListFragment newInstance() {
        AlunoListFragment fragment = new AlunoListFragment();
        return fragment;
    }
}
