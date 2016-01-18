package sededosaber.edu.br.fichasededosaber;

import android.support.v4.app.Fragment;

public class FichaActivity extends SingleActivityFragment {


    @Override
    public Fragment createFragment() {
        return AlunoListFragment.newInstance();
    }
}