package com.example.motionevent

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_motion_event.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_event)

//        val myLayout =
//            findViewById<ConstraintLayout>(R.id.activity_motion_event)
        val textView1 = findViewById(R.id.textView1) as TextView
        val textView2 = findViewById(R.id.textView2) as TextView

        activity_motion_event.setOnTouchListener { v: View, m: MotionEvent ->
            v.performClick()

            val pointercount = m.pointerCount
            for (i in 0 until pointercount) {
                val x = m.getX(i)
                val y = m.getY(i)
                val id = m.getPointerId(i)
                val action = m.actionMasked
                val actionIndex = m.actionIndex
                val actionString: String

                actionString = when (action) {
                    MotionEvent.ACTION_DOWN -> "DOWN"
                    MotionEvent.ACTION_UP -> "UP"
                    MotionEvent.ACTION_POINTER_UP -> "PNTR UP"
                    MotionEvent.ACTION_POINTER_DOWN -> "PNTR DOWN"
                    MotionEvent.ACTION_MOVE -> "PNTR UP"
                    else -> ""
                }
                val touchStatus = "Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y"


                if (id == 0) {
                    textView1.text = touchStatus
                } else
                    textView2.text = touchStatus
            }
            true
        }
    }
}
