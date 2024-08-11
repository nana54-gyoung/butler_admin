package com.butler.admin.common.converter

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


@Converter
class JsonObjectConverter : AttributeConverter<JsonObject, String> {
    private val gson = GsonBuilder().create()

    override fun convertToDatabaseColumn(attribute: JsonObject): String {
        return gson.toJson(attribute)
    }

    override fun convertToEntityAttribute(dbData: String): JsonObject {
        return gson.fromJson(dbData, JsonObject::class.java)
    }
}

