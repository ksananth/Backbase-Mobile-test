package com.backbase.mobiletest.ui.citymap.view;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CityListActivityTest {
    @Rule
    public ActivityTestRule<CityListActivity> rule = new ActivityTestRule<>(CityListActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.backbase.mobiletest", appContext.getPackageName());
    }
}