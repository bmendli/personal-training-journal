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
        goBackView = rootView?.findViewById(R.id.go_back) as ImageView
        setStarView = rootView.findViewById(R.id.star_border) as ImageView
        setBookmarkView = rootView.findViewById(R.id.bookmark_border) as ImageView
        parameterGoal1EditText = rootView.findViewById(R.id.parameter1_goal) as EditText
        parameterGoal2EditText = rootView.findViewById(R.id.parameter2_goal) as EditText
        parameterGoal3EditText = rootView.findViewById(R.id.parameter3_goal) as EditText
        doneButton = rootView.findViewById(R.id.done_button) as Button
        nextExerciseView = rootView.findViewById(R.id.next_exercise_name) as TextView
        return rootView
    }

    override fun getFragmentLayoutId(): Int = R.layout.frgment_active_exercise;
}