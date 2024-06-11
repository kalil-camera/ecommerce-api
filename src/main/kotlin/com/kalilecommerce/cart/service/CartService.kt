package com.kalilecommerce.cart.service

import com.kalilecommerce.cart.domain.Cart
import com.kalilecommerce.cart.dto.CartDTO
import com.kalilecommerce.cart.mapper.toDTO
import com.kalilecommerce.cart.repository.CartRepository
import com.kalilecommerce.product.repository.ProductRepository
import com.kalilecommerce.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(
    private val cartRepository: CartRepository,
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository
) {

    @Transactional(readOnly = true)
    fun getCartByUserId(userId: Long): CartDTO {
        val cart = cartRepository.findByUserId(userId) ?: throw RuntimeException("Cart not found")
        return cart.toDTO()
    }

    @Transactional
    fun addProductToCart(userId: Long, productId: Long): CartDTO {
        val user = userRepository.findById(userId).orElseThrow { RuntimeException("User not found") }
        val product = productRepository.findById(productId).orElseThrow { RuntimeException("Product not found") }
        val cart = cartRepository.findByUserId(userId) ?: Cart(user = user).apply { cartRepository.save(this) }
        cart.products += product
        return cartRepository.save(cart).toDTO()
    }

    @Transactional
    fun removeProductFromCart(userId: Long, productId: Long): CartDTO {
        val cart = cartRepository.findByUserId(userId) ?: throw RuntimeException("Cart not found")
        val product = productRepository.findById(productId).orElseThrow { RuntimeException("Product not found") }
        cart.products = cart.products.filterNot { it.id == product.id }
        return cartRepository.save(cart).toDTO()
    }

    @Transactional
    fun clearCart(userId: Long) {
        val cart = cartRepository.findByUserId(userId) ?: throw RuntimeException("Cart not found")
        cart.products = emptyList()
        cartRepository.save(cart)
    }
}
