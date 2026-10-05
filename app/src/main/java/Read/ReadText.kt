package Read

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn_modify.R
import com.example.learn_modify.read
import com.example.learn_modify.read_bool


@Composable
fun TextFileScreen(Id : Int) {
    Scaffold{ innerPadding ->
        var context = LocalContext.current
        var content by remember{ mutableStateOf("")}
        var scroller = rememberScrollState()
        var font_Size by remember{mutableStateOf(16f)}
        Column(modifier = Modifier.fillMaxSize() .padding(innerPadding) ){
            Column(modifier = Modifier.fillMaxWidth() .fillMaxHeight(0.9f) .verticalScroll(scroller)){
                content = context.resources.openRawResource(Id).bufferedReader().use{it.readText()}
                Text(content, fontSize = font_Size.sp)
            }
            Row(modifier = Modifier .fillMaxWidth() .padding(vertical = 10.dp), horizontalArrangement = Arrangement.SpaceAround){
                Button(
                    onClick = { read_bool.value = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(42, 41, 41, 255), contentColor = Color.White), border = BorderStroke(3.dp, Color(0,0, 0, 255))
                )
                {
                    Text(text = "Close")
                }
                Button(
                    onClick = { font_Size -=1 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(42, 41, 41, 255), contentColor = Color.White), border = BorderStroke(3.dp, Color(0,0, 0, 255)),
                )
                {
                    Text(text = "-")
                }
                Button(
                    onClick = { font_Size +=1 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(42, 41, 41, 255), contentColor = Color.White), border = BorderStroke(3.dp, Color(0,0, 0, 255)),
                )
                {
                    Text(text = "+")
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(42, 41, 41, 255), contentColor = Color.White), border = BorderStroke(3.dp, Color(0,0, 0, 255)),
                )
                {
                    Text(text = "$font_Size")
                }

            }
        }

    }
}

