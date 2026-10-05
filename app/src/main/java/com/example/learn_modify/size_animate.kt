package com.example.learn_modify

import android.util.Log
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@Composable
fun size_animate(){
    Scaffold{ innerPadding ->
        var max_size_red by remember{ mutableStateOf(200.dp) }
        var max_size_blue by remember{ mutableStateOf(200.dp) }
        var max_size_green by remember{ mutableStateOf(200.dp) }
        val animate_size_red by animateDpAsState(
            targetValue = max_size_red,
            tween(
                delayMillis = 1000,
                durationMillis = 1000,
                easing = LinearEasing
            )
        )

        val animate_size_blue by animateDpAsState(
            max_size_blue,
            spring(
                0.2f, //bouncy //value < 0.3 = speed of expand and bounc
                Spring.StiffnessMedium //speed of motio (this one is slow motion medium lelvel)
            )
        )

        val animate_size_green by animateDpAsState(
            max_size_green,
            keyframes{
                delayMillis = 100 //delay before it work
                durationMillis = 4000 //duration 4s

                0.dp at 0 //first, o.dp at 0s of durationMillis,
                200.dp at 2000 //box must reach 200.dp when durationMillis reach 2000ms
                300.dp at 3000 //box must reach 300.dp when durationMillis reach 3000ms
                400.dp at 4000 //box must reach 400.dp when durationMillis reach 4000ms
                //400.dp ? because original max_size_green = 200, button make it plus more 200
                //sp, total 400
            }
        )
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxHeight()
            .fillMaxWidth()){
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f) ){
                Box(modifier = Modifier
                    .size(animate_size_red)
                    .background(Color.Red), contentAlignment = Alignment.Center){}
                Box(modifier = Modifier
                    .size(animate_size_blue)
                    .background(Color.Blue), contentAlignment = Alignment.Center){}
                Box(modifier = Modifier
                    .size(400.dp)
                    .border(2.dp, Color.Cyan)){
                    Box(modifier = Modifier
                        .size(animate_size_green)
                        .background(Color.Green), contentAlignment = Alignment.Center){}
                }

            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)){
                Button(onClick = { max_size_red += 50.dp }){
                    Text("Red")
                }
                Button(onClick = { max_size_blue += 50.dp }){
                    Text("Blue")
                }
                Button(onClick = { max_size_green += 200.dp }){
                    Text("Green")
                }
                Button(onClick = { max_size_green = 200.dp }){
                    Text("Green: ${animate_size_green.value.toInt()} dp")
                }
            }
        }
    }
}