
package com.forgemx.requinto

import android.os.Bundle
import android.view.Gravity
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    private val openNotes = listOf("C", "D", "G", "C", "F")
    private val notes = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        val grid = GridLayout(this).apply {
            rowCount = 5
            columnCount = 12
        }
        for (stringIndex in openNotes.indices) {
            for (fret in 0 until 12) {
                val noteIndex = (notes.indexOf(openNotes[stringIndex]) + fret) % notes.size
                val noteName = notes[noteIndex]
                val tv = TextView(this).apply {
                    text = ""
                    setBackgroundColor(0xFF444444.toInt())
                    setTextColor(0xFFFFFFFF.toInt())
                    textSize = 14f
                    gravity = Gravity.CENTER
                    setOnClickListener {
                        if (text == "") {
                            text = noteName
                            setBackgroundColor(0xFFFF5722.toInt())
                        } else {
                            text = ""
                            setBackgroundColor(0xFF444444.toInt())
                        }
                    }
                    layoutParams = GridLayout.LayoutParams().apply {
                        width = 100
                        height = 100
                        setMargins(2, 2, 2, 2)
                    }
                }
                grid.addView(tv)
            }
        }
        setContentView(grid)
    }
}
