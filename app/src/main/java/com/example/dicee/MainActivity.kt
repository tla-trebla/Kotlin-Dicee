package com.example.dicee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dicee.ui.theme.DiceeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainColumn()
                }
            }
        }
    }
}

@Composable
fun MainColumn() {
    Column {
        LogoImage()
    }
}

@Composable
fun LogoImage() {
    Image(
        painter = painterResource(id = R.drawable.diceelogo),
        contentDescription = "Dicee Logo"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceeTheme {
        MainColumn()
    }
}