package com.kalilecommerce.user.service

import com.kalilecommerce.user.domain.User
import com.kalilecommerce.user.dto.UserDTO
import com.kalilecommerce.user.mapper.toDTO
import com.kalilecommerce.user.mapper.toEntity
import com.kalilecommerce.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional(readOnly = true)
    fun getAllUsers(): List<UserDTO> =
        userRepository.findAll().map(User::toDTO)

    @Transactional
    fun createUser(userDTO: UserDTO): UserDTO {
        val encodedPassword = passwordEncoder.encode(userDTO.password)
        val user = userRepository.save(userDTO.toEntity(encodedPassword))
        return user.toDTO()
    }

    @Transactional
    fun updateUser(id: Long, userDTO: UserDTO): UserDTO {
        val existingUser = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        val encodedPassword = passwordEncoder.encode(userDTO.password)
        existingUser.apply {
            username = userDTO.username
            password = encodedPassword
            role = userDTO.role
        }
        return userRepository.save(existingUser).toDTO()
    }

    @Transactional
    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    fun getUserById(id: Long): UserDTO =
        userRepository.findById(id).orElseThrow { RuntimeException("User not found") }.toDTO()
}
