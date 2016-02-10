package br.edu.sededosaber.fichasededosaber.bd;

import android.database.Cursor;
import android.database.CursorWrapper;

import br.edu.sededosaber.fichasededosaber.model.BirthCertificate;

/**
 * Created by weslly on 10/02/16.
 */
public class BirthCertificateCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public BirthCertificateCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public BirthCertificate getBirthCertificate(){




        return null;

    }
}
