package com.example.learn_modify

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

val comicrelief = FontFamily(
    Font(R.font.comicrelief_regular , FontWeight.Normal),
    Font(R.font.comicrelief_bold, FontWeight.Bold)
)

@Composable
fun Button_Style(){
    Scaffold{ innerPadding ->
        Row(modifier = Modifier.padding(innerPadding)){
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(18, 128, 7, 255),
                    contentColor = Color.White
                ),
                border = BorderStroke(2.dp, Color(20, 255, 0, 255))
                ){
                Text("Click" , fontFamily = comicrelief , fontWeight = FontWeight.Normal , textDecoration = TextDecoration.Underline)
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(101, 0, 0, 255),
                    contentColor = Color.White
                ),
                border = BorderStroke(3.dp, Color(255, 0, 0, 255))
                )
            {
                Text("Click")
            }
            Button(
                onClick = { Button_Style_bool.value = false},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(14, 0, 131, 255),
                    contentColor = Color.White
                ),
                border = BorderStroke(3.dp, Color(0, 24, 255, 255))
                ){
                Text("Close")
            }
        }
    }
}