package com.example.demka.mappers

import com.example.demka.dto.SpecRs
import com.example.demka.models.SpecialistEntity

fun SpecialistEntity.toDto() = SpecRs(
    id=id,
    title=title,
    description = description,
    photoUrl=photoUrl,
    type=type,
    dates = dates,
)