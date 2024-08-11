package com.butler.admin.mapstruct

import com.butler.admin.api.ui.vo.ZoneVO
import com.butler.admin.model.entity.ZoneEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring") @Component
interface ZoneMapStruct : EntityMapper<ZoneEntity, ZoneVO> {
    override fun toEntity(dto: ZoneVO): ZoneEntity

    override fun toDTO(entity: ZoneEntity): ZoneVO
}