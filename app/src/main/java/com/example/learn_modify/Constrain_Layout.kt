package com.example.learn_modify

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


@Composable
fun Constrain_Layout(){
    Scaffold{ innerPadding ->
        ConstraintLayout(constraintSet = ConstraintSet_Func(), modifier = Modifier .padding(innerPadding) .fillMaxSize()){
            Box(modifier = Modifier.layoutId("box1") .background(Color.Red)){
                Text("Box1", color = Color.White)
            }
            Box(modifier = Modifier.layoutId("box2") .background(Color.Blue)){
                Text("Box2", color = Color.White)
            }
            Box(modifier = Modifier.layoutId("box3") .background(Color.Green)){
                Text("Box3", color = Color.Black)
            }
            Box(modifier = Modifier.layoutId("box4") .background(Color.Yellow) .clickable{Constrain_Layout_bool.value = false}){
                Text("Close", color = Color.Black)
            }
            Box(modifier = Modifier.layoutId("Guideline") .background(Color.Magenta)){
                Text("Guideline", color = Color.Black)
            }
        }
    }
}

@Composable
fun ConstraintSet_Func() : ConstraintSet {
    return ConstraintSet{
        var box1 = createRefFor("box1")
        var box2 = createRefFor("box2")
        var box3 = createRefFor("box3")
        var box4 = createRefFor("box4")
        var guideline_box = createRefFor("Guideline")
        val guideline = createGuidelineFromTop(0.5f)


        constrain(box1){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(90.dp)
            height = Dimension.value(90.dp)
        }

        constrain(box2){
            top.linkTo(parent.top)
            start.linkTo(box1.start, margin = 90.dp)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(90.dp)
        }

        constrain(box3){
            top.linkTo(parent.top , margin = 180.dp)
            start.linkTo(parent.start)
            width = Dimension.value(90.dp)
            height = Dimension.value(90.dp)
        }

        constrain(box4){
            top.linkTo(parent.top ,margin = 180.dp)
            start.linkTo(box1.start, margin = 90.dp)
            end.linkTo(parent.end)
            width = Dimension.value(90.dp)
            height = Dimension.value(90.dp)
        }
        constrain(guideline_box){
            top.linkTo(guideline)
            start.linkTo(box1.start)
            width = Dimension.value(90.dp)
            height = Dimension.value(90.dp)
        }
        createHorizontalChain(box3, box4, chainStyle = ChainStyle.Packed) //Spread
    }
}