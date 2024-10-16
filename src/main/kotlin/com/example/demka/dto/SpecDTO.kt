package com.example.demka.dto

import com.example.demka.models.Date
import org.hibernate.mapping.Map
import java.awt.List

class CreateSpecRq(
    val title: String,
    val description: String,
    val photoUrl: String,
    val dates: MutableList<Date>,
)

class CreateSpecRq2(
    val title: String,
    val description: String,
    val photoUrl: String,
)

class SpecRs(
    val id: String,
    val title: String,
    val description: String,
    val photoUrl: String,
    val dates: MutableList<Date>,
)