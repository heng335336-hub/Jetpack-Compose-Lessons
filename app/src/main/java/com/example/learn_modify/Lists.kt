package com.example.learn_modify

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lists(){
    Scaffold{ innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxWidth() . padding(innerPadding) , horizontalAlignment = Alignment.CenterHorizontally){
            itemsIndexed(
                listOf("Today", "I", "don't", "feel", "like", "doing", "anything")
            ){ index , String ->
                Box(modifier = Modifier .width(80.dp) .height(40.dp) .border(2.dp, Color.Magenta)){
                    Text(
                        text = String + " " + index,
                        color = Color.Blue,
                        fontFamily = comicrelief,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline)
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
            items(1){
                Button( onClick = {Lists_bool.value = false}){
                    Text("Closer")
                }
            }
        }
    }
}

/** Normal Scroll Column

 **/