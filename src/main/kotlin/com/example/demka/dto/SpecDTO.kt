package com.example.demka.dto

class CreateSpecRq(
    val title: String,
    val description: String,
    val photoUrl: String,
)

class SpecRs(
    val id: String,
    val title: String,
    val description: String,
    val photoUrl: String,
)