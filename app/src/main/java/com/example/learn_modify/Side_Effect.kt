package com.example.learn_modify

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun side_effect(){
    Scaffold{ innerPadding ->
        var scope = rememberCoroutineScope()
        var count by remember { mutableStateOf(0) }

        Column(modifier = Modifier.padding(innerPadding)){

            LaunchedEffect(Unit) {
                Log.d("Test", "LaunchedEffect")
            }

            Log.d("Test", "Recompose, count = $count")

            Button(onClick = { count++ }) {
                Text("t: $count")
            }
        }
    }
}