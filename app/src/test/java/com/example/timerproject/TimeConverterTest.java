package com.example.timerproject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test if data is converted correctly
 */
public class TimeConverterTest {
    @Test
    public void secondsToText() {
        String expected = "01:00";
        TimeConverter tc = new TimeConverter(60);

        Assert.assertEquals(expected, tc.toString());
    }
}