package ru.ok.technopolis.training.personal

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.item_profile.view.*
import kotlinx.android.synthetic.main.item_train_ex_switcher.*
import kotlinx.android.synthetic.main.item_train_ex_switcher.view.*
import ru.ok.technopolis.training.personal.fragments.BaseFragment
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.items.ProfileItem
import ru.ok.technopolis.training.personal.items.ShortExerciseItem
import ru.ok.technopolis.training.personal.items.ShortWorkoutItem
import ru.ok.technopolis.training.personal.utils.recycler.adapters.ShortExerciseListAdapter
import ru.ok.technopolis.training.personal.utils.recycler.adapters.ShortWorkoutListAdapter
import ru.ok.technopolis.training.personal.viewholders.ShortExerciseViewHolder
import ru.ok.technopolis.training.personal.viewholders.ShortWorkoutViewHolder
import java.sql.Time


class ProfileFragment : BaseFragment() {
    private var profileNameAndIcon: View? = null
    private var trainSwitcher: View? = null
    private var subscribersNumber: TextView? = null
    private var subscriptionsNumber: TextView? = null
    private var sharedTrainingsNumber: TextView? = null
    private var sharedExercisesNumber: TextView? = null
    private var filterButtons: View? = null

    private var recyclerView: RecyclerView? = null
    private var workoutsMutableList = mutableListOf<ShortWorkoutItem>()
    private var exerciseMutableList = mutableListOf<ShortExerciseItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileNameAndIcon = view.profile
        trainSwitcher = view.switcher
        subscribersNumber = view.subscribers_number
        subscriptionsNumber = view.subscriptions_number
        sharedTrainingsNumber = view.shared_trainings_number
        sharedExercisesNumber = view.shared_ex_number
        filterButtons = view.tr_ex_filter_buttons
        recyclerView = view.profile_tr_ex_list


        val tr_sw_line = view.train_switch_line
        val ex_switch_line = view.ex_switch_line

        //TODO: change to real
        val list = listOf<String>("a", "b", "c")
        val prof = ProfileItem("1234", "lfldf", list, true, null, 5, 10, 23,6)

        profileNameAndIcon!!.profile_name.text = prof.name
        profileNameAndIcon!!.complaint.visibility = View.GONE
        //TODO:rewrite to make good list
        profileNameAndIcon!!.profile_description.text = prof.sports.toString()
        subscribersNumber!!.text= prof.subscribersNumber.toString()
        subscriptionsNumber!!.text = prof.subscriptionsNumber.toString()
        sharedTrainingsNumber!!.text = prof.sharedTrainingsNumber.toString()
        sharedExercisesNumber!!.text = prof.sharedExercisesNumber.toString()
        exDummyToRecView()
        var flag = true

        var sharedFlag = false
        var privateFlag = false
        var allFlag = true
        val all_cl = View.OnClickListener { view ->
            filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button_selected)
            filterButtons!!.all_filter_button.setTextColor(Color.rgb(24, 120, 103))
                filterButtons!!.shared_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.shared_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.private_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.private_filter_button.setTextColor(Color.rgb(119, 119, 119))
            sharedFlag = false
            privateFlag = false
            loadItems(flag, privateFlag, sharedFlag)
        }

        val shared_cl = View.OnClickListener { view ->
            sharedFlag = !sharedFlag
            if (sharedFlag) {
                view.setBackgroundResource(R.drawable.border_button_selected)
                view.shared_filter_button.setTextColor(Color.rgb(24, 120, 103))
                filterButtons!!.private_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.private_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.all_filter_button.setTextColor(Color.rgb(119, 119, 119))
                privateFlag = false
                loadItems(flag, privateFlag, sharedFlag)
            } else {
                view.setBackgroundResource(R.drawable.border_button)
                view.shared_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.private_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.private_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button_selected)
                filterButtons!!.all_filter_button.setTextColor(Color.rgb(24, 120, 103))
                loadItems(flag, privateFlag, sharedFlag)
            }
        }

        val private_cl = View.OnClickListener { view ->
            privateFlag = !privateFlag
            if (privateFlag) {
                view.setBackgroundResource(R.drawable.border_button_selected)
                view.private_filter_button.setTextColor(Color.rgb(24, 120, 103))
                filterButtons!!.shared_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.shared_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.all_filter_button.setTextColor(Color.rgb(119, 119, 119))
                loadItems(flag, privateFlag, sharedFlag)
                sharedFlag = false
            } else {
                view.setBackgroundResource(R.drawable.border_button)
                view.private_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.shared_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.shared_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button_selected)
                filterButtons!!.all_filter_button.setTextColor(Color.rgb(24, 120, 103))
                loadItems(flag, privateFlag, sharedFlag)
            }
        }

        val clL = View.OnClickListener {view ->
            flag = !flag
            print(flag)
            if (flag) {
                if (view.id == R.id.train_switch_button) {
                    view.train_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    tr_sw_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
                    trainSwitcher!!.ex_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    ex_switch_line.setBackgroundResource(R.color.gray_4)
                    loadItems(flag, privateFlag, sharedFlag)
                }

            } else {
                if (view.id == R.id.train_switch_button) {
                    view.train_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    tr_sw_line.setBackgroundResource(R.color.gray_4)
                    trainSwitcher!!.ex_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    ex_switch_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
                    loadItems(flag, privateFlag, sharedFlag)
                }
            }
        }

    val ex_clL = View.OnClickListener {view ->
        flag = !flag
            if (!flag) {
                if (view.id == R.id.ex_switch_button) {
                    view.ex_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    ex_switch_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
                    trainSwitcher!!.train_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    train_switch_line.setBackgroundResource(R.color.gray_4)
                    loadItems(flag, privateFlag, sharedFlag)
                }

            } else {
                if (view.id == R.id.ex_switch_button) {
                    view.ex_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    ex_switch_line.setBackgroundResource(R.color.gray_4)
                    trainSwitcher!!.train_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    train_switch_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
                    loadItems(flag, privateFlag, sharedFlag)
                }
            }
        }


        filterButtons!!.all_filter_button.setOnClickListener(all_cl)
        filterButtons!!.shared_filter_button.setOnClickListener(shared_cl)
        filterButtons!!.private_filter_button.setOnClickListener(private_cl)
        trainSwitcher!!.train_switch_button.setOnClickListener(clL)
        trainSwitcher!!.ex_switch_button.setOnClickListener(ex_clL)
//        trainSwitcher!!.setOnClickListener(clL)

//        switcher.train_switch.setOnClickListener { print("wow_train") }
//        switcher.ex_switch.setOnClickListener {  print("wow ex")}

    }

    private fun loadItems(flag: Boolean, privateFlag: Boolean, sharedFlag: Boolean) {
       clearRecView(flag)
        if (flag) {
            loadWorkoutItems(privateFlag, sharedFlag)
        } else {
            loadExItems(privateFlag, sharedFlag)
        }
    }

    private fun loadWorkoutItems(privateFlag: Boolean, sharedFlag: Boolean) {
        when {
            privateFlag -> {

                exDummyPrivate()
            }
            sharedFlag -> {
                exDummyShared()
            }
            else -> {
                exDummyToRecView()
            }
        }
    }
    private fun loadExItems(privateFlag: Boolean, sharedFlag: Boolean) {
        when {
            privateFlag -> {
                exerciseDummyPrivate()
            }
            sharedFlag -> {
               exerciseDummyShared()
            }
            else -> {
               exerciseDummyAll()
            }
        }
    }
    private fun clearRecView(flag: Boolean) {
        if (flag) {
            val listSize = workoutsMutableList.size
            workoutsMutableList.clear()
            recyclerView?.adapter?.notifyItemRangeRemoved(0, listSize)
        } else {
            val listSize = exerciseMutableList.size
            exerciseMutableList.clear()
            recyclerView?.adapter?.notifyItemRangeRemoved(0, listSize)
        }
    }

    private fun exDummyToRecView() {
        for (i in 1..3) pushWorkout(i, 123, 3.7)
        for (i in 4..5) pushWorkout(i, 0, 0.0)
        val workoutsList = ItemsList(workoutsMutableList)
        val workoutsAdapter = ShortWorkoutListAdapter(
                holderType = ShortWorkoutViewHolder::class,
                layoutId = R.layout.item_short_workout,
                dataSource = workoutsList,
                onClick = {workoutItem -> println("workout ${workoutItem.id} clicked")},
                onStart = { workoutItem ->
                    println("workout ${workoutItem.id} started")
                }
        )
        recyclerView?.adapter = workoutsAdapter
        val workoutsLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = workoutsLayoutManager
    }

    private fun exDummyShared() {
        for (i in 1..3) pushWorkout(i, 123, 3.7)
        val workoutsList = ItemsList(workoutsMutableList)
        val workoutsAdapter = ShortWorkoutListAdapter(
                holderType = ShortWorkoutViewHolder::class,
                layoutId = R.layout.item_short_workout,
                dataSource = workoutsList,
                onClick = {workoutItem -> println("workout ${workoutItem.id} clicked")},
                onStart = { workoutItem ->
                    println("workout ${workoutItem.id} started")
                }
        )
        recyclerView?.adapter = workoutsAdapter
        val workoutsLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = workoutsLayoutManager
    }

    private fun exDummyPrivate() {
        for (i in 1..2) pushWorkout(i, 0, 0.0)
        val workoutsList = ItemsList(workoutsMutableList)
        val workoutsAdapter = ShortWorkoutListAdapter(
                holderType = ShortWorkoutViewHolder::class,
                layoutId = R.layout.item_short_workout,
                dataSource = workoutsList,
                onClick = {workoutItem -> println("workout ${workoutItem.id} clicked")},
                onStart = { workoutItem ->
                    println("workout ${workoutItem.id} started")
                }
        )
        recyclerView?.adapter = workoutsAdapter
        val workoutsLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = workoutsLayoutManager
    }

    private fun exerciseDummyPrivate() {
        for (i in 1..2) pusExercise(i, 0, 0.0)
        val exList = ItemsList(exerciseMutableList)
        val exAdapter = ShortExerciseListAdapter(
                holderType = ShortExerciseViewHolder::class,
                layoutId = R.layout.item_short_exercice,
                dataSource = exList,
                onClick = {exItem -> println("workout ${exItem.id} clicked")},
                onStart = { exItem ->
                    println("workout ${exItem.id} started")
                }
        )
        recyclerView?.adapter = exAdapter
        val exLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = exLayoutManager
    }

    private fun exerciseDummyShared() {
        for (i in 1..2) pusExercise(i, 123, 3.0)
        val exList = ItemsList(exerciseMutableList)
        val exAdapter = ShortExerciseListAdapter(
                holderType = ShortExerciseViewHolder::class,
                layoutId = R.layout.item_short_exercice,
                dataSource = exList,
                onClick = {exItem -> println("workout ${exItem.id} clicked")},
                onStart = { exItem ->
                    println("workout ${exItem.id} started")
                }
        )
        recyclerView?.adapter = exAdapter
        val exLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = exLayoutManager
    }
    private fun exerciseDummyAll() {
        for (i in 1..2) pusExercise(i, 0, 0.0)
        for (i in 3..4) pusExercise(i, 123, 3.0)
        val exList = ItemsList(exerciseMutableList)
        val exAdapter = ShortExerciseListAdapter(
                holderType = ShortExerciseViewHolder::class,
                layoutId = R.layout.item_short_exercice,
                dataSource = exList,
                onClick = { exItem -> println("workout ${exItem.id} clicked")},
                onStart = { exItem ->
                    println("workout ${exItem.id} started")
                }
        )
        recyclerView?.adapter = exAdapter
        val exLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = exLayoutManager
    }

    private fun pushWorkout(id: Int, sharedNumber: Int, rank: Double) {
        workoutsMutableList.add(
                ShortWorkoutItem(id.toString(), Time(System.currentTimeMillis()), "MYвшпвшпвкпиквпшкивпквпвпквпивчмпч MY", "kardio", "ofp", "40 min", true, sharedNumber, rank, false)
        )
    }

    private fun pusExercise(id: Int, sharedNumber: Int, rank: Double) {
        exerciseMutableList.add(
                ShortExerciseItem(id.toString(), Time(System.currentTimeMillis()), "dljgd hdrh rhre", "kardio", "ofp", true, sharedNumber, rank)
        )
    }

    override fun getFragmentLayoutId() : Int = R.layout.fragment_profile

}