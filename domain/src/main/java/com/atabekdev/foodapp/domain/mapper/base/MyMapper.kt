package com.atabekdev.foodapp.domain.mapper.base

import java.lang.RuntimeException

interface MyMapper<E, D> {
    fun mapFromEntity(from: E): D

    fun mapToEntity(from: D): E {
        throw RuntimeException("for this mapper mapping do not necessarily")
    }
}