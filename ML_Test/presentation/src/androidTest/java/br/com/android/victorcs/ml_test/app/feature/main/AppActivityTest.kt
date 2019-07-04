package br.com.android.victorcs.ml_test.app.feature.main


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import br.com.android.victorcs.ml_test.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AppActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainScreenActivity::class.java)

    @Test
    fun appActivityTest() {
        val editText = onView(
            allOf(
                withId(R.id.search_src_text), withText("Localizar produto"),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText.check(matches(withText("Localizar produto")))

        val editText2 = onView(
            allOf(
                withId(R.id.search_src_text), withText("Localizar produto"),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("Localizar produto")))

        val searchAutoComplete = onView(
            allOf(
                withId(R.id.search_src_text),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        searchAutoComplete.perform(click())

        val searchAutoComplete2 = onView(
            allOf(
                withId(R.id.search_src_text),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        searchAutoComplete2.perform(replaceText("ipod"), closeSoftKeyboard())

        val editText3 = onView(
            allOf(
                withId(R.id.search_src_text), withText("ipod"),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText3.check(matches(withText("ipod")))

        val recyclerView = onView(
            allOf(
                withId(R.id.rvItems),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frameLayout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))

        val recyclerView2 = onView(
            allOf(
                withId(R.id.rvItems),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frameLayout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        recyclerView2.check(matches(isDisplayed()))

        val cardView = onView(
            allOf(
                withId(R.id.cvContainer),
                childAtPosition(
                    allOf(
                        withId(R.id.rvItems),
                        childAtPosition(
                            withClassName(`is`("android.widget.FrameLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val cardView2 = onView(
            allOf(
                withId(R.id.cvContainer),
                childAtPosition(
                    allOf(
                        withId(R.id.rvItems),
                        childAtPosition(
                            withClassName(`is`("android.widget.FrameLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView2.perform(click())

        val viewGroup = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.itemDetailContainer),
                        childAtPosition(
                            withId(R.id.rootLayout),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.tvItemPrice), withText("Preço: R$ 145,00"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Preço: R$ 145,00")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
