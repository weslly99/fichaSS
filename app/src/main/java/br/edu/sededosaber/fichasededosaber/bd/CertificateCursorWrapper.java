package br.edu.sededosaber.fichasededosaber.bd;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by weslly on 10/02/16.
 */
public class CertificateCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CertificateCursorWrapper(Cursor cursor) {
        super(cursor);
    }
}
