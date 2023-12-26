package com.example.valowalo.model

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val slot: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
)
