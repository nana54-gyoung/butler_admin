package com.butler.admin.api.ui.vo

import com.google.gson.JsonObject

data class ZoneVO(
    var name : String? = null,
    var address:String? = null,
    var center : JsonObject? = JsonObject()
)
