package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.frgment_active_exercise.*
import ru.ok.technopolis.training.personal.R

class ActiveExerciseFragment : BaseFragment() {

    private var goBackView: ImageView? = null
    private var setStarView: ImageView? = null
    private var setBookmarkView: ImageView? = null
    private var parameterGoal1EditText: EditText? = null
    private var parameterGoal2EditText: EditText? = null
    private var parameterGoal3EditText: EditText? = null
    private var doneButton: Button? = null
    private var nextExerciseView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)
        goBackView = go_back
        setStarView = star_border
        setBookmarkView = bookmark_border
        parameterGoal1EditText = parameter1_goal
        parameterGoal2EditText = parameter2_goal
        parameterGoal3EditText = parameter3_goal
        doneButton = done_button
        nextExerciseView = next_exercise_name
        return rootView
    }

    override fun getFragmentLayoutId(): Int = R.layout.frgment_active_exercise;
}