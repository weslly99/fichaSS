package sededosaber.edu.br.fichasededosaber;

import android.support.v4.app.Fragment;

public class RecordActivity extends SingleActivityFragment {


    @Override
    public Fragment createFragment() {
        return RecordListFragment.newInstance();
    }
}