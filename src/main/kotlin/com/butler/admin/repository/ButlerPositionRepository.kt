package com.butler.admin.repository

import com.butler.admin.model.entity.ButlerPositionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ButlerPositionRepository : CrudRepository<ButlerPositionEntity, Int>{
    fun findByBpno(bpno : Int?) : ButlerPositionEntity?
}