package com.kalilecommerce.product.domain
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = [JoinColumn(name = "product_id")])
    @Column(name = "image")
    var images: List<String> = emptyList()
)
