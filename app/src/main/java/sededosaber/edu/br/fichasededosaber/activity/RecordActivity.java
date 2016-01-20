package sededosaber.edu.br.fichasededosaber.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

import sededosaber.edu.br.fichasededosaber.R;
import sededosaber.edu.br.fichasededosaber.fragment.RecordFragment;
import sededosaber.edu.br.fichasededosaber.model.LabRecord;
import sededosaber.edu.br.fichasededosaber.model.Record;

public class RecordActivity extends AppCompatActivity {
    private static final String EXTRA_ID_RECORD =
            "br.edu.sededosaber.fichasededosaber.extra_id_record";

    private ViewPager mViewPager;
    private List<Record> mRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_page);

        UUID idRecord = (UUID) getIntent().getSerializableExtra(EXTRA_ID_RECORD);

        FragmentManager fm = getSupportFragmentManager();
        mRecords = LabRecord.getLabRecord(this).getRecords();

        mViewPager = (ViewPager) findViewById(R.id.record_view_pager);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Record record = mRecords.get(position);
                return RecordFragment.newInstance(record);
            }

            @Override
            public int getCount() {
                return mRecords.size();
            }
        });

        for(int i = 0; i<mRecords.size();i++){
            if(mRecords.get(i).getId().equals(idRecord)){
                mViewPager.setCurrentItem(i);
            }
        }

    }

    public static Intent newIntent(Context context,UUID id){

       Intent intent = new Intent(context,RecordActivity.class);
        intent.putExtra(EXTRA_ID_RECORD,id);
       return intent;
   }


}