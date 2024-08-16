package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.Gray)
            .padding(bottom = 50.dp)
    ) {
        CardImage(
            image = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            title = stringResource(R.string.best_ever_and_forever),
        )
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {
        CardContacts(
            contact = "7-919-886-51-30",
            icon = Icons.Rounded.Phone,
            modifier = Modifier
        )
        CardContacts(
            contact = "@JulietteJuly",
            icon = Icons.Rounded.Create,
            modifier = Modifier
        )
        CardContacts(
            contact = "attain06@gmail.com",
            icon = Icons.Rounded.Email,
            modifier = Modifier
        )
    }
    }
}

@Composable
fun CardImage(
    image: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(50.dp)
    ) {
        androidx.compose.foundation.Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .background(Color.Gray)
//                .alpha(0.5f)
                .padding(top = 15.dp, bottom = 15.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp, top = 15.dp)
        )
        Text(
            text = title,
            fontSize = 24.sp,
        )
    }
}

@Composable
fun CardContacts(icon: ImageVector, contact: String, modifier: Modifier) {
    Row(
        modifier = Modifier.padding(bottom = 15.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null)
        Text(
            text = contact,
            modifier = Modifier.padding(start = 10.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}