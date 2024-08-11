package com.butler.admin.api.ui.act

import com.butler.admin.api.biz.AreaBiz
import com.butler.admin.api.ui.vo.AreaVO
import com.butler.admin.common.annotation.CurrentUser
import com.butler.admin.model.dto.MemberDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/area")
class AreaAction (
    private val areaBiz : AreaBiz
) {
    @GetMapping("/list")
    fun areaList(@CurrentUser member : MemberDTO) = areaBiz.areaList()

    @PostMapping("/save")
    fun areaSave(@CurrentUser member : MemberDTO, @RequestBody areaVO: AreaVO) = areaBiz.areaSave(areaVO)

    @DeleteMapping("/delete")
    fun areaDelete(@CurrentUser member : MemberDTO, @RequestParam(name = "arno") arno: Int?) = areaBiz.areaDelete(arno)
}