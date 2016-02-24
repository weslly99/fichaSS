package br.edu.sededosaber.fichasededosaber.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weslly on 10/02/16.
 */
public class LabClassRoom {

    private static LabClassRoom sLabClassRoom;
    private List<ClassRoom> mClassRooms;
    private LabClassRoom(Context context){
        mClassRooms = new ArrayList<>();
    }
    public LabClassRoom getLabClassRoom(Context context){

        if(sLabClassRoom== null){
            sLabClassRoom = new LabClassRoom(context.getApplicationContext());
        }

        return  sLabClassRoom;
    }

    public void add(ClassRoom classRoom){
        mClassRooms.add(classRoom);
    }

    public ClassRoom getClassRoom(UUID idClassRoom){

        int pos = getPosition(idClassRoom);
        if(pos>=0){
            return  mClassRooms.get(pos);
        }
        return null;
    }

    public List<ClassRoom> getClassRooms(){
        return mClassRooms;
    }

    public void delete(UUID id){
        mClassRooms.remove(getPosition(id));
    }

    //if have return >=0 else return -1
    private int getPosition(UUID id){
        for(int i = 0; i<mClassRooms.size();i++){
            if(mClassRooms.get(i).getUUID().equals(id)){
                return i;
            }
        }
        return  -1;
    }
}
