package com.kalilecommerce.cart.mapper

import com.kalilecommerce.cart.domain.Cart
import com.kalilecommerce.cart.dto.CartDTO
import com.kalilecommerce.user.domain.User
import com.kalilecommerce.product.domain.Product

fun Cart.toDTO() = CartDTO(
    id = this.id,
    userId = this.user.id,
    productIds = this.products.map(Product::id)
)

fun CartDTO.toEntity(user: User, products: List<Product>) = Cart(
    user = user,
    products = products
)
