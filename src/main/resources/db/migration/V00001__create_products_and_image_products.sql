-- Create product table
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(19, 2) NOT NULL
);

-- Create product_images table
CREATE TABLE product_images (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    image VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);

-- Sample Data
INSERT INTO product (name, price) VALUES ('Product 1', 99.99);
INSERT INTO product (name, price) VALUES ('Product 2', 49.99);

INSERT INTO product_images (product_id, image) VALUES (1, 'image1.jpg');
INSERT INTO product_images (product_id, image) VALUES (1, 'image2.jpg');
INSERT INTO product_images (product_id, image) VALUES (2, 'image3.jpg');
