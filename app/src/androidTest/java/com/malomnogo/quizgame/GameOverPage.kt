package com.malomnogo.quizgame

import android.graphics.Color
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers

class GameOverPage {

    fun checkVisible() {
        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.actionButtton),
                withText("game over"),
                ViewMatchers.isAssignableFrom(Button::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).check(ViewAssertions.matches(ButtonColorMatcher("#6AD9E8")))
    }

    fun checkQuestionVisible(question: String) {
        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.questionTextView),
                ViewMatchers.isAssignableFrom(TextView::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).check(ViewAssertions.matches(withText(question)))
    }

    fun checkAnswerCorrect(text: String) {
        Espresso.onView(
            CoreMatchers.allOf(
                withText(text),
                ViewMatchers.isAssignableFrom(Button::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).check(ViewAssertions.matches(ButtonColorMatcher(Color.parseColor("#80E38A"))))
    }

    fun checkChoicesNotAvailable(choices: List<String>) {
        choices.forEach { text ->
            Espresso.onView(
                CoreMatchers.allOf(
                    withText(text),
                    ViewMatchers.isAssignableFrom(Button::class.java),
                    ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                    ViewMatchers.withParent(withId(R.id.rootLayout))
                )
            ).check(ViewAssertions.matches(ButtonColorMatcher(Color.parseColor("#6E7292"))))
        }
    }

    fun clickChoice(text: String) {
        Espresso.onView(
            CoreMatchers.allOf(
                withText(text),
                ViewMatchers.isAssignableFrom(Button::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).perform(ViewActions.click())
    }

    fun clickGameOver() {
        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.actionButtton),
                withText("game over"),
                ViewMatchers.isAssignableFrom(Button::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).perform(ViewActions.click())
    }

    fun checkNotVisible() {
        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.actionButtton),
                ViewMatchers.isAssignableFrom(Button::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }

    fun checkAnswerIncorrect(text: String) {
        Espresso.onView(
            CoreMatchers.allOf(
                withText(text),
                ViewMatchers.isAssignableFrom(Button::class.java),
                ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java)),
                ViewMatchers.withParent(withId(R.id.rootLayout))
            )
        ).check(ViewAssertions.matches(ButtonColorMatcher(Color.parseColor("#E63B3B"))))
    }
}
