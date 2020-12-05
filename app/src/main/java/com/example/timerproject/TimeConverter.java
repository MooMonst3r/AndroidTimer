package com.example.timerproject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {

    private long seconds;

    public TimeConverter(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return convert();
    }

    private String convert() {
        Date date = new Date(this.seconds * 1000);
        return new SimpleDateFormat("mm:ss").format(date);
    }
}
