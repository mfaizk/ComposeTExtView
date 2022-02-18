package com.example.composecourseyttextview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecourseyttextview.ui.theme.ComposeCourseYTTExtViewTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState= rememberScaffoldState()
//            = in equal we always need textfiled.value but if we use by then we can directly use it
            var textfieldState by remember {
                mutableStateOf("")
            }
            val scope= rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState

            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                    ) {
                    TextField(value = textfieldState, onValueChange ={
                                                                     textfieldState=it
                    },
                    label = {
                        Text(text = "Enter your name")
                    },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier =Modifier.height(16.dp))
Button(onClick = {
    scope.launch {     scaffoldState.snackbarHostState.showSnackbar("Hello $textfieldState")
    }
}) {
    Text(text = "Pls greet me")

}
                }

            }
        }
    }
}

