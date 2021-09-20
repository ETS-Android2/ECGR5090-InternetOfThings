package com.example.a49nersense.common;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    public static final String APP_ID = "120d6bfcf2d503e0386be4fcd59d27f6";
    public static Location current_location = null;


    public static String convertUnixToDate(long dt) {

        Date date = new Date (dt * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd EEE MM yyyy");
        String formatted = sdf.format(date);
        return formatted;

    }

    public static String convertUnixToHour(long dt) {

        Date date = new Date (dt * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String formatted = sdf.format(date);
        return formatted;

    }
}
