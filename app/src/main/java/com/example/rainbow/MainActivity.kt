package com.example.rainbow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration
import android.content.res.Configuration
import com.example.rainbow.ui.theme.RainbowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RainbowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RainbowScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RainbowScreen(modifier: Modifier = Modifier) {
    val isLandscape = isLandscape()
    if (isLandscape) {
        Column(modifier = modifier.fillMaxSize()) { // Используем Column вместо Row
            RainbowColorBox(color = Color.Red, colorName = "Красный", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFFFF7F00), colorName = "Оранжевый", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color.Yellow, colorName = "Желтый", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFF00FF00), colorName = "Зеленый", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFF10B2F0), colorName = "Голубой", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color.Blue, colorName = "Синий", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFF8A2BE2), colorName = "Фиолетовый", modifier = Modifier.weight(1f).fillMaxWidth())
        }
    } else {
        Column(modifier = modifier.fillMaxSize()) {
            RainbowColorBox(color = Color.Red, colorName = "Красный", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFFFF7F00), colorName = "Оранжевый", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color.Yellow, colorName = "Желтый", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFF00FF00), colorName = "Зеленый", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFF10B2F0), colorName = "Голубой", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color.Blue, colorName = "Синий", modifier = Modifier.weight(1f).fillMaxWidth())
            RainbowColorBox(color = Color(0xFF8A2BE2), colorName = "Фиолетовый", modifier = Modifier.weight(1f).fillMaxWidth())
        }
    }
}

@Composable
fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

@Composable
fun RainbowColorBox(color: Color, colorName: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth() // Заполняем всю ширину в любом случае
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = colorName,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RainbowScreenPreview() {
    RainbowTheme {
        RainbowScreen()
    }
}
