package ru.ok.technopolis.training.personal.controllers

import ru.ok.technopolis.training.personal.navmenu.NavigationMenuListener

interface NavigationMenuController {

    fun openMenu()

    fun closeMenu()

    fun addMenuListener(listener: NavigationMenuListener)

    fun removeMenuListener(listener: NavigationMenuListener)
}