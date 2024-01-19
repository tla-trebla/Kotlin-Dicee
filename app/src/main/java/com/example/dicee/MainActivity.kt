package com.example.dicee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dicee.ui.theme.DiceeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BackgroundBox()
                    MainColumn()
                }
            }
        }
    }
}

@Composable
fun BackgroundBox() {
    val paintModifier = Modifier.paint(
        painter = painterResource(id = R.drawable.background),
        contentScale = ContentScale.FillBounds
    )
    val modifier = Modifier
        .fillMaxSize()
        .then(paintModifier)
    Box(modifier = modifier)
}

@Composable
fun MainColumn() {
    Column {
        LogoImage()
        Row {
            DiceImage(number = 1)
            DiceImage(number = 2)
        }
    }
}

@Composable
fun LogoImage() {
    Image(
        painter = painterResource(id = R.drawable.diceelogo),
        contentDescription = "Dicee Logo"
    )
}

@Composable
fun DiceImage(number: Int) {
    val context = LocalContext.current
    val name = "dice$number"
    val drawableId = context.resources.getIdentifier(name, "drawable", context.packageName)
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = "Dice image of number $number"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceeTheme {
        BackgroundBox()
        MainColumn()
    }
}