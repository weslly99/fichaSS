package sededosaber.edu.br.fichasededosaber.activity;

import android.support.v4.app.Fragment;

import sededosaber.edu.br.fichasededosaber.fragment.RecordListFragment;

/**
 * Created by weslly on 19/01/16.
 */
public class RecordListActivity extends SingleActivityFragment {

    @Override
    public Fragment createFragment() {
        return RecordListFragment.newInstance();
    }
}
