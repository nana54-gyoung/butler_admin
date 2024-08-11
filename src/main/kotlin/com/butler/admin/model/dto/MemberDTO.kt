package com.butler.admin.model.dto

import com.butler.admin.common.converter.MemberRoleConverter
import com.butler.admin.model.enums.MEMBER_ROLE
import jakarta.persistence.Convert
import java.time.LocalDateTime

data class MemberDTO(
    var mbno : Int? = null,
    @Convert(converter = MemberRoleConverter::class) var role : MEMBER_ROLE? = null,
    var id : String? = null,
    var tel : String? = null,
    var password : String? = null,
    var regdt : LocalDateTime? = LocalDateTime.now()
)
