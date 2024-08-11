package com.butler.admin.common.converter

import com.butler.admin.model.enums.MEMBER_ROLE
import com.butler.admin.common.exception.ButlerException
import jakarta.persistence.AttributeConverter

class MemberRoleConverter  : AttributeConverter<MEMBER_ROLE, String> {
    override fun convertToDatabaseColumn(attribute: MEMBER_ROLE?): String? {
        return attribute?.role
    }

    override fun convertToEntityAttribute(dbData: String?): MEMBER_ROLE {
        return try{
            MEMBER_ROLE.values().filter { it.role == dbData }.first()
        }catch (e: Exception) {
            throw ButlerException("G-001", "해당 권한이 없습니다.")
        }
    }
}