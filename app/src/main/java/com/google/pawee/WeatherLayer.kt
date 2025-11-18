package com.google.pawee

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun RainAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_rainy))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CloudAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_cloudy))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SunRaysAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_sunny))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun StarAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_stars))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun CalmAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_calm))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SickAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_sick))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
