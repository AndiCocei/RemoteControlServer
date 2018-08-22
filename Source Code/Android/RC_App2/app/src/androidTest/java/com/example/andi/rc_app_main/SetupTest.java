package com.example.andi.rc_app_main;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SetupTest {

    @Rule
    public ActivityTestRule<Setup> mActivityTestRule = new ActivityTestRule<>(Setup.class);

    @Before
    public void setUp() {
    }

    @Test
    public void testSetIP(){
        String mIP = "192.168.1.101";
        Espresso.onView(withId(R.id.eIP)).perform(typeText(mIP));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.bRC)).perform(click());
    }

/*
    @Test
    public void testShutdown() {
        testSetIP();
        Espresso.onView(withId(R.id.bShutdown)).perform(ViewActions.longClick());
    }

    @Test
    public void testLock() {
        testSetIP();
        Espresso.onView(withId(R.id.bLock)).perform(ViewActions.longClick());
    }

    @Test
    public void testSleep(){
        testSetIP();
        Espresso.onView(withId(R.id.bSleep)).perform(ViewActions.longClick());
    }

    @Test
    public void testRestart(){
        testSetIP();
        Espresso.onView(withId(R.id.bRestart)).perform(ViewActions.longClick());
    }



    @Test
    public void testVolUp(){
        testSetIP();
        Espresso.onView(withId(R.id.bVolUp)).perform(click());
    }

    @Test
    public void testVolDown(){
        testSetIP();
        Espresso.onView(withId(R.id.bVolDown)).perform(click());
    }

    @Test
    public void testSpace(){
        testSetIP();
        Espresso.onView(withId(R.id.bSpace)).perform(click());
    }

    @Test
    public void testEnter(){
        testSetIP();
        Espresso.onView(withId(R.id.bEnter)).perform(click());
    }

    @Test
    public void testArrowKeys(){
        testSetIP();
        Espresso.onView(withId(R.id.bUp)).perform(click());
        Espresso.onView(withId(R.id.bDown)).perform(click());
        Espresso.onView(withId(R.id.bLock)).perform(click());
        Espresso.onView(withId(R.id.bRight)).perform(click());
    }

    @Test
    public void testMouseButtons(){
        testSetIP();
        Espresso.onView(withId(R.id.bLeftClick)).perform(click());
        Espresso.onView(withId(R.id.bMiddleClick)).perform(click());
        Espresso.onView(withId(R.id.bRightClick)).perform(click());
    }
    */

    @After
    public void tearDown() {
    }
}
