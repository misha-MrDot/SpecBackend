package ru.umom.hackaton.shared.utils

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun genereateErrorResponse(message: String, status: HttpStatus): ResponseEntity<*> =
    ResponseEntity(mapOf("error" to message), status)
