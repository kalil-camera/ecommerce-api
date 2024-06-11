package com.kalilecommerce.product.dto

import java.math.BigDecimal

data class ProductDTO(
    val id: Long?,
    val name: String,
    val price: BigDecimal,
    val images: List<String>?
)
