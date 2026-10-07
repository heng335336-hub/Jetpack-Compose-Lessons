package com.example.learn_modify

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun circular_progress_bar(){
    Scaffold{ innerPadding ->
        var percent by remember { mutableFloatStateOf(0f) }
        var percent2 by remember{ mutableFloatStateOf(0.7f)}
        Column(modifier = Modifier.fillMaxSize() .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally){
            //normal
            Column(modifier = Modifier.padding(innerPadding)) {
                CircularProgressIndicator(progress = { percent }, modifier = Modifier.size(90.dp) .width(90.dp))

                Button(onClick = { if (percent < 1f) percent += 0.1f }) {
                    Text("Add 10%")
                }
            }

            Column(modifier = Modifier.fillMaxWidth() .height(350.dp), horizontalAlignment = Alignment.CenterHorizontally){
                Box(modifier = Modifier.size(150.dp) , contentAlignment = Alignment.Center){
                    Canvas(modifier = Modifier.size(100.dp)){
                        drawArc(
                            color = Color.Green,
                            startAngle = -90f,
                            sweepAngle = 360f * percent2,
                            useCenter = false,
                            style = Stroke(width = 20f)
                        )
                    }
                    Text("${(percent2 * 100).roundToInt()}%")
                }
                Button(onClick = { percent2 += 0.1f}){
                    Text("10%")
                }
                Button(onClick = { percent2 -= 0.1f}){
                    Text("-10%")
                }
            }
        }
    }
}