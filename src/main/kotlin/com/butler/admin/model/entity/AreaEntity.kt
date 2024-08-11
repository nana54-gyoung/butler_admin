package com.butler.admin.model.entity

import com.butler.admin.common.converter.JsonObjectConverter
import com.google.gson.JsonObject
import jakarta.persistence.*

@Entity
@Table(name = "area")
data class AreaEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)var arno:Int? = null) {
    var name : String? = null
    @Convert(converter = JsonObjectConverter::class) var center: JsonObject? = JsonObject()
}
