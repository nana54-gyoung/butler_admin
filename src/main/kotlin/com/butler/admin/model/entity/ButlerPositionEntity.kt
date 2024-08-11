package com.butler.admin.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "butler_position")
data class ButlerPositionEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)var bpno:Int? = null) {
    var mbno : Int? = null
    var arno : Int? = null
    var zono : Int? = null
}
