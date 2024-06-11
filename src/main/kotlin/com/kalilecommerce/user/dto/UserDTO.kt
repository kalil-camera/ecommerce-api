package com.kalilecommerce.user.dto

import com.kalilecommerce.user.enumeration.UserRole

data class UserDTO(
    val id: Long?,
    val username: String,
    val password: String,
    val role: UserRole
)
