package com.example.learn_modify

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun ColorBox(){
    Scaffold { innerPadding ->
        var color by remember { mutableStateOf(Color.Red)}
        Box(modifier = Modifier .background(color) .fillMaxWidth() .fillMaxHeight() .clickable{ color = Color(Random.nextInt(256),Random.nextInt(256),Random.nextInt(256)) } .padding(innerPadding)){
            Text(text = "Close", textDecoration = TextDecoration.Underline, fontSize = 40.sp, modifier = Modifier.clickable{ Color_box_bool.value = false})
        }
    }
}