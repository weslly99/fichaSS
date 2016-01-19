package sededosaber.edu.br.fichasededosaber.model;

import sededosaber.edu.br.fichasededosaber.R;

/**
 * Created by weslly on 19/01/16.
 */
public enum Shift {
    MORNING(R.string.shift_morning),AFTERNOON(R.string.shift_afternoon);

   private int text;

    Shift(int t){
        text = t;
    }

    public int getText() {
        return text;
    }
}
