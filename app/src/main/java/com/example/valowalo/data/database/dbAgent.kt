package com.example.valowalo.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.valowalo.model.Ability
import com.example.valowalo.model.Agent
import com.example.valowalo.model.Role

@Entity(tableName = "agents")
data class dbAgent(
    @PrimaryKey
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val characterTags: List<String>,
    val displayIcon: String,
    val displayIconSmall: String,
    val bustPortrait: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val killfeedPortrait: String,
    val background: String,
    val backgroundGradientColors: List<String>, // JSON string
    val assetPath: String,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val role: Role,
    val abilities: List<Ability>,
)

fun dbAgent.asDomainAgent(): Agent {
    return Agent(
        this.uuid,
        this.displayName,
        this.description,
        this.developerName,
        this.characterTags,
        this.displayIcon,
        this.displayIconSmall,
        this.bustPortrait,
        this.fullPortrait,
        this.fullPortraitV2,
        this.killfeedPortrait,
        this.background,
        this.backgroundGradientColors,
        this.assetPath,
        this.isFullPortraitRightFacing,
        this.isPlayableCharacter,
        this.isAvailableForTest,
        this.role,
        this.abilities,

    )
}

fun Agent.asDbAgent(): dbAgent {
    return dbAgent(
        uuid = uuid,
        displayName = displayName,
        description = description,
        developerName = developerName,
        characterTags = characterTags,
        displayIcon = displayIcon,
        displayIconSmall = displayIconSmall,
        bustPortrait = bustPortrait,
        fullPortrait = fullPortrait,
        fullPortraitV2 = fullPortraitV2,
        killfeedPortrait = killfeedPortrait,
        background = background,
        backgroundGradientColors = backgroundGradientColors, // Convert list to string
        assetPath = assetPath,
        isFullPortraitRightFacing = isFullPortraitRightFacing,
        isPlayableCharacter = isPlayableCharacter,
        isAvailableForTest = isAvailableForTest,
        role = role,
        abilities = abilities,
    )
}

fun List<dbAgent>.asDomainAgents(): List<Agent> {
    return this.map { it.asDomainAgent() }
}
