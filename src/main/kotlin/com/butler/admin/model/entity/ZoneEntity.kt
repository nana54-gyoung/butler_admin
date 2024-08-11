package com.butler.admin.model.entity

import com.butler.admin.common.converter.JsonObjectConverter
import com.google.gson.JsonObject
import jakarta.persistence.*

@Entity
@Table(name = "zone")
data class ZoneEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)var zono:Int? = null) {
    var name : String? = null
    var address : String? = null
    @Convert(converter = JsonObjectConverter::class) var center: JsonObject? = JsonObject()
}
