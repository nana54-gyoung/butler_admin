package com.butler.admin.repository

import com.butler.admin.model.entity.AreaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AreaRepository : CrudRepository<AreaEntity, Int> {
    fun findByArno(arno : Int?) : AreaEntity?
}