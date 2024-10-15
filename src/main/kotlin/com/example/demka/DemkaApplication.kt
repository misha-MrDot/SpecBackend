package com.example.demka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemkaApplication

fun main(args: Array<String>) {
    runApplication<DemkaApplication>(*args)
}
