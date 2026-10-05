package com.example.learn_modify

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Textfield_Snackbar() {
    val snackbarHostState_noNew = remember{ SnackbarHostState() }
    var text_store by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState_noNew)}){ innerPadding ->
        Column(modifier = Modifier .fillMaxWidth() .fillMaxHeight() .padding(vertical = 16.dp, horizontal = 10.dp) .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(
                value = text_store,
                onValueChange = { newValue ->
                    text_store = newValue
                },
                label = { Text("Type something") },
                modifier = Modifier .width(400.dp),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier .fillMaxWidth()){
                Button( onClick = {
                    Textfield_Snackbar_bool.value = false })
                {
                    Text("Close")
                }
                Button( onClick = {
                    scope.launch {
                        if (text_store.isBlank()) {
                            snackbarHostState_noNew.showSnackbar("Nothing here")
                        } else {
                            snackbarHostState_noNew.showSnackbar(text_store)
                        }
                    } }
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}