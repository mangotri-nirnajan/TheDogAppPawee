package com.google.pawee

import androidx.annotation.RawRes

enum class DogBreed {
    DOGGY_1,
    DOGGY_2,
    DOGGY_3,
    NORM,
    DOGGY_4,
    CAT_1,
    CAT_2 
}

object DogBreedManager {

    private var selectedBreed: DogBreed = DogBreed.DOGGY_1

    // Using an explicit map with your working files.
    private val breedAnimationMap: Map<DogBreed, Int> = mapOf(
        DogBreed.DOGGY_1 to R.raw.dog_calm_golden,
        DogBreed.DOGGY_2 to R.raw.dog_happy_corgi,
        DogBreed.DOGGY_3 to R.raw.dog_calm_new,
        DogBreed.DOGGY_4 to R.raw.yoga_dog,
        DogBreed.NORM to R.raw.dog_calm_norm,
        DogBreed.CAT_1 to R.raw.cat_calm_curly, 
        DogBreed.CAT_2 to R.raw.cat_calm_tail 
    )

    fun selectBreed(breed: DogBreed) {
        selectedBreed = breed
    }

    fun getSelectedBreed(): DogBreed = selectedBreed

    @RawRes
    fun getWalkingAnimation(breed: DogBreed = selectedBreed): Int {
        // If the breed is not in our map, default to the first doggy.
        return breedAnimationMap[breed] ?: R.raw.dog_calm_golden
    }
}
