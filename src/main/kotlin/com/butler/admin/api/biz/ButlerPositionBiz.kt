package com.butler.admin.api.biz

import com.butler.admin.api.ui.vo.ButlerPositionVO
import com.butler.admin.api.ui.vo.ResVO

interface ButlerPositionBiz {
    fun butlerPositionList() : ResVO
    fun butlerPositionSave(butlerPositionVO : ButlerPositionVO) : ResVO
    fun butlerPositionDelete(bpno : Int?) : ResVO
}