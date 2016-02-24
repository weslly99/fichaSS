package br.edu.sededosaber.fichasededosaber.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.sededosaber.fichasededosaber.bd.SchemeDb.BirthCertificateTable;
import br.edu.sededosaber.fichasededosaber.bd.SchemeDb.ClassroomTable;
import br.edu.sededosaber.fichasededosaber.bd.SchemeDb.ContactTable;
import br.edu.sededosaber.fichasededosaber.bd.SchemeDb.DocsTable;
import br.edu.sededosaber.fichasededosaber.bd.SchemeDb.RecordTable;

/**
 * Created by weslly on 07/02/16.
 */
public class RecordHelp extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "record.db";


    public RecordHelp(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + ContactTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                ContactTable.Cols.UUID + ", " +
                ContactTable.Cols.PHONE + ", " +
                ContactTable.Cols.NUMBER + ", " +
                ContactTable.Cols.STREET + ", " +
                ContactTable.Cols.NEIGHBORHOOD + ", " +
                ContactTable.Cols.CITY + ", " +
                ContactTable.Cols.STATE);

        db.execSQL("Create table " + DocsTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                DocsTable.Cols.UUID + ", " +
                DocsTable.Cols.CPF_FATHER + ", " +
                DocsTable.Cols.CPF_MOTHER + ", " +
                DocsTable.Cols.RG_FATHER + ", " +
                DocsTable.Cols.RG_MOTHER + ", ");

        db.execSQL("Create table " + BirthCertificateTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                BirthCertificateTable.Cols.UUID + ", " +
                BirthCertificateTable.Cols.NAME + ", " +
                BirthCertificateTable.Cols.NAME_FATHER + ", " +
                BirthCertificateTable.Cols.NAME_MOTHER + ", " +
                BirthCertificateTable.Cols.BIRTH_DAY + ", " +
                BirthCertificateTable.Cols.CITY + ", " +
                BirthCertificateTable.Cols.STATE + ", " +
                BirthCertificateTable.Cols.NOTARY_OFFICE + ", " +
                BirthCertificateTable.Cols.BOOK + ", " +
                BirthCertificateTable.Cols.NUMBER);

        db.execSQL("Create table " + ClassroomTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                ClassroomTable.Cols.UUID + ", " +
                ClassroomTable.Cols.NAME + ", " +
                ClassroomTable.Cols.SHIFT + " INTEGER, ");

        db.execSQL("CREATE TABLE " + RecordTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                RecordTable.Cols.UUID + ", " +
                RecordTable.Cols.ID_CERTIFICATE + ", " +
                RecordTable.Cols.ID_CONTACT + ", " +
                RecordTable.Cols.ID_DOCS + ", " +
                RecordTable.Cols.ID_CLASSROM +
                "FOREGIN KEY (" + RecordTable.Cols.ID_CERTIFICATE + ")  REFERENCES "
                + BirthCertificateTable.NAME + "(_id)," +
                "FOREGIN KEY (" + RecordTable.Cols.ID_CONTACT + ") REFERENCES"
                + ContactTable.NAME + " (_id)," +
                "FOREGIN KEY (" + RecordTable.Cols.ID_DOCS + ") REFERENCES"
                + DocsTable.NAME + " (_id), " +
                "FOREGIN KEY (" + RecordTable.Cols.ID_CLASSROM + ") REFERENCES "
                + ClassroomTable.NAME + " (_id)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
