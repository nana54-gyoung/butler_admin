package com.butler.admin.api.biz.impl

import com.butler.admin.api.biz.AreaBiz
import com.butler.admin.api.ui.vo.AreaVO
import com.butler.admin.api.ui.vo.ResMetaVO
import com.butler.admin.api.ui.vo.ResVO
import com.butler.admin.mapstruct.AreaMapStruct
import com.butler.admin.repository.AreaRepository
import com.google.gson.GsonBuilder
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class AreaBizImpl(
    private val areaRepository: AreaRepository,
    private val areaMapStruct: AreaMapStruct
) : AreaBiz {
    private val gson = GsonBuilder().create()
    private val logger = LoggerFactory.getLogger(AreaBizImpl::class.java)
    override fun areaList(): ResVO {
        val areaList = areaRepository.findAll().toMutableList()
        return ResVO(meta = ResMetaVO(200, "ok"), data = areaList)
    }

    override fun areaSave(areaVO: AreaVO): ResVO {
        val entity = areaMapStruct.toEntity(areaVO).also {
            areaRepository.save(it)
        }
        return ResVO(meta = ResMetaVO(200, "ok"), data = areaMapStruct.toDTO(entity))
    }

    override fun areaDelete(arno: Int?): ResVO {
        return areaRepository.findByArno(arno)?.let{ entity ->
            areaRepository.delete(entity)
            ResVO(meta = ResMetaVO(200, "ok"), data = areaMapStruct.toDTO(entity))
        } ?: ResVO(meta = ResMetaVO(400, "해당 지역 데이터가 존재하지 않습니다."))
    }

}