package dk.alstroem.flowdemo.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository {

    val testFlow: Flow<String> = flow {
        val result = fetchApiResponse()
        emit(result)
    }

    suspend fun fetchApiResponse(): String {
        return "Hello from flow!"
    }
}
