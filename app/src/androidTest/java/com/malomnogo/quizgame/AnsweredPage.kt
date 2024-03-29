package com.malomnogo.quizgame

import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not

class AnsweredPage(private val question: String) {

    fun checkVisible() {
        onView(
            allOf(
                withId(R.id.actionButton),
                withText("next"),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).check(matches(ButtonColorMatcher("#6AD9E8")))
    }

    fun checkQuestionVisible() {
        onView(
            allOf(
                withId(R.id.questionTextView),
                isAssignableFrom(TextView::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).check(matches(withText(question)))
    }

    fun checkAnswerCorrect(text: String) {
        onView(
            allOf(
                withText(text),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).check(matches(ButtonColorMatcher(Color.parseColor("#80E38A"))))
    }

    fun checkChoicesNotAvailable(choices: List<String>) {
        choices.forEach { text ->
            onView(
                allOf(
                    withText(text),
                    isAssignableFrom(AppCompatButton::class.java),
                    withParent(isAssignableFrom(LinearLayout::class.java)),
                    withParent(withId(R.id.rootLayout))
                )
            ).check(matches(ButtonColorMatcher(Color.parseColor("#6E7292"))))
        }
    }

    fun clickChoice(text: String) {
        onView(
            allOf(
                withText(text),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).perform(click())
    }

    fun clickNext() {
        onView(
            allOf(
                withId(R.id.actionButton),
                withText("next"),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).perform(click())
    }

    fun checkNotVisible() {
        onView(
            allOf(
                withId(R.id.actionButton),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).check(matches(not(isDisplayed())))
    }

    fun checkAnswerIncorrect(text: String) {
        onView(
            allOf(
                withText(text),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).check(matches(ButtonColorMatcher(Color.parseColor("#E63B3B"))))
    }
}