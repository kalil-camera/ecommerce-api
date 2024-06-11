package com.kalilecommerce.cart.dto

data class CartDTO(
    val id: Long?,
    val userId: Long,
    val productIds: List<Long>
)
