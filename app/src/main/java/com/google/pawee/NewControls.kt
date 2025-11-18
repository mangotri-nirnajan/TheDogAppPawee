package com.google.pawee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Imports for the enums used in the composables
import com.google.pawee.DogBreed
import com.google.pawee.Mood

// Map to hold the user-facing names for each mood.
private val moodDisplayNames = mapOf(
    Mood.HAPPY to "Sunny",
    Mood.SAD to "Starry Moon Phase",
    Mood.ANXIOUS to "Rainy",
    Mood.CALM to "Starry Night",
    Mood.TOOMANYTHINGSGOINGON to "Park", // Renamed in UI
    Mood.SICK to "Sick"
)

@Composable
fun MoodSelector(onMoodSelected: (Mood) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(Mood.values()) { mood ->
                Button(
                    onClick = { onMoodSelected(mood) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = moodDisplayNames[mood] ?: mood.name)
                }
            }
        }
    }
}

@Composable
fun BreedSelector(onBreedSelected: (DogBreed) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(DogBreed.values()) { breed ->
                Button(
                    onClick = { onBreedSelected(breed) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    // Corrected the text formatting to fix the build error.
                    val formattedName = breed.name.replace("_", " ").lowercase()
                        .replaceFirstChar { it.uppercase() }
                    Text(text = formattedName)
                }
            }
        }
    }
}
