package com.butler.admin.api.ui.vo

import com.google.gson.JsonObject

data class AreaVO(
    var name : String? = null,
    var center : JsonObject? = JsonObject()
)
