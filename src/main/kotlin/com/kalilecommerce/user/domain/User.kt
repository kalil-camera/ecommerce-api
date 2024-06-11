package com.kalilecommerce.user.domain

import com.kalilecommerce.user.enumeration.UserRole
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    @NotNull
    var username: String,

    @Column(nullable = false)
    @NotNull
    var password: String,

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    var role: UserRole
)

