package com.example.demka.models

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "specialists")
class SpecialistEntity(
    val title: String,
    val description: String,
    val photoUrl: String,
    val type: String,
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true )
    var dates: MutableList<Date> = mutableListOf(),
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true )
    var records: MutableList<RecordEntity> = mutableListOf()

    ) {
    @Id
    var id: String = UUID.randomUUID().toString()


}
@Entity
class Date(
    val title:String,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "date_time", joinColumns = [JoinColumn(name = "date_id")])
    var times: List<String>,

){

    @Id
    var id:String=UUID.randomUUID().toString()

}








