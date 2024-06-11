package com.kalilecommerce.cart.domain

import jakarta.persistence.*
import com.kalilecommerce.user.domain.User
import com.kalilecommerce.product.domain.Product

@Entity
@Table(name = "cart")
data class Cart(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToMany
    @JoinTable(
        name = "cart_products",
        joinColumns = [JoinColumn(name = "cart_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products: List<Product> = mutableListOf()
)
