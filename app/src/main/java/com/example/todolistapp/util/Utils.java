package com.example.todolistapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern("EEE, MMM d");
        // Jan, 30 2025
        return simpleDateFormat.format(date);

    }
}
