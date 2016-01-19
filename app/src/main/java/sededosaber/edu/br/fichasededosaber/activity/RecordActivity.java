package sededosaber.edu.br.fichasededosaber.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {

   public static Intent newIntent(Context context){
       Intent intent = new Intent(context,RecordActivity.class);
       return intent;
   }
}