package com.example.valowalo.model

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class Role(
    @PrimaryKey
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val assetPath: String,
)
