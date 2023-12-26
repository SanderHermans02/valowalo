package com.example.valowalo.network

import com.example.valowalo.model.Ability
import com.example.valowalo.model.Agent
import com.example.valowalo.model.Role
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

@Serializable
data class ApiAgent(
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
    val backgroundGradientColors: List<String>,
    val assetPath: String,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val role: Role,
    val abilities: List<Ability>,
)

// extension function for an ApiTask List to convert is to a Domain Task List
fun Flow<List<ApiAgent>>.asDomainObjects(): Flow<List<Agent>> {
    return map {
        it.asDomainObjects()
    }
}

fun List<ApiAgent>.asDomainObjects(): List<Agent> {
    var domainList = this.map {
        Agent(it.uuid,
            it.displayName,
            it.description,
            it.developerName,
            it.characterTags,
            it.displayIcon,
            it.displayIconSmall,
            it.bustPortrait,
            it.fullPortrait,
            it.fullPortraitV2,
            it.killfeedPortrait,
            it.background,
            it.backgroundGradientColors,
            it.assetPath,
            it.isFullPortraitRightFacing,
            it.isPlayableCharacter,
            it.isAvailableForTest,
            it.role,
            it.abilities,)
    }
    return domainList
}