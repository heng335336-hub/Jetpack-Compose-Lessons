package Project

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn_modify.Image_Scroll_bool
import com.example.learn_modify.comicrelief
import kotlin.random.Random

@OptIn(ExperimentalGridApi::class)
@Composable
fun Images_Scroll() {
    Scaffold{ innerPadding ->
        var scroller = rememberScrollState()
        var row_count by remember{mutableStateOf(10)}
        var col_count by remember { mutableStateOf(2) }
        var colors = remember{List(col_count * row_count){Color(Random.nextInt(256),Random.nextInt(256),Random.nextInt(256))} }

        Column(modifier = Modifier .padding(innerPadding) .fillMaxSize()){
            Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .border(3.dp, Color(62, 34, 161, 255)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Color Blocks",
                    fontSize = 30.sp,
                    color = Color(133, 0, 255, 255) ,
                    fontFamily = comicrelief,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    textDecoration = TextDecoration.None,
                    modifier = Modifier .clickable{ Image_Scroll_bool.value = false }
                )
            }
            Column(modifier = Modifier .fillMaxSize() .verticalScroll(scroller)){
                Grid(
                    modifier = Modifier.fillMaxSize() .padding(vertical = 30.dp),
                    config = {
                        column(1.fr)
                        column(1.fr)
                        repeat(row_count){
                            row(1.fr)
                        }
                        gap(40.dp)
                    }
                ){
                    colors.forEachIndexed { index, color ->
                        Column(modifier = Modifier .size(140.dp) .gridItem(alignment = Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally){
                            Box(modifier = Modifier .size(120.dp) .background(color), contentAlignment = Alignment.Center){
                                Text("Box $index")
                            }
                            Text(text = "Box color" , color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}
