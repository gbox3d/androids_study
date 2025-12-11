package com.example.testkmp

import android.graphics.Color.rgb
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import testkmp.composeapp.generated.resources.Res
import testkmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {

        var showContent by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text ="Ready",
                fontSize=24.sp

            )
            AnimatedVisibility(showContent) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0,0,0))
                        .height(100.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text="Test",
                        color = Color(0,255,0),
                        fontSize=24.sp
                    )
                    Text(
                        text="Test2",
                        color = Color(0,255,0),
                        fontSize=16.sp
                    )

                }

            }
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0,0,0))
                    .height(100.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text= if(showContent) "Hi" else "Hello",
                    color = if (showContent) Color(0,255,0) else Color(255,0,0),
                    fontSize=24.sp
                )
            }


        }

    }
}