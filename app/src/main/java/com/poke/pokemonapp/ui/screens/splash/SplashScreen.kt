package com.poke.pokemonapp.ui.screens.splash

import android.window.SplashScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.poke.pokemonapp.R
import com.poke.pokemonapp.ui.theme.PokeAppTheme
import com.poke.pokemonapp.ui.theme.customFontFamily
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigation: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_anim))
    var isVisibleText by remember { mutableStateOf(false) }
    var isVisibleName by remember { mutableStateOf(false) }
    val offsetY by animateDpAsState(targetValue = if (isVisibleText) 40.dp else 0.dp)
    LaunchedEffect(Unit) {
        delay(400)
        isVisibleName = !isVisibleName
        isVisibleText = !isVisibleText
        delay(1800)

        delay(1000)
        onNavigation()
    }



    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = isVisibleText,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            Text(
                text = "PokeApp",
                fontFamily = customFontFamily,
                fontSize = 80.sp
            )
        }

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(400.dp)
                .offset(y =offsetY),
            iterations = 1
        )
        AnimatedVisibility(
            visible = isVisibleName,
            enter = scaleIn(tween(1000)),
        ) {
            Text(
                text = "By Fabián",
                fontFamily = customFontFamily,
                fontSize = 50.sp
            )
        }
    }


}

@Preview
@Composable
fun previewSplash() {
    PokeAppTheme {
        SplashScreen { }
    }
}