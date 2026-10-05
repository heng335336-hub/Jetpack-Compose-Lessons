package Project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn_modify.R
import com.example.learn_modify.Scroll_App_bool
import com.example.learn_modify.comicrelief

@Composable
fun Scroll_App(){
    var scroller = rememberScrollState()
    Scaffold{ innerPadding ->
        Column(modifier = Modifier .padding(innerPadding).fillMaxSize().verticalScroll(scroller) ,
        ){
            Column( //second column
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box( //grey box
                    modifier = Modifier
                        .fillMaxWidth(0.89f)
                        .height(240.dp)
                        .background(Color(232, 232, 232, 255), shape = RoundedCornerShape(17.dp)),
                ){
                    Box( //white box behind column duck
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .padding(10.dp)
                            .background(Color(255, 255, 255, 255), shape = RoundedCornerShape(17.dp)),
                    ){
                        Column( //column of duck
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(240.dp)
                                .background(Color(255, 255, 255, 255), shape = RoundedCornerShape(17.dp))

                        ){
                            Row(modifier = Modifier //contain image
                                .fillMaxWidth()
                                .height(170.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically

                            ){
                                Image(
                                    painter = painterResource(R.drawable.duck),
                                    contentDescription = "Duck",
                                    modifier = Modifier.size(150.dp) .padding(horizontal = 10.dp)
                                )
                                Text(
                                    text = "Wanna scroll?\nGo ahead.",
                                    fontSize = 23.sp,
                                    fontFamily = comicrelief,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(44, 44, 44, 255)
                                )
                            }
                            Row(modifier = Modifier //contain buttons back faah
                                .fillMaxWidth()
                                .height(70.dp)
                                .background(Color(255, 255, 255, 255), shape = RoundedCornerShape(17.dp))
                                .padding(horizontal = 20.dp),
                            ){
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(166, 166, 166, 255)),
                                    border = BorderStroke(3.dp, Color(0,0,0))
                                ){
                                    Text(text = "Back", color = Color(0,0,0), modifier = Modifier.clickable{Scroll_App_bool.value = false})
                                }
                                Spacer(modifier = Modifier.width(20.dp))
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(166, 166, 166, 255)),
                                    border = BorderStroke(3.dp, Color(0,0,0))
                                ){
                                    Text(text = "Faah", color = Color(0,0,0))
                                }
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier .height(30.dp))
                LazyRow(modifier = Modifier.fillMaxWidth() .fillMaxHeight(0.4f)){
                    itemsIndexed(listOf("Information", "Meme", "News", "Essay", "Pharagraph", "Read more", "Nothing")){ index , string ->
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(60.dp)
                                .background(Color(255, 255, 255, 255), shape = RoundedCornerShape(16.dp))
                                .border(1.dp, Color(199, 199, 199, 255) , shape = RoundedCornerShape(16.dp))
                                .clip(shape = RoundedCornerShape(16.dp))
                                .clickable{
                                    when(index){
                                        0 -> print("Meow")
                                        else -> print("Noper")
                                    }
                                },
                        ){
                            //Text(text = "$string" , modifier = Modifier .align(Alignment.TopStart) .padding(start = 9.dp))
                            if(index == 0){
                                Image(
                                    painter = painterResource(R.drawable.information),
                                    contentDescription = "Duck Walking",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.matchParentSize()
                                )
                            }
                            if(index == 1){
                                Text("")
                                Image(
                                    painter = painterResource(R.drawable.duck_nbg),
                                    contentDescription = "Duck logo",
                                    modifier = Modifier .align(Alignment.CenterEnd) .padding(end = 10.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier .width(20.dp))
                    }
                }
            }
        }
    }
}
