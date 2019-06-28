package com.backbase.mobiletest.ui.citymap.view;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.backbase.mobiletest.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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

    @Test
    public void shouldLoadCityList_When_OpenApp() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.frameLayout)).check(getViewAssertion());
    }

    private ViewAssertion getViewAssertion() {
        return matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE));
    }
}