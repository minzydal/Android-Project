package com.example.activitypractice;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 13  * Instrumented test, which will execute on an Android device.
 14  *
 15  * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 16  */
         @RunWith(AndroidJUnit4.class)
 public class ExampleInstrumentedTest {
     @Test
     public void useAppContext() {
                 // Context of the app under test.
                 Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();


                 assertEquals("kr.ac.koreatech.cse.activitypractice", appContext.getPackageName());
             }
 }

