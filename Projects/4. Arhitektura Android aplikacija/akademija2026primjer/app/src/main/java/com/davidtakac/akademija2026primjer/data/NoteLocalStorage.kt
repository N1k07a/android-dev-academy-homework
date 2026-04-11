package com.davidtakac.akademija2026primjer.data

import com.davidtakac.akademija2026primjer.model.Note
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextLong

class NoteLocalStorage {
    private var note: Note? = null

    suspend fun save(note: Note) {
        simulateDiskIo()
        this.note = note
    }

    suspend fun get(): Note? {
        simulateDiskIo()
        return note
    }

    private suspend fun simulateDiskIo() {
        delay(Random.nextLong(10L..50L))
    }
}
