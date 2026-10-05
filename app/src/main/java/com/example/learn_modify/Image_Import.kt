package com.example.learn_modify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn_modify.ui.theme.Learn_ModifyTheme

@Composable
fun Image_Import(){
    Scaffold{ innerPadding ->
        Modifier.padding(innerPadding)
        //Text("Hello World", modifier = Modifier. border(1.dp, color.txt.Red) .padding(15.dp) , fontSize = 30.sp)
        val painter = painterResource(id = R.drawable.orange)
        val Description = "A bunch of orange"
        val titler = "Orange"
        ImageCard(modifier = Modifier.padding(innerPadding), painter, Description)
    }

}

@Composable
fun ImageCard(modifier: Modifier = Modifier, painter: Painter, contentDescription: String ){
    Column(modifier = modifier .size(500.dp) .border(3.dp, Color.Green)){
        Image(
            modifier = Modifier .fillMaxWidth(),
            painter = painter,
            contentDescription = contentDescription,
        )
        Text("This is ah jok favourite orange", modifier = Modifier, Color(255, 115, 0, 255), fontSize = 30.sp)
        Row(){
            Text("to print some message")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Close", color = Color(255, 0, 0, 255), fontSize = (25.sp), modifier = Modifier.clickable{ Image_Import_Bool.value = false })
        }
    }
}