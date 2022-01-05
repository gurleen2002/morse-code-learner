package com.example.morse.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.morse.R

class TeachActivity : AppCompatActivity() {
    private val wordlistStart = "wordlistStart"
    private val wordlistEnd = "wordlistEnd"
    private var position = 0
    private var startPos = 0
    private var endPos = 0
    private val wordList = arrayOf("A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N","O", "P", "Q", "R", "S", "T", "U","V", "W", "X", "Y", "Z","0","1","2","3","4","5", "6", "7", "8", "9","FIRE","RUN","HELP","GO","YES","NO")
    private val alphaMap = mapOf(
        'A' to "*-",
        'B' to "-***",
        'C' to "-*-*",
        'D' to "-**",
        'E' to "*",
        'F' to "**-*",
        'G' to "--*",
        'H' to "****",
        'I' to "**",
        'J' to "*---",
        'K' to "-*-",
        'L' to "*-**",
        'M' to "--",
        'N' to "-*",
        'O' to "---",
        'P' to "*--*",
        'Q' to "--*-",
        'R' to "*-*",
        'S' to "***",
        'T' to "-",
        'U' to "**-",
        'V' to "***-",
        'W' to "*--",
        'X' to "-**-",
        'Y' to "-*--",
        'Z' to "--**",
        '1' to "*----",
        '2' to "**---",
        '3' to "***--",
        '4' to "****-",
        '5' to "*****",
        '6' to "-****",
        '7' to "--***",
        '8' to "---**",
        '9' to "----*",
        '0' to "-----",
        ' ' to " / "

    )

    private fun displayWord(word: String) {
        val textDisplay = findViewById<TextView>(R.id.mText)
        textDisplay.text = word
        val codeDisplay = findViewById<TextView>(R.id.mCode)
        var alpha =""
        for (i in word) {
            alpha += "    " + alphaMap[i]
            codeDisplay.text = alpha.trim()
        }

    }

    private fun displayWord(pos: Int) {
        position = if (0 <= pos && pos < wordList.size) {
            pos
        } else {
            startPos
        }

        displayWord(wordList[position])
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teach)
        startPos = intent.getIntExtra(wordlistStart, 0)
        endPos = intent.getIntExtra(wordlistEnd, wordList.size - 1)
        if (startPos < 0 || startPos >= wordList.size) {
            startPos = 0
        }
        if (endPos < startPos || endPos >= wordList.size) {
            endPos = wordList.size - 1
        }
        displayWord(startPos)
        findViewById<Button>(R.id.prevButton).setOnClickListener {
            position -= 1
            if (position < startPos) {
                position = endPos
            }
            displayWord(position)
        }
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            position += 1
            if (position > endPos) {
                position = startPos
            }
            displayWord(position)
        }
    }
}

