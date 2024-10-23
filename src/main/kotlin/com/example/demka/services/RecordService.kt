package com.example.demka.services;

import com.example.demka.dto.CreateRecordRq
import com.example.demka.dto.RecordRs
import com.example.demka.mappers.toDto
import com.example.demka.models.RecordEntity
import com.example.demka.repository.RecordEntityRepository
import com.example.demka.repository.SpecRepository
import jakarta.transaction.Transactional
import org.springframework.core.env.Environment
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.umom.hackaton.shared.errors.common.NotFoundError

@Service
class RecordService(
    private val recordEntityRepository: RecordEntityRepository,
    private val specRepository: SpecRepository,
    private val environment: Environment
) {
    @Transactional
    fun getAll(): List<RecordRs> = recordEntityRepository.findAll().map { it.toDto() }
    @Transactional
    fun getById(recordId: String): RecordRs =
        recordEntityRepository.findByIdOrNull(recordId)?.toDto() ?: throw NotFoundError("Item not found with id: $recordId")
    @Transactional
    fun create(dto: CreateRecordRq) {
        recordEntityRepository.save(
            RecordEntity(
                dateTitle = dto.dateTitle,
                dateTime = dto.dateTime,
                email = dto.email,
                phoneNumber = dto.phoneNumber,
                specialistEntity = specRepository.findByIdOrNull(dto.specId),
                done = false
            )
        )
    }
    @Transactional
    fun delete(recordId:String){
        recordEntityRepository.deleteById(recordId)
    }
    @Transactional
    fun update(recordId: String,done:Boolean){
        val recordUpdate:RecordEntity = recordEntityRepository.findByIdOrNull(recordId)?:throw RuntimeException("record not found")
        recordUpdate.done = done
        recordEntityRepository.save(recordUpdate)

    }
}