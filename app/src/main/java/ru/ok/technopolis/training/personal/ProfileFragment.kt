package ru.ok.technopolis.training.personal

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.item_profile.view.*
import kotlinx.android.synthetic.main.item_train_ex_switcher.*
import kotlinx.android.synthetic.main.item_train_ex_switcher.view.*
import ru.ok.technopolis.training.personal.fragments.BaseFragment
import ru.ok.technopolis.training.personal.items.ProfileItem


class ProfileFragment : BaseFragment() {
    private var profileNameAndIcon: View? = null
    private var trainSwitcher: View? = null
    private var subscribersNumber: TextView? = null
    private var subscriptionsNumber: TextView? = null
    private var sharedTrainingsNumber: TextView? = null
    private var sharedExercisesNumber: TextView? = null
    private var filterButtons: View? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileNameAndIcon = view.profile
        trainSwitcher = view.switcher
        subscribersNumber = view.subscribers_number
        subscriptionsNumber = view.subscriptions_number
        sharedTrainingsNumber = view.shared_trainings_number
        sharedExercisesNumber = view.shared_ex_number
        filterButtons = view.tr_ex_filter_buttons

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
        var flag = true
        val clL = View.OnClickListener {view ->
            flag = !flag
            print(flag)
            if (flag) {
                if (view.id == R.id.train_switch_button) {
                    view.train_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    tr_sw_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
                    trainSwitcher!!.ex_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    ex_switch_line.setBackgroundResource(R.color.gray_4)
                }

            } else {
                if (view.id == R.id.train_switch_button) {
                    view.train_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    tr_sw_line.setBackgroundResource(R.color.gray_4)
                    trainSwitcher!!.ex_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    ex_switch_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
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
                }

            } else {
                if (view.id == R.id.ex_switch_button) {
                    view.ex_switch_button.setTextColor(Color.rgb(119, 119, 119))
                    ex_switch_line.setBackgroundResource(R.color.gray_4)
                    trainSwitcher!!.train_switch_button.setTextColor(Color.rgb(24, 120, 103))
                    train_switch_line.setBackgroundResource(R.color.design_default_color_secondary_variant)
                }
            }
        }
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
            privateFlag =false
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
            } else {
                view.setBackgroundResource(R.drawable.border_button)
                view.shared_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.private_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.private_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button_selected)
                filterButtons!!.all_filter_button.setTextColor(Color.rgb(24, 120, 103))
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
                sharedFlag = false
            } else {
                view.setBackgroundResource(R.drawable.border_button)
                view.private_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.shared_filter_button.setBackgroundResource(R.drawable.border_button)
                filterButtons!!.shared_filter_button.setTextColor(Color.rgb(119, 119, 119))
                filterButtons!!.all_filter_button.setBackgroundResource(R.drawable.border_button_selected)
                filterButtons!!.all_filter_button.setTextColor(Color.rgb(24, 120, 103))
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
    override fun getFragmentLayoutId() : Int = R.layout.fragment_profile

}