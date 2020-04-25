package com.example.lab1

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.lab1.Entities.History
import com.example.lab1.Entities.Task
import kotlinx.android.synthetic.main.fragment_chooser.*

class ChooserFragment : Fragment() {

    private lateinit var data: Task

    private lateinit var _resultButton: Button
    private lateinit var _radioDiff: RadioGroup
    private lateinit var _radioType: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = Task()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chooser, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findViews(view)

        resButton.setOnClickListener{
            val flag: Boolean = (_radioDiff.checkedRadioButtonId != -1) and (_radioType.checkedRadioButtonId != -1)
            if(flag){
                setValues(view)
                createResult(view.context as MainActivity)
            }
            else{
                Toast.makeText(
                    view.context, "Not all or none selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun findViews(view: View){
        _radioDiff = view.findViewById(R.id.radioDiff)
        _radioType = view.findViewById(R.id.radioType)
        _resultButton = view.findViewById(R.id.resButton)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setValues(view: View){
        val task = Task(
            view.findViewById<RadioButton>(_radioDiff.checkedRadioButtonId).text as String,
            view.findViewById<RadioButton>(_radioType.checkedRadioButtonId).text as String,
            resources,
            view.context as MainActivity
        )
        data.description = task.description
        data.difficulty = view.findViewById<RadioButton>(_radioDiff.checkedRadioButtonId).text as String
        data.type = view.findViewById<RadioButton>(_radioType.checkedRadioButtonId).text as String
        data.descriptionId = task.descriptionId

        addHistory(task, view.context as MainActivity)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addHistory(task : Task, context : MainActivity){
        val db = DBOpenHelperHistory(context, null)
        val history = History(task.descriptionId)
        db.addHistory(history)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createResult(context: MainActivity){
        context.replaceFragment(InfoFragment(data))
    }
}
