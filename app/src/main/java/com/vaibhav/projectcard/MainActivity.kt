package com.vaibhav.projectcard

import android.content.Intent
import android.os.Bundle
import android.print.PrintAttributes.Margins
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.vaibhav.projectcard.ui.theme.ProjectCardTheme
import java.text.BreakIterator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BizzCard()
                }
            }
        }
    }
}

@Composable
fun BizzCard(){
    val buttonClickedState= remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            elevation = 10.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(10.dp))
        ) {

            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileImage()
                Spacer(modifier = Modifier.height(20.dp))

                Divider(thickness = 2.dp)
                ProfileName()
                Button(onClick = {
                    buttonClickedState.value=!buttonClickedState.value
                }) {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
                if (buttonClickedState.value){
                    Content()
                }
                else{ Box {} }
            }
        }
    }

}



@Composable
private fun ProfileName() {
    Column(modifier = Modifier.padding(5.dp))
    {
        Text(
            text = "Vaibhav Yadav",
            style = MaterialTheme.typography.h3,
            color = Color.Blue,
            fontSize = 35.sp
        )
        Text(
            text = "Android Developer",
            fontSize = 20.sp,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "KIIT University",
            fontSize = 20.sp,
            modifier = Modifier.padding(3.dp)
        )

    }
}

@Composable
private fun CreateProfileImage() {
    Surface(
        modifier = Modifier
            .size(170.dp)
            .padding(4.dp),
        shape = CircleShape,
//        border = BorderStroke(1.dp, Color.LightGray),
        elevation = 10.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.vai_img),
            contentDescription = "Vaibhav",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )

    }
}



@Composable
private fun CreateProjectImage
            (modifier: Modifier=Modifier)
{
    Surface(
        modifier = Modifier
            .padding(4.dp),
        shape = CircleShape,
//        border = BorderStroke(1.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "Vaibhav",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )

    }
}




@Preview
@Composable
fun Content(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            border = BorderStroke(width = 2.dp,
                color=Color.LightGray)
        ) {
            Surface(modifier = Modifier
                .padding(10.dp)
            ) {
                Portfolio(data = listOf("Project 1\n Web Development  ",
                    "Project 2\n App Development ",
                    "Project 3\n Machine Learning"))
            }

            
        }
    }

}




@Composable
fun Portfolio(data: List<String>) {


    LazyColumn{
        items(data){
            item -> 
            Card(modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(),
                shape= RectangleShape, elevation = 6.dp,
                border = BorderStroke(0.2.dp,
                    color = Color.LightGray)
            )
            {
                Row(modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(20.dp))
                {
                    CreateProjectImage(modifier = Modifier.size(50.dp))
                    
                    Column(modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                    )
                    {

                        Text(text = item,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.ExtraBold,)
                        val mContext = LocalContext.current
                        Button(onClick = {
                            mContext.startActivity(Intent(mContext, MainActivity2::class.java))
                        }, ) {
                            Text(text = "View",
                                style = MaterialTheme.typography.button
                            )
                        }

                    }
                }
            }
//            Divider(thickness = 3.dp)
            Spacer(modifier = Modifier.height(20.dp))

        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectCardTheme {
        BizzCard()
    }
}