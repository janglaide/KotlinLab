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

    private lateinit var descriptionView: TextView
    private lateinit var typeView: TextView
    private lateinit var difficultyView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getString("difficulty")
            it.getString("type")
            it.getString("description")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        difficultyView = view.findViewById(R.id.taskDiff)
        typeView = view.findViewById(R.id.taskType)
        descriptionView = view.findViewById(R.id.taskTxt)

        difficultyView.text = data.difficulty
        typeView.text = data.type
        descriptionView.text = data.description
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

}
