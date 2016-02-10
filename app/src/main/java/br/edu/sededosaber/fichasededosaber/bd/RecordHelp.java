package br.edu.sededosaber.fichasededosaber.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.sededosaber.fichasededosaber.bd.SchemeDb.CertificateTable;
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
                "contact_id integer primary key autoincrement, " +
                ContactTable.Cols.UUID + ", " +
                ContactTable.Cols.PHONE + ", " +
                ContactTable.Cols.NUMBER + ", " +
                ContactTable.Cols.STREET + ", " +
                ContactTable.Cols.NEIGHBORHOOD + ", " +
                ContactTable.Cols.CITY + ", " +
                ContactTable.Cols.STATE);

        db.execSQL("Create table " + DocsTable.NAME + "(" +
                "docs_id integer primary key autoincrement, " +
                DocsTable.Cols.UUID + ", " +
                DocsTable.Cols.CPF_FATHER + ", " +
                DocsTable.Cols.CPF_MOTHER + ", " +
                DocsTable.Cols.RG_FATHER + ", " +
                DocsTable.Cols.RG_MOTHER + ", ");

        db.execSQL("Create table " + CertificateTable.NAME + "(" +
                "certificate_id integer primary key autoincrement, " +
                CertificateTable.Cols.UUID + ", " +
                CertificateTable.Cols.NAME + ", " +
                CertificateTable.Cols.NAME_FATHER + ", " +
                CertificateTable.Cols.NAME_MOTHER + ", " +
                CertificateTable.Cols.BIRTH_DAY + ", " +
                CertificateTable.Cols.BOOK + ", " +
                CertificateTable.Cols.CITY + ", " +
                CertificateTable.Cols.STATE + ", " +
                CertificateTable.Cols.NUMBER + ", " +
                CertificateTable.Cols.NOTARY_OFFICE);

        db.execSQL("Create table " + ClassroomTable.NAME + "(" +
                "classroom_id integer primary key autoincrement," +
                ClassroomTable.Cols.UUID + ", " +
                ClassroomTable.Cols.NAME + ", " +
                ClassroomTable.Cols.SHIFT + " INTEGER, ");

        db.execSQL("CREATE TABLE " + RecordTable.NAME + "(" +
                "record_id integer primary key autoincrement," +
                RecordTable.Cols.UUID + ", " +
                RecordTable.Cols.ID_CERTIFICATE + ", " +
                RecordTable.Cols.ID_CONTACT + ", " +
                RecordTable.Cols.ID_DOCS + ", " +
                RecordTable.Cols.ID_CLASSROM +
                "FOREGIN KEY (" + RecordTable.Cols.ID_CERTIFICATE + ")  REFERENCES "
                + CertificateTable.NAME + "(certificate_id)," +
                "FOREGIN KEY (" + RecordTable.Cols.ID_CONTACT + ") REFERENCES"
                + ContactTable.NAME + " (contact_id)," +
                "FOREGIN KEY (" + RecordTable.Cols.ID_DOCS + ") REFERENCES"
                + DocsTable.NAME + " (docs_id), " +
                "FOREGIN KEY (" + RecordTable.Cols.ID_CLASSROM + ") REFERENCES "
                + ClassroomTable.NAME + " (classroom_id)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
