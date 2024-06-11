package com.kalilecommerce.product.controller

import com.kalilecommerce.product.dto.ProductDTO
import com.kalilecommerce.product.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(): List<ProductDTO> = productService.getAllProducts()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<ProductDTO> =
        ResponseEntity.ok(productService.getProductById(id))

    @PostMapping
    fun createProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> =
        ResponseEntity.ok(productService.createProduct(productDTO))

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> =
        ResponseEntity.ok(productService.updateProduct(id, productDTO))

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity.noContent().build()
    }
}
