package com.nehaimgurdemoapp.utils;


import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class DateUtil {

    private DateUtil() {

    }

    public static String getDateTime(Integer mills) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy h:mm a", Locale.getDefault());
        Date date = new Date(mills * 1000L);
        return formatter.format(date);
    }


    public static CharSequence getRelativeTime(Long date) {
        Date datetime = new Date(date * 1000L);
        Date now = new Date();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - datetime.getTime());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - datetime.getTime());
        Log.d(Constants.TAG, "date time difference is " + seconds + " and get time is " + minutes);
        if (seconds < 5)
            return "Just now";
        else if (seconds < 60)
            return String.format("%s %s", seconds, "seconds ago");
        else if (seconds < 120)
            return "A minute ago";
        else if (minutes < 60)
            return String.format("%s %s", minutes, "minutes ago");
        else if (minutes < 120)
            return "1 hour ago";
        else if (minutes < 240)
            return "2 hours ago";
        else if (minutes < 360)
            return "3 hours ago";
        else if (minutes < 480)
            return "4 hours ago";
        else if (minutes < 600)
            return "5 hour ago";
        else if (minutes < 720)
            return "6 hours ago";
        else if (minutes < 840)
            return "7 hours ago";
        else if (minutes < 960)
            return "8 hours ago";
        else if (minutes < (24 * 60))
            return "Today";
        else if (minutes < (24 * 60 * 2))
            return "Yesterday";
        else if (minutes < (24 * 60 * 7)) {
            int deltaMinutes = (int) Math.floor(minutes / (60 * 24));
            return String.format("%s %s", deltaMinutes, "days ago");
        } else if (minutes < (24 * 60 * 14))
            return "Last week";
        else if (minutes < (24 * 60 * 31)) {
            int deltaMinutes = (int) Math.floor(minutes / (60 * 24 * 7));
            return String.format("%s %s", deltaMinutes, "weeks ago");
        } else if (minutes < (24 * 60 * 61))
            return "Last month";
        else if (minutes < (24 * 60 * 365)) {
            int deltaMinutes = (int) Math.floor(minutes / (60 * 24 * 30));
            return String.format("%s %s", deltaMinutes, "months ago");
        } else if (minutes < (24 * 60 * 731))
            return "Last year";
        else {
            int deltaMinutes = (int) Math.floor(minutes / (60 * 24 * 365));
            return String.format("%s %s", deltaMinutes, "years ago");
        }
    }


}
