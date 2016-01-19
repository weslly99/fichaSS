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
public class RecordListFragment extends Fragment{

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_list,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.studant_recycler_view);

        return view;
    }


    public static RecordListFragment newInstance() {
        RecordListFragment fragment = new RecordListFragment();
        return fragment;
    }
}
