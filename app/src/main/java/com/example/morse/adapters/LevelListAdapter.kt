package com.example.morse.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.morse.activities.TeachActivity
import com.example.morse.R

class LevelListAdapter(context: Context) : BaseAdapter() {
    private val mContext: Context = context
    private val wordlistStart = "wordlistStart"
    private val wordlistEnd = "wordlistEnd"

    override fun getCount(): Int {
        return 7
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getItem(p0: Int): Any {
        return "Level ${p0 + 1}"
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowMain = LayoutInflater.from(mContext).inflate(R.layout.row_main, p2, false)
        rowMain.setOnClickListener {
            val intent = Intent(mContext, TeachActivity::class.java)
            intent.putExtra(wordlistStart, p0*6)
            intent.putExtra(wordlistEnd, p0*6+5)
            ContextCompat.startActivity(mContext, intent, null)
        }

        val positionTextView = rowMain.findViewById<TextView>(R.id.textView)
        positionTextView.text = "Section ${p0 + 1}"
        return rowMain
    }
}
