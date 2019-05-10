package com.gdc.mysportdb.utils;

import android.view.View;
import android.widget.ProgressBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static void getVisible(ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void getGone(ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);
    }

    public static String getDateEvent(String inputDate) {
        Date parsed = null;
        String outputDated = "";

        SimpleDateFormat df_input = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        SimpleDateFormat df_output = new SimpleDateFormat("dd MMM yyyy", Locale.US);

        try {
            parsed = df_input.parse(inputDate);
            outputDated = df_output.format(parsed);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outputDated;
    }
}
