package com.kalilecommerce.product.mapper

import com.kalilecommerce.product.domain.Product
import com.kalilecommerce.product.dto.ProductDTO

fun Product.toDTO() = ProductDTO(
    id = this.id,
    name = this.name,
    price = this.price,
    images = this.images
)

fun ProductDTO.toEntity() = Product(
    name = this.name,
    price = this.price,
    images = this.images ?: emptyList()
)
