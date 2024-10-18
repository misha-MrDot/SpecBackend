package com.example.demka.mappers

import com.example.demka.dto.RecordRs
import com.example.demka.dto.SpecRs
import com.example.demka.models.RecordEntity
import com.example.demka.models.SpecialistEntity

fun RecordEntity.toDto() = RecordRs(
    id=id,
    dateTitle=dateTitle,
    dateTime=dateTime,
    email=email,
    phoneNumber=phoneNumber,
    specId = specialistEntity!!.id
)