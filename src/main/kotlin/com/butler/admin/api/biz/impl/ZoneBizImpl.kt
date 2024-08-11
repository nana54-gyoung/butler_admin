package com.butler.admin.api.biz.impl

import com.butler.admin.api.biz.ZoneBiz
import com.butler.admin.api.ui.vo.ResMetaVO
import com.butler.admin.api.ui.vo.ResVO
import com.butler.admin.api.ui.vo.ZoneVO
import com.butler.admin.mapstruct.ZoneMapStruct
import com.butler.admin.repository.ZoneRepository
import org.springframework.stereotype.Service

@Service
class ZoneBizImpl (
    private val zoneRepository: ZoneRepository,
    private val zoneMapStruct: ZoneMapStruct
) : ZoneBiz {
    override fun zoneList(): ResVO {
        val areaList = zoneRepository.findAll().toMutableList()
        return ResVO(meta = ResMetaVO(200, "ok"), data = areaList)
    }

    override fun zoneSave(zoneVO: ZoneVO): ResVO {
        val entity = zoneMapStruct.toEntity(zoneVO).also {
            zoneRepository.save(it)
        }
        return ResVO(meta = ResMetaVO(200, "ok"), data = zoneMapStruct.toDTO(entity))
    }

    override fun zoneDelete(zono: Int?): ResVO {
        return zoneRepository.findByZono(zono)?.let{ entity ->
            zoneRepository.delete(entity)
            ResVO(meta = ResMetaVO(200, "ok"), data = zoneMapStruct.toDTO(entity))
        } ?: ResVO(meta = ResMetaVO(400, "해당 지역 데이터가 존재하지 않습니다."))
    }
}