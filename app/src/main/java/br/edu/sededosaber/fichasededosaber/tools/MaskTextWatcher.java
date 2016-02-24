package br.edu.sededosaber.fichasededosaber.tools;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by weslly on 18/02/16.
 * API para mascaras
 */
public class MaskTextWatcher<E extends EditText> implements TextWatcher {

    private static final String TAG = "MaskTextWatcher";
    private boolean mIsUpdating = false;
    private String mOld = "";
    private String mLittleMask;
    private String mLongMask = "";
    private E mText;

    public MaskTextWatcher(String mask, E text) {
        this.mLittleMask = mask.trim();
        this.mText = text;
    }

    public MaskTextWatcher(String littleMask, String longMask, E text) {
        this(littleMask, text);
        this.mLongMask = longMask.trim();
    }

    public static String removeMask(String mask) {
        return mask.replaceAll("[-]", "").replaceAll("[.]", "")
                .replaceAll("[(]", "").replaceAll("[)]", "")
                .replaceAll("[/]", "").trim();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = removeMask(s.toString());
        String toReturn = "";
        if (mIsUpdating) {
            mOld = str;
            mIsUpdating = false;
            return;
        }

        if (removeMask(mLongMask).length() != count &&
                mLittleMask.length() >= s.toString().length()) {

            toReturn += maskedText(mLittleMask, str);
        } else {
            toReturn += maskedText(mLongMask, str);
        }

        mIsUpdating = true;
        mText.setText(toReturn);
        mText.setSelection(toReturn.length());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private String maskedText(String mask, String str) {
        String masked = "";
        int i = 0;
        if (mask.length() == 0) {
            mask = mLittleMask;
        }
        for (char c : mask.toCharArray()) {
            if (c != '#' && str.length() > mOld.length()) {
                masked += c;
                continue;
            } else {
                try {
                    masked += str.charAt(i);
                } catch (Exception e) {
                    break;
                }
            }
            i++;
        }
        return masked;
    }

}
