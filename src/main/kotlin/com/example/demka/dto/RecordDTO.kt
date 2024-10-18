package com.example.demka.dto

import com.example.demka.models.Date

class CreateRecordRq(
    val dateTitle:String,
    val dateTime:String,
    val email:String,
    val phoneNumber:String,
    val specId: String,
)
class CreateRecordForm(
    val dateTitle:String,
    val dateTime:String,
    val email:String,
    val phoneNumber:String,
)
class RecordRs(
    val id: String,
    val dateTitle: String,
    val dateTime: String,
    val email: String,
    val phoneNumber: String,
    val specId:String
)