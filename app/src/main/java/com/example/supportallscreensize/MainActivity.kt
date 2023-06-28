package com.example.supportallscreensize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.supportallscreensize.ui.theme.SupportAllScreenSizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupportAllScreenSizeTheme {
                val windowInfo= rememberWindowInfo()
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        //list 1
                        items(10){
                            Text(text = "Item $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Blue)
                                    .padding(16.dp)
                            )
                        }
                        //list 2
                        items(10){
                            Text(text = "Item $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Cyan)
                                    .padding(16.dp)
                            )
                        }

                    }
                }
                else{
                    Row(modifier = Modifier.fillMaxWidth()) {
                        LazyColumn(modifier = Modifier.weight(1f)){
                            //list 1
                            items(10){
                                Text(text = "Item $it",
                                    fontSize = 25.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Green)
                                        .padding(16.dp)
                                )
                            }
                        }
                        //2
                        LazyColumn(modifier = Modifier.weight(1f)){
                            //list 1
                            items(10){
                                Text(text = "Item $it",
                                    fontSize = 25.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Blue)
                                        .padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SupportAllScreenSizeTheme {
        Greeting("Android")
    }
}