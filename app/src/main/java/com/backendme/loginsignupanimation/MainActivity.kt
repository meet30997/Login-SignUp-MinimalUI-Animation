package com.backendme.loginsignupanimation

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var isvisible = false
    var constraint: ConstraintLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(1024, 1024)
        setContentView(R.layout.activity_main)
        constraint = findViewById(R.id.con1)
        val backarrow = findViewById<TextView>(R.id.textView5)
        val imageback = findViewById<Button>(R.id.image)


        backarrow.setOnClickListener {
            if (isvisible)
                hideit()
            else
                showit()
        }


        imageback.setOnClickListener {
            if (isvisible)
                hideit()
            else
                showit()
        }
    }

    private fun showit() {
        isvisible = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main2)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        transition.duration = 1000

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }

    private fun hideit() {
        isvisible = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        transition.duration = 1000

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (isvisible)
            hideit()
        else
            showit()
    }
}
