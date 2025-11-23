package com.example.ex01hello

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Ex01Hello",
    ) {
        App()
    }
}