package com.kalilecommerce.user.mapper

import com.kalilecommerce.user.domain.User
import com.kalilecommerce.user.dto.UserDTO

fun User.toDTO() = UserDTO(
    id = this.id,
    username = this.username,
    password = "",
    role = this.role
)

fun UserDTO.toEntity(encodedPassword: String) = User(
    username = this.username,
    password = encodedPassword,
    role = this.role
)
