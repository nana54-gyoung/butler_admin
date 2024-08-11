package com.butler.admin.repository

import com.butler.admin.model.entity.ZoneEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ZoneRepository: CrudRepository<ZoneEntity, Int> {
    fun findByZono(zono : Int?) : ZoneEntity?
}