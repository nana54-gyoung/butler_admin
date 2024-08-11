package com.butler.admin.mapstruct

import com.butler.admin.api.ui.vo.AreaVO
import com.butler.admin.model.entity.AreaEntity
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring") @Component
interface AreaMapStruct : EntityMapper<AreaEntity, AreaVO> {
    override fun toEntity(dto: AreaVO): AreaEntity

    override fun toDTO(entity: AreaEntity): AreaVO
}