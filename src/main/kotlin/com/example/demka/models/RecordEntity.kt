package com.example.demka.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "record_entity")
class RecordEntity(
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="spec_id")
    var specialistEntity: SpecialistEntity?,
    val dateTitle:String,
    val dateTime:String,
    val email:String,
    val phoneNumber:String,

    )
{
    @Id
    var id: String = UUID.randomUUID().toString()
}