package com.example.dicee

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicee.ui.theme.DiceeTheme
import kotlin.random.Random

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
    var firstDice by remember { mutableIntStateOf(1) }
    var secondDice by remember { mutableIntStateOf(1) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        LogoImage()
        Spacer(modifier = Modifier.size(20.dp))
        Row {
            DiceImage(number = firstDice)
            Spacer(modifier = Modifier.size(16.dp))
            DiceImage(number = secondDice)
        }
        Spacer(modifier = Modifier.size(20.dp))
        RollButton(onClick = {
            firstDice = (1..6).random()
            secondDice = (1..6).random()

            print("First dice: $firstDice")
            print("Second dice: $secondDice")
        })
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
    val resourceId = when(number) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        6 -> R.drawable.dice6
        else -> throw IllegalArgumentException("Dice with number $number doesn't exist. It should between 1 and 6.")
    }
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = "Dice image of number $number"
    )
}

@Composable
fun RollButton(onClick: () -> Unit) {
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Red,
        contentColor = Color.White
    )
    Button(
        onClick = onClick,
        colors = buttonColors) {
        Text(text = "Roll")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceeTheme {
        BackgroundBox()
        MainColumn()
    }
}