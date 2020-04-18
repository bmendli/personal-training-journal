package ru.ok.technopolis.training.personal.activities

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.annotation.CallSuper
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.mikepenz.iconics.typeface.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.lifecycle.Router
import ru.ok.technopolis.training.personal.utils.logger.Logger

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val SEARCH_ITEM_ID = 1
        const val BOOKMARKS_ITEM_ID = 2
        const val FAVOURITE_ITEM_ID = 3
        const val SETTINGS_ITEM_ID = 4
    }

    var router: Router? = null
        private set

    protected var mainContainer: FrameLayout? = null
    protected var coordinator: CoordinatorLayout? = null
    protected var toolbar: Toolbar? = null
    protected var appbarLayout: AppBarLayout? = null
    protected var navMenu: Drawer.Result? = null

    private val menuItemsArray = arrayOf(
            PrimaryDrawerItem().withName(R.string.drawer_item_search).withIcon(R.drawable.ic_search).withIdentifier(SEARCH_ITEM_ID),
            PrimaryDrawerItem().withName(R.string.drawer_item_bookmarks).withIcon(R.drawable.ic_bookmarks).withIdentifier(BOOKMARKS_ITEM_ID),
            PrimaryDrawerItem().withName(R.string.drawer_item_favourites).withIcon(FontAwesome.Icon.faw_star_half_empty).withIdentifier(FAVOURITE_ITEM_ID),
            DividerDrawerItem(),
            SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(R.drawable.ic_settings).withIdentifier(SETTINGS_ITEM_ID)
    )

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d(this, "onCreate")

        router = Router(this)

        setContentView(getActivityLayoutId())
        setupActivity()
        setupToolbar()
        initHomeButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (navMenu?.isDrawerOpen == true) {
            navMenu?.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected open fun setupActivity() {
        coordinator = coordinator_layout
        toolbar = base_toolbar
        appbarLayout = appbar_layout
    }

    private fun setupToolbar() {
        if (toolbar != null && appbarLayout != null) {
            if (isToolbarEnabled()) {
                toolbar?.title = getToolbarTitle()
                setSupportActionBar(toolbar)
            } else {
                appbarLayout?.visibility = View.GONE
            }
        }
    }
  
    private fun initHomeButton() {
        this.supportActionBar?.let {
            it.displayOptions = ActionBar.DISPLAY_HOME_AS_UP
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(true)
            it.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))
            if (hasNavigationMenu()) {
                navMenu = Drawer()
                        .withActivity(this)
                        .withToolbar(toolbar)
                        .withActionBarDrawerToggle(true)
                        .withHeader(R.layout.drawer_header_nav_menu)
                        .withOnDrawerListener(object : Drawer.OnDrawerListener {
                            override fun onDrawerOpened(drawerView: View?) {
                                val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                            }

                            override fun onDrawerClosed(drawerView: View?) {
                                //do nothing
                            }
                        })
                        .addDrawerItems(*menuItemsArray)
                        .build()
                navMenu?.setOnDrawerItemClickListener { _, _, _, _, drawerItem ->
                    when(drawerItem.identifier) {
                        SEARCH_ITEM_ID -> {}
                        BOOKMARKS_ITEM_ID -> {}
                        FAVOURITE_ITEM_ID -> {}
                        SETTINGS_ITEM_ID -> router?.showSettingsPage()
                    }
                }
            } else {
                it.setHomeAsUpIndicator(R.drawable.ic_home_button)
            }
        }
    }

    open fun hasNavigationMenu(): Boolean = true

    protected open fun getToolbarTitle(): String = getString(R.string.app_name)

    protected open fun isToolbarEnabled(): Boolean = true

    protected open fun getActivityLayoutId(): Int = R.layout.activity_base
}