package com.kalilecommerce.product.service

import com.kalilecommerce.product.domain.Product
import com.kalilecommerce.product.dto.ProductDTO
import com.kalilecommerce.product.mapper.toDTO
import com.kalilecommerce.product.mapper.toEntity
import com.kalilecommerce.product.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val productRepository: ProductRepository) {

    @Transactional(readOnly = true)
    fun getAllProducts(): List<ProductDTO> =
        productRepository.findAll().map(Product::toDTO)

    @Transactional
    fun createProduct(productDTO: ProductDTO): ProductDTO {
        val product = productRepository.save(productDTO.toEntity())
        return product.toDTO()
    }

    @Transactional
    fun updateProduct(id: Long, productDTO: ProductDTO): ProductDTO {
        val existingProduct = productRepository.findById(id).orElseThrow { RuntimeException("Product not found") }
        existingProduct.name = productDTO.name
        existingProduct.price = productDTO.price
        existingProduct.images = productDTO.images ?: emptyList()
        return productRepository.save(existingProduct).toDTO()
    }

    @Transactional
    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    fun getProductById(id: Long): ProductDTO =
        productRepository.findById(id).orElseThrow { RuntimeException("Product not found") }.toDTO()
}
