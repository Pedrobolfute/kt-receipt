package org.pedrobolfute

import presentation.HomeFrame
import com.formdev.flatlaf.FlatLightLaf

fun main() {

    //add styling here
    FlatLightLaf.setup()
    //launch frame here
    HomeFrame().isVisible = true
}