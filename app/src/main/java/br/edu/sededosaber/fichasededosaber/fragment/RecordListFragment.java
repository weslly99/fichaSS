package br.edu.sededosaber.fichasededosaber.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import java.util.List;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.activity.RecordActivity;
import br.edu.sededosaber.fichasededosaber.model.BirthCertificate;
import br.edu.sededosaber.fichasededosaber.model.ClassRoom;
import br.edu.sededosaber.fichasededosaber.model.Contact;
import br.edu.sededosaber.fichasededosaber.model.Docs;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;

/**
 * Created by weslly on 18/01/16.
 */
public class RecordListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecordAdapter mRecordAdapter;
    private FloatingActionButton mFabAddRecord;
    private FloatingActionButton mFabAddClassRoom;
    private Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_recyclerview, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.studant_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mToolbar = (Toolbar) view.findViewById(R.id.record_list_toolbar);

        mFabAddRecord = (FloatingActionButton)view.findViewById(R.id.fab_add_record);
        mFabAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record = new Record();
                BirthCertificate birthCertificate = new BirthCertificate();
                Contact contact = new Contact();
                Docs docs = new Docs();
                ClassRoom classroom = new ClassRoom();

                record.setClassRoom(classroom);
                record.setDocs(docs);
                record.setCertificate(birthCertificate);
                record.setContacts(contact);


                LabRecord.getLabRecord(getActivity()).addRecord(record);
                Intent intent = RecordActivity.newIntent(getActivity(),record.getId());
                startActivity(intent);
            }
        });

        mFabAddClassRoom =(FloatingActionButton) view.findViewById(R.id.fab_add_classroom);



        updateUI();

        return view;
    }

    public void updateUI() {
        LabRecord labRecord =
                LabRecord.getLabRecord(getActivity());

        if (mRecyclerView.getAdapter() == null) {
            mRecordAdapter = new RecordAdapter(labRecord.getRecords());
            mRecyclerView.setAdapter(mRecordAdapter);
        } else {
            mRecordAdapter.setRecords(labRecord.getRecords());
            mRecordAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


    public static RecordListFragment newInstance() {
        RecordListFragment fragment = new RecordListFragment();
        return fragment;
    }

    private class RecordHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private Record mRecord;
        private TextView mNameTV;
        private TextView mClassRoomTV;
        private TextView mShiftTV;

        public RecordHolder(View itemView) {
            super(itemView);
            mNameTV = (TextView) itemView.findViewById(R.id.record_item_name);
            mClassRoomTV = (TextView) itemView.findViewById(R.id.record_item_classroom);
            mShiftTV = (TextView) itemView.findViewById(R.id.record_item_shift);
            itemView.setOnClickListener(this);
        }

        public void bindHolder(Record record) {
            mRecord = record;
            mNameTV.setText(record.getCertificate().getName());
            mClassRoomTV.setText(record.getClassRoom().getName());
           // String shift = getString(record.getClassRoom().getPeriod().getText());
           // mShiftTV.setText(shift);
        }

        @Override
        public void onClick(View v) {
            Intent intent = RecordActivity.newIntent(getActivity(), mRecord.getId());
            startActivity(intent);
        }

    }

    private class RecordAdapter extends RecyclerView.Adapter<RecordHolder> {
        private List<Record> mRecords;

        public RecordAdapter(List<Record> records) {
            mRecords = records;
        }

        @Override
        public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.record_item_recyclerview, parent, false);

            return new RecordHolder(view);
        }

        @Override
        public void onBindViewHolder(RecordHolder holder, int position) {
            holder.bindHolder(mRecords.get(position));
        }

        @Override
        public int getItemCount() {
            return mRecords.size();
        }

        public void setRecords(List<Record> records){
            mRecords =records;
        }
    }

}
