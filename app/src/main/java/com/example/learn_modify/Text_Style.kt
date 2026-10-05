package com.example.learn_modify

import android.R.attr.height
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

val CosmicRelief = FontFamily(
    Font(R.font.comicrelief_bold, FontWeight.Bold),
    Font(R.font.comicrelief_regular, FontWeight.Normal)
)

@Composable
fun Text_Style(){
    Scaffold{ innerPadding ->
        Column(modifier = Modifier.border(1.dp, Color.Blue) .fillMaxWidth() .height(900.dp) .padding(innerPadding)){
            Text(
                text = "Jetpack Compose",
                color = Color(25, 86, 21, 255),
                fontSize = 30.sp,
                fontFamily=  CosmicRelief,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                text = "Jetpack Compose",
                color = Color(25, 86, 21, 255),
                fontSize = 30.sp
                )

            Text(
                text = buildAnnotatedString {
                    withStyle( style = SpanStyle( Color.Green, fontSize = 40.sp)){ append("J") }
                    withStyle( style = SpanStyle( fontSize = 30.sp)){ append("etpack") }
                    withStyle( style = SpanStyle( Color.Green, fontSize = 40.sp)){ append(" C") }
                    withStyle( style = SpanStyle( fontSize = 30.sp)){ append("ompose") } },
                color = Color(25, 86, 21, 255),
                fontSize = 30.sp,
                fontFamily=  CosmicRelief,
                fontWeight = FontWeight.Bold,
                //fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier .height(50.dp))
            Text(text = "Close", color = Color(255, 0, 0, 255), fontSize = 30.sp, modifier = Modifier .border(1.dp, Color.Red) .clickable{ text_style_bool.value = false })
        }
    }
}