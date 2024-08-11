package com.butler.admin.api.biz.impl

import com.butler.admin.api.biz.ButlerPositionBiz
import com.butler.admin.api.ui.vo.ButlerPositionVO
import com.butler.admin.api.ui.vo.ResMetaVO
import com.butler.admin.api.ui.vo.ResVO
import com.butler.admin.mapstruct.ButlerPositionMapstruct
import com.butler.admin.repository.ButlerPositionRepository
import org.springframework.stereotype.Service

@Service
class ButlerPositionBizImpl(
    private val butlerPositionRepository: ButlerPositionRepository,
    private val butlerPositionMapstruct: ButlerPositionMapstruct
) : ButlerPositionBiz {

    override fun butlerPositionList(): ResVO {
        val areaList = butlerPositionRepository.findAll().toMutableList()
        return ResVO(meta = ResMetaVO(200, "ok"), data = areaList)
    }

    override fun butlerPositionSave(butlerPositionVO: ButlerPositionVO): ResVO {
        val entity = butlerPositionMapstruct.toEntity(butlerPositionVO).also {
            butlerPositionRepository.save(it)
        }
        return ResVO(meta = ResMetaVO(200, "ok"), data = butlerPositionMapstruct.toDTO(entity))
    }

    override fun butlerPositionDelete(bpno: Int?): ResVO {
        return butlerPositionRepository.findByBpno(bpno)?.let{ entity ->
            butlerPositionRepository.delete(entity)
            ResVO(meta = ResMetaVO(200, "ok"), data = butlerPositionMapstruct.toDTO(entity))
        } ?: ResVO(meta = ResMetaVO(400, "해당 지역 데이터가 존재하지 않습니다."))
    }
}