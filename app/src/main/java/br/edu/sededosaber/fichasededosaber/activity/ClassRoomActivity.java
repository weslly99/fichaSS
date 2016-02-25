package br.edu.sededosaber.fichasededosaber.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

import br.edu.sededosaber.fichasededosaber.fragment.ClassroomFragment;

/**
 * Created by weslly on 24/02/16.
 */
public class ClassRoomActivity extends SingleActivityFragment{


    private static final String ID_CLASSROOM_EXTRA ="id_classroom_extra";

    public static Intent newIntent(Context context,UUID idClassRoom){
        Intent intent = new Intent(context,ClassRoomActivity.class);
        intent.putExtra(ID_CLASSROOM_EXTRA,idClassRoom);
        return intent;
    }


    @Override
    public Fragment createFragment() {
        UUID idClassroom = (UUID)getIntent().getSerializableExtra(ID_CLASSROOM_EXTRA);
        return ClassroomFragment.newInstance(idClassroom);
    }
}
