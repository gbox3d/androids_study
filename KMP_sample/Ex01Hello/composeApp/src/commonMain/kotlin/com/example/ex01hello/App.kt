package com.example.ex01hello

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import ex01hello.composeapp.generated.resources.Res
import ex01hello.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.delay

@Composable
@Preview
fun App() {
    MaterialTheme {

        var counter by remember { mutableStateOf(0) }
        var message by remember { mutableStateOf("Hello, World!") }
        var isRunning by remember { mutableStateOf(false) }

        LaunchedEffect(isRunning) {
            if (isRunning) {
                while (true) {
                    delay(1000)
                    counter++
                }
            }
        }


        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text="count : ${counter}"
            )
            Button(onClick = {
                counter++
            })
            {
                Text("Click me!")
            }

            Spacer(
                Modifier.size(24.dp)
            )

            Text (
                text="message : ${message}"
            )

            Button(onClick = {
                message = "Hello, Compose!"
            })
            {
                Text("Change message!")
            }

            Spacer(Modifier.size(24.dp) )

            Text(
                text="Current : ${counter}"
            )

            Button(onClick = {
                isRunning = !isRunning

            }) {

                if(!isRunning)
                    Text("Start Timer")
                else
                    Text("Stop Timer")

            }

        }
    }
}