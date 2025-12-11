package com.example.kmp_exam01

import android.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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

import kmp_exam01.composeapp.generated.resources.Res
import kmp_exam01.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var toggle by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(color= MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color =  if (toggle) Color.Gray else Color.Black),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text= if (toggle) "Ready" else "Not Ready",
                    fontSize = if (toggle) 24.sp else 12.sp,
                    color = if (toggle) Color.Green else Color.Red
                )
            }


            Button({ toggle = !toggle }) {
                Text("Test")
            }
        }



    }
}