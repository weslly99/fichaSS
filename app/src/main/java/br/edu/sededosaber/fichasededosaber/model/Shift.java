package br.edu.sededosaber.fichasededosaber.model;

import br.edu.sededosaber.fichasededosaber.R;

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
