package com.vaibhav.projectcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vaibhav.projectcard.ui.theme.ProjectCardTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Projects()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ProjectCardTheme {
        Projects()
    }
}
@Composable
fun Projects(){
    Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            elevation = 10.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
        ) {

        }
    }

}