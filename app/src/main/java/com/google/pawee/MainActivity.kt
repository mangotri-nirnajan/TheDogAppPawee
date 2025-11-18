package com.google.pawee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.pawee.Mood
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showSplashScreen by remember { mutableStateOf(true) }
            var currentMood by remember { mutableStateOf<Mood>(Mood.HAPPY) }
            var selectedBreed by remember { mutableStateOf(DogBreedManager.getSelectedBreed()) }
            var showBreedSelector by remember { mutableStateOf(false) }
            var showMoodSelector by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                delay(2000)
                showSplashScreen = false
            }

            Box(modifier = Modifier.fillMaxSize()) {
                MainScreen(mood = currentMood, breed = selectedBreed)

                AnimatedVisibility(
                    visible = !showSplashScreen,
                    enter = fadeIn(animationSpec = tween(1000)),
                    exit = fadeOut(animationSpec = tween(1000))
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(onClick = { 
                                showMoodSelector = false
                                showBreedSelector = true 
                            }) {
                                Text(text = "Change Breed")
                            }
                            Button(onClick = { 
                                showBreedSelector = false
                                showMoodSelector = true 
                            }) {
                                Text(text = "How is today?")
                            }
                        }

                        if (showBreedSelector) {
                            BreedSelector { newBreed ->
                                DogBreedManager.selectBreed(newBreed)
                                selectedBreed = newBreed
                                showBreedSelector = false
                            }
                        }

                        if (showMoodSelector) {
                            MoodSelector { newMood ->
                                currentMood = newMood
                                showMoodSelector = false
                            }
                        }
                    }
                }

                Crossfade(targetState = showSplashScreen, animationSpec = tween(500)) {
                    if (it) {
                        Box(
                            modifier = Modifier.fillMaxSize().background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("pawee", fontSize = 56.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}
