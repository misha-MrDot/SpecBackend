package com.example.demka.mappers

import com.example.demka.dto.SpecRs
import com.example.demka.models.SpecEntity

fun SpecEntity.toDto() = SpecRs(
    id=id,
    title=title,
    description = description,
    photoUrl=photoUrl,
)