package br.edu.sededosaber.fichasededosaber.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.edu.sededosaber.fichasededosaber.R;

/**
 * Created by weslly on 30/01/16.
 */
public class DateFragment extends DialogFragment {

    public static final String EXTRA_DATE = "extra_date";
    private static final String ARG_DATE = "arg_date";
    private DatePicker mDatePicker;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Date date = (Date) getArguments().get(ARG_DATE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.dialog_date,null, false);
        mDatePicker = (DatePicker) view.findViewById(R.id.datepicker_dialog);
        mDatePicker.init(year,month,day,null);
        mDatePicker.setMaxDate(date.getTime());


        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(getString(R.string.bith_day))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int year = mDatePicker.getYear();
                        int month = mDatePicker.getMonth();
                        int day = mDatePicker.getDayOfMonth();
                        GregorianCalendar gregorian = new GregorianCalendar(year,month,day);
                        sendResult(Activity.RESULT_OK,gregorian.getTime());

                    }
                })
                .create();
    }

    public static DateFragment newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        DateFragment fragment = new DateFragment();
        fragment.setArguments(args);

        return fragment;
    }


    private void sendResult(int resp, Date date){

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE,date);

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resp, intent);
    }
}
