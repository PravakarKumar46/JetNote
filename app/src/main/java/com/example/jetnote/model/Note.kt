package com.example.jetnote.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(

    val id: UUID = UUID.randomUUID(), // unique strong id created by library itself
    val title: String,
    val description: String,
    val entryData: LocalDateTime = LocalDateTime.now()
)
