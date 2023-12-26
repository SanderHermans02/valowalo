package com.example.valowalo.data

import com.example.valowalo.model.Agent
import com.example.valowalo.network.AgentApiService
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {
    fun getAgents(): Flow<List<Agent>>

    // one specific item
    fun getAgent(uuid: String): Flow<Agent?>
}

class ApiAgentsRepository(retrofitService: AgentApiService) : AgentsRepository {
    override fun getAgents(): Flow<List<Agent>> {
        TODO("Not yet implemented")
    }

    override fun getAgent(uuid: String): Flow<Agent?> {
        TODO("Not yet implemented")
    }
}
