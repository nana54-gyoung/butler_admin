package com.butler.admin.api.biz

import com.butler.admin.api.ui.vo.AreaVO
import com.butler.admin.api.ui.vo.ResVO

interface AreaBiz {
    fun areaList() : ResVO
    fun areaSave(areaVO : AreaVO) : ResVO
    fun areaDelete(arno : Int?) : ResVO
}