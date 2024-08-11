package com.butler.admin.api.ui.act

import com.butler.admin.api.biz.ZoneBiz
import com.butler.admin.api.ui.vo.ZoneVO
import com.butler.admin.common.annotation.CurrentUser
import com.butler.admin.model.dto.MemberDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/zone")
class ZoneAction  (
    private val zoneBiz : ZoneBiz
) {
    @GetMapping("/list")
    fun zoneList(@CurrentUser member : MemberDTO) = zoneBiz.zoneList()

    @PostMapping("/save")
    fun zoneSave(@CurrentUser member : MemberDTO, @RequestBody zoneVO: ZoneVO) = zoneBiz.zoneSave(zoneVO)

    @DeleteMapping("/delete")
    fun zoneDelete(@CurrentUser member : MemberDTO, @RequestParam(name = "zono") zono: Int?) = zoneBiz.zoneDelete(zono)
}