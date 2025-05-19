package com.sanalab.publicclass

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sanalab.publicclass.di.initKoin

fun main() {
    initKoin()

    application {

        Window(
            title = "Public Class",
            onCloseRequest = ::exitApplication
        ) {
            App()
        }
    }
}