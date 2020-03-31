package com.example.lab1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_chooser.*
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment(d: Task) : Fragment() {

    private var data: Task = d

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValues(view)
    }

    private fun setValues(view: View){
        view.findViewById<TextView>(R.id.taskDiff).text = data.difficulty
        view.findViewById<TextView>(R.id.taskType).text = data.type
        view.findViewById<TextView>(R.id.taskTxt).text = data.description
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

}
