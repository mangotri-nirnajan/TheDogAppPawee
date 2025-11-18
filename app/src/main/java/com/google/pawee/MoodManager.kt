package com.google.pawee

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MainScreen(mood: Mood, breed: DogBreed) {
    Box(modifier = Modifier.fillMaxSize()) {
        Crossfade(targetState = mood, animationSpec = tween(1000)) { currentMood ->
            WeatherEffect(mood = currentMood)
        }

        // Dog and Speech Bubble together
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            // Dog Animation
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(DogBreedManager.getWalkingAnimation(breed)))
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            // Speech Bubble above the dog
            SpeechBubble(message = getMessageForMood(mood))
        }
    }
}

// Your function to get a random message
fun getMessageForMood(mood: Mood): String {
    return when (mood) {
        Mood.CALM -> DogMessages.calm.random()
        Mood.ANXIOUS -> DogMessages.anxious.random()
        Mood.HAPPY -> DogMessages.happy.random()
        Mood.SAD -> DogMessages.sad.random()
        // Corrected the message list name
        Mood.TOOMANYTHINGSGOINGON -> DogMessages.toomanythingsgoingon.random()
        Mood.SICK -> DogMessages.sick.random()
    }
}

@Composable
fun SpeechBubble(message: String) {
    Box(
        modifier = Modifier
            .padding(bottom = 260.dp) // Position above the dog
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White.copy(alpha = 0.8f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = message,
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun WeatherEffect(mood: Mood) {
    when (mood) {
        Mood.ANXIOUS -> RainAnimation()
        Mood.SAD -> StarAnimation()
        Mood.CALM -> CalmAnimation()
        Mood.HAPPY -> SunRaysAnimation()
        Mood.TOOMANYTHINGSGOINGON -> CloudAnimation()
        Mood.SICK -> SickAnimation()
    }
}
