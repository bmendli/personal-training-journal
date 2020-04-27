package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import com.mikepenz.materialdrawer.holder.ImageHolder
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IProfile
import com.mikepenz.materialdrawer.util.addItems
import com.mikepenz.materialdrawer.widget.AccountHeaderView
import kotlinx.android.synthetic.main.activity_base_fragment.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.model.UserInfo
import ru.ok.technopolis.training.personal.navmenu.NavigationMenuListener
import ru.ok.technopolis.training.personal.repository.CurrentUserRepository

abstract class DrawerActivity : BaseActivity() {

    companion object {
        const val SEARCH_ITEM_ID = 1.toLong()
        const val BOOKMARKS_ITEM_ID = 2.toLong()
        const val FAVOURITE_ITEM_ID = 3.toLong()
        const val SETTINGS_ITEM_ID = 4.toLong()
    }

    private val listeners: MutableList<NavigationMenuListener> = ArrayList()
    private val profile: IProfile = ProfileDrawerItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupItems()
        slider.apply {
            onDrawerItemClickListener = { _, item, _ ->
                when (item.identifier) {
                    SEARCH_ITEM_ID -> {
                    }
                    BOOKMARKS_ITEM_ID -> {
                    }
                    FAVOURITE_ITEM_ID -> {
                    }
                    SETTINGS_ITEM_ID -> router?.showSettingsPage()
                }
                root_drawer.closeDrawer(this)
                true
            }
        }
        slider.selectExtension
        attachCurrentUserToSlider()
    }

    private fun setupItems() {
        val searchItem = PrimaryDrawerItem()
        searchItem.name = StringHolder(R.string.drawer_item_search)
        searchItem.icon = ImageHolder(R.drawable.ic_search)
        searchItem.identifier = SEARCH_ITEM_ID
        searchItem.isSelectable = false

        val bookmarksItem = PrimaryDrawerItem()
        bookmarksItem.name = StringHolder(R.string.drawer_item_bookmarks)
        bookmarksItem.icon = ImageHolder(R.drawable.ic_bookmarks)
        bookmarksItem.identifier = BOOKMARKS_ITEM_ID
        bookmarksItem.isSelectable = false

        val favouritesItem = PrimaryDrawerItem()
        favouritesItem.name = StringHolder(R.string.drawer_item_favourites)
        // todo set icon later
//        favouritesItem.icon = ImageHolder()
        favouritesItem.identifier = FAVOURITE_ITEM_ID
        favouritesItem.isSelectable = false

        val settingsItem = PrimaryDrawerItem()
        settingsItem.name = StringHolder(R.string.drawer_item_settings)
        settingsItem.icon = ImageHolder(R.drawable.ic_settings)
        settingsItem.identifier = SETTINGS_ITEM_ID
        settingsItem.isSelectable = false

        slider.addItems(searchItem, bookmarksItem, favouritesItem, DividerDrawerItem(), settingsItem)
    }

    override fun onBackPressed() {
        if (root_drawer.isDrawerOpen(slider)) {
            root_drawer.closeDrawer(slider)
        } else {
            super.onBackPressed()
        }
    }

    fun openNavMenu() {
        root_drawer.openDrawer(slider)
        for (listener in listeners) {
            listener.onOpen()
        }
    }

    fun closeNavMenu() {
        root_drawer.closeDrawer(slider)
        for (listener in listeners) {
            listener.onClose()
        }
    }

    fun addListener(listener: NavigationMenuListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: NavigationMenuListener) {
        listeners.remove(listener)
    }

    private fun attachCurrentUserToSlider() {
        val userInfo = CurrentUserRepository.getCurrentUserInfo()
        when {
            userInfo.pictureUrlStr != null -> profile.icon = ImageHolder(userInfo.pictureUrlStr)
            userInfo.genderType == UserInfo.GenderType.MALE -> profile.icon = ImageHolder(getDrawable(R.drawable.male_stub))
            userInfo.genderType == UserInfo.GenderType.FEMALE -> profile.icon = ImageHolder(getDrawable(R.drawable.female_stub))
            else -> profile.icon = null
        }
        slider.accountHeader = AccountHeaderView(this).apply {
            attachToSliderView(slider)
            addProfiles(profile)
            onAccountHeaderListener = { view, profile, current ->
                false
            }
            selectionListEnabled = false
            headerBackground = ImageHolder(R.drawable.header_nav_menu)
            onAccountHeaderProfileImageListener = { _, _, _ ->
                router?.showAccountSettingsPage()
                true
            }
        }
    }

    protected open fun canOpenNavMenuFromToolbar(): Boolean = false
}