package com.davidtakac.akademija2026primjer.data

import com.davidtakac.akademija2026primjer.model.Note
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextLong

class NoteRemoteStorage {
    private var note: Note = Note("This is my one and only note")

    suspend fun save(note: Note) {
        delay(1500)
        simulateNetworkCommunication()
        this.note = note
    }

    suspend fun get(): Note {
        delay(800)
        simulateNetworkCommunication()
        return note
    }

    private suspend fun simulateNetworkCommunication() {
        delay(Random.nextLong(300L..1500L))
        if (Random.nextInt(10) >= 8) {
            throw Exception("Oops!")
        }
    }
}
