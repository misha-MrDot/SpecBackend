package com.example.demka.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.UUID
@Entity
@Table(name = "specs")
class SpecEntity(
    val title: String,
    val description: String,
    val photoUrl: String,
) {
    @Id
    var id: String = UUID.randomUUID().toString()
}



