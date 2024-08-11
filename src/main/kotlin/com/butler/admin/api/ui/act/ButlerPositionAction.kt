package com.butler.admin.api.ui.act

import com.butler.admin.api.biz.ButlerPositionBiz
import com.butler.admin.api.ui.vo.ButlerPositionVO
import com.butler.admin.common.annotation.CurrentUser
import com.butler.admin.model.dto.MemberDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/butler/position")
class ButlerPositionAction(
    private val butlerPositionBiz : ButlerPositionBiz
) {

    @GetMapping("/list")
    fun butlerPositionList(@CurrentUser member : MemberDTO) = butlerPositionBiz.butlerPositionList()

    @PostMapping("/save")
    fun butlerPositionSave(@CurrentUser member : MemberDTO, @RequestBody butlerPositionVO : ButlerPositionVO) = butlerPositionBiz.butlerPositionSave(butlerPositionVO)

    @DeleteMapping("/delete")
    fun butlerPositionDelete(@CurrentUser member : MemberDTO, @RequestParam(name = "bpno") bpno: Int?) = butlerPositionBiz.butlerPositionDelete(bpno)
}