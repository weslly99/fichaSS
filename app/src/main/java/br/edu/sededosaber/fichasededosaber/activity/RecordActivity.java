package br.edu.sededosaber.fichasededosaber.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.R;
import br.edu.sededosaber.fichasededosaber.fragment.CertificateFragment;
import br.edu.sededosaber.fichasededosaber.fragment.ClassroomFragment;
import br.edu.sededosaber.fichasededosaber.fragment.ContactFragment;
import br.edu.sededosaber.fichasededosaber.fragment.DocsFragment;
import br.edu.sededosaber.fichasededosaber.model.LabRecord;
import br.edu.sededosaber.fichasededosaber.model.Record;

public class RecordActivity extends AppCompatActivity{

    private static final String TAG = "RecordActivity";
    private static final String EXTRA_ID_RECORD =
            "br.edu.sededosaber.fichasededosaber.extra_id_record";

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Record mRecord;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_tabs);

        UUID idRecord = (UUID) getIntent().getSerializableExtra(EXTRA_ID_RECORD);
        setupRecord(idRecord);

        mToolbar = (Toolbar) findViewById(R.id.record_tab_tool_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mViewPager = (ViewPager) findViewById(R.id.record_tab_view_pager);
        setupViewPageAdapter(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.record_tab_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        configTextColor();

    }

    private void setupRecord(UUID idRecord) {
        List<Record> records = LabRecord.getLabRecord(this).getRecords();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId().equals(idRecord)) {
                mRecord = records.get(i);
            }
        }
    }

    private void configTextColor() {
        int colorNormal = 0;
        int colorSelected = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            colorNormal = getColor(R.color.primaryText);
            colorSelected = getColor(R.color.textIcon);
        } else {
            colorNormal = getResources().getColor(R.color.primaryText);
            colorSelected = getResources().getColor(R.color.textIcon);
        }
        mTabLayout.setTabTextColors(colorNormal, colorSelected);
    }

    private void setupViewPageAdapter(ViewPager viewpager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        String title = getString(R.string.birth_certificate);
        viewPagerAdapter.addFragment(CertificateFragment.newInstance(mRecord), title);
        title = getString(R.string.docs);
        viewPagerAdapter.addFragment(DocsFragment.newInstance(mRecord),title);
        title = getString(R.string.contact);
        viewPagerAdapter.addFragment(ContactFragment.newInstance(mRecord), title);
        title = getString(R.string.classroom);
        viewPagerAdapter.addFragment(ClassroomFragment.newInstance(mRecord), title);



        viewpager.setAdapter(viewPagerAdapter);
    }

    public static Intent newIntent(Context context, UUID id) {

        Intent intent = new Intent(context, RecordActivity.class);
        intent.putExtra(EXTRA_ID_RECORD, id);
        return intent;
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mTitles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_delete: //user select delete menu
                LabRecord.getLabRecord(this).deleteRecord(mRecord.getId());
                finish();
                return true;
            case R.id.menu_item_archive: //user select archive menu
                Log.i(TAG, "menu archive selected");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}