package com.example.learn_modify

import Project.Images_Scroll
import Project.Scroll_App
import Read.TextFileScreen
import android.graphics.fonts.Font
import android.os.Bundle
import android.system.Os.read
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn_modify.ui.theme.Learn_ModifyTheme


//Functions
var Image_Import_Bool = mutableStateOf(false)
var call_buttons_func = mutableStateOf(false)
var call_project_buttons_func = mutableStateOf(false)
var text_style_bool = mutableStateOf(false)
var tester_page_bool = mutableStateOf(false)
var Color_box_bool = mutableStateOf(false)
var Textfield_Snackbar_bool = mutableStateOf(false)
var Button_Style_bool = mutableStateOf(false)
var Lists_bool = mutableStateOf(false)
var Constrain_Layout_bool = mutableStateOf(false)
var Image_Scroll_bool = mutableStateOf(false)
var Scroll_App_bool = mutableStateOf(false)
var side_effect_bool = mutableStateOf(false)
var size_animate_bool = mutableStateOf(false)
var canvas_bool = mutableStateOf(false)

//Txts
var read_bool = mutableStateOf(false)
var content_Id = mutableStateOf(0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Learn_ModifyTheme {
                var selectedTab by remember {mutableStateOf(0)}
                var list = listOf("Page", "Project", "Read")
                Scaffold { innerPadding ->
                    ///Layer 1
                    Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        TabRow(
                            selectedTab,
                            containerColor = Color(204, 56, 255, 255),      // tab row background
                            contentColor = Color.White,
                            indicator = { tabPositions ->
                                TabRowDefaults.SecondaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                                    color = Color(227, 196, 255, 255)             // 2. underline color
                                )
                            }
                        ) {
                            list.forEachIndexed { index, text_from_list ->
                                Tab(
                                    selected = selectedTab == index,
                                    onClick = { selectedTab = index },
                                    selectedContentColor = Color.White,                    // text when selected
                                    unselectedContentColor = Color(255, 255, 255, 112),
                                    text = { Text(text_from_list) }

                                )
                            }
                        }
                        when (selectedTab) {
                            0 -> page()
                            1 -> project()
                            2 -> read()
                        }
                    }
                    //Layer 2
                    //here outside Card
                    if (Image_Import_Bool.value) {
                        Image_Import()
                    }

                    //Layer 3
                    if (text_style_bool.value) {
                        Text_Style()
                    }

                    //Layer 4
                    if (tester_page_bool.value) {
                        Tester_Func()
                    }

                    //Layer 5
                    if (Color_box_bool.value) {
                        ColorBox()
                    }

                    //Layer 6
                    if (Textfield_Snackbar_bool.value) {
                        Textfield_Snackbar()
                    }

                    //Layer 7
                    if (Button_Style_bool.value) {
                        Button_Style()
                    }

                    //Layer 8
                    if (Lists_bool.value) {
                        Lists()
                    }

                    //Layer 9
                    if (Constrain_Layout_bool.value) {
                        Constrain_Layout()
                    }

                    //Layer 10
                    if (Image_Scroll_bool.value){
                        Images_Scroll()
                    }

                    if(Scroll_App_bool.value){
                        Scroll_App()
                    }

                    if(side_effect_bool.value){
                        side_effect()
                    }

                    if(size_animate_bool.value){
                        size_animate()
                    }

                    if(canvas_bool.value){
                        circular_progress_bar()
                    }

                    ///////////////////////////////////////////////////////
                    //Layer 1
                    if(read_bool.value){
                        TextFileScreen(content_Id.value)
                    }


                }
            }
        }
    }
}
@Composable
fun page() {
    var scroller2 = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxWidth() .fillMaxHeight() .padding(10.dp) .verticalScroll(scroller2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally) { PageButtonSetter("Image_Import", { Image_Import_Bool.value = true }, "Implement Image()", 0.5f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Textfield_Snackbar", { Textfield_Snackbar_bool.value = true } , "OutLinedTextField, scope, snackbar", 0.8f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Tester", { tester_page_bool.value = true }, "General", 0.2f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Text_Style", { text_style_bool.value = true } , "Font, Size, Color...etc", 0.5f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("lists", { Lists_bool.value = true } , "Column with list", 0.4f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Button_Style", { Button_Style_bool.value = true } , "Border, Color" , 0.3f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("constraint_layout.txt", { Constrain_Layout_bool.value = true } , "Object space away from edge", 0.64f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Color_Box", { Color_box_bool.value = true } , "Box with random() color", 0.5f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Side_Effect", { side_effect_bool.value = true } , "N/A Not done", 0.3f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("size_animate", { size_animate_bool.value = true } , "tween, spring, keyframes", 0.6f, Modifier.fillMaxWidth()) }
        Column(modifier = Modifier .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally){ PageButtonSetter("Canvas", { canvas_bool.value = true } , "", 0.3f, Modifier.fillMaxWidth()) }

    }
}

@Composable
fun PageButtonSetter(text: String, onClick: () -> Unit, guideTexts: String, fractioner: Float, modifier: Modifier){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(192, 94, 234, 255), contentColor = Color.White),
        border = BorderStroke(3.dp, Color(40, 16, 79, 255)),
        shape = RectangleShape,
        modifier = modifier .shadow(
            elevation = 8.dp,
            shape = RectangleShape,
            ambientColor = Color(156, 0, 255, 255),
            spotColor = Color(255, 0, 200, 255)
        )
    ) {
        Text(text = text)
    }
    Text(text = guideTexts, modifier = Modifier.border(3.dp, Color.Magenta, shape = RoundedCornerShape(16.dp)) .fillMaxWidth(fractioner), textAlign = TextAlign.Center)
    Spacer(modifier = Modifier.height(20.dp))
}


@Composable
fun project(){
        Column(modifier = Modifier.width(500.dp) .height(1200.dp) .padding(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "Images_Scroll",
                    color = Color(165, 12, 255, 255),
                    fontSize = 25.sp,
                    modifier = Modifier.clickable { Image_Scroll_bool.value = true }
                        .border(3.dp, Color(165, 12, 255, 255)))
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Scroll_App",
                    color = Color(165, 12, 255, 255),
                    fontSize = 25.sp,
                    modifier = Modifier.clickable { Scroll_App_bool.value = true }
                        .border(3.dp, Color(165, 12, 255, 255)))

            }
        }
}

@Composable
fun read(){
    var scroller = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize() .padding(vertical = 10.dp) .verticalScroll(scroller)){
        Column(modifier = Modifier.fillMaxWidth() .clickable { read_bool.value = true; content_Id.value = R.raw.color } .height(50.dp) .border(1.dp, Color(136, 0, 255, 255)), verticalArrangement = Arrangement.Center) {
            Text(
                text = "color",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = comicrelief,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { read_bool.value = true; content_Id.value = R.raw.color }
            )
        }

        Column(modifier = Modifier.fillMaxWidth() .clickable { read_bool.value = true; content_Id.value = R.raw.constraint_layout } .height(50.dp) .border(1.dp, Color(136, 0, 255, 255)), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Constraint_Layout",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = comicrelief,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { read_bool.value = true; content_Id.value = R.raw.constraint_layout }
            )
        }

        Column(modifier = Modifier.fillMaxWidth() .clickable { read_bool.value = true; content_Id.value = R.raw.lists } .height(50.dp) .border(1.dp, Color(136, 0, 255, 255)), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Lists",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = comicrelief,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { read_bool.value = true; content_Id.value = R.raw.lists }
            )
        }

        Column(modifier = Modifier.fillMaxWidth() .clickable { read_bool.value = true; content_Id.value = R.raw.row_and_column } .height(50.dp) .border(1.dp, Color(136, 0, 255, 255)), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Row_and_Column",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = comicrelief,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { read_bool.value = true; content_Id.value = R.raw.row_and_column }
            )
        }

        Column(modifier = Modifier.fillMaxWidth() .clickable { read_bool.value = true; content_Id.value = R.raw.shape } .height(50.dp) .border(1.dp, Color(136, 0, 255, 255)), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Shape",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = comicrelief,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { read_bool.value = true; content_Id.value = R.raw.shape }
            )
        }

        Column(modifier = Modifier.fillMaxWidth() .clickable { read_bool.value = true; content_Id.value = R.raw.shape } .height(50.dp) .border(1.dp, Color(136, 0, 255, 255)), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Animate Dp As State",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = comicrelief,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { read_bool.value = true; content_Id.value = R.raw.animate_dp_as_state }
            )
        }
    }
}