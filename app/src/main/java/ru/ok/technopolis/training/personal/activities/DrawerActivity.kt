package ru.ok.technopolis.training.personal.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.mikepenz.iconics.typeface.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import ru.ok.technopolis.training.personal.R

abstract class DrawerActivity : AppbarActivity() {

    private var navMenu: Drawer.Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                .addDrawerItems(
                        PrimaryDrawerItem().withName(R.string.drawer_item_found).withIcon(FontAwesome.Icon.faw_search).withIdentifier(1),
                        PrimaryDrawerItem().withName(R.string.drawer_item_bookmarks).withIcon(FontAwesome.Icon.faw_bookmark).withIdentifier(2),
                        PrimaryDrawerItem().withName(R.string.drawer_item_favourites).withIcon(FontAwesome.Icon.faw_star).withIdentifier(3),
                        DividerDrawerItem(),
                        SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(4)
                )
                .build()
    }

    override fun onBackPressed() {
        if (navMenu?.isDrawerOpen == true) {
            navMenu?.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    override fun hasNavigationMenu() = true
}