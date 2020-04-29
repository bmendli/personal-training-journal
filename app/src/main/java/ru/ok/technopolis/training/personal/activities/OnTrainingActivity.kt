package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.frgment_active_exercise.*
import kotlinx.android.synthetic.main.view_appbar.*
import ru.ok.technopolis.training.personal.R

class OnTrainingActivity : BaseFragmentActivity() {
    override fun getToolbarView(): Toolbar = base_toolbar

    private var goBackView: ImageView? = null
    private var setStarView: ImageView? = null
    private var setBookmarkView: ImageView? = null
    private var parameterGoal1EditText: EditText? = null
    private var parameterGoal2EditText: EditText? = null
    private var parameterGoal3EditText: EditText? = null
    private var doneButton: Button? = null
    private var nextExerciseView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goBackView = go_back
        setStarView = star_border
        setBookmarkView = bookmark_border
        parameterGoal1EditText = parameter1_goal
        parameterGoal2EditText = parameter2_goal
        parameterGoal3EditText = parameter3_goal
        doneButton = done_button
        nextExerciseView = next_exercise_name
        doneButton?.setOnClickListener {
            router?.showActiveExercisePage()
            finish()
        }

    }

    override fun getActivityLayoutId(): Int = R.layout.frgment_active_exercise
}