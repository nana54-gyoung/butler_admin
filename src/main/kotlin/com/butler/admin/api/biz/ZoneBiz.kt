package com.butler.admin.api.biz

import com.butler.admin.api.ui.vo.ResVO
import com.butler.admin.api.ui.vo.ZoneVO

interface ZoneBiz {
    fun zoneList() : ResVO
    fun zoneSave(zoneVO: ZoneVO) : ResVO
    fun zoneDelete(zono : Int?) : ResVO
}