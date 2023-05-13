package net.muhammadsaad.rest.mapper;

import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.model.ProductModel;

public class ProductMapper {
    private static ProductModel toProductModel(Product product) {
        ProductModel productModel = new ProductModel();

        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setPrice(product.getPrice());
        productModel.setDescription(product.getDescription());
        productModel.setImageUrl(product.getImageUrl());
        productModel.setIsAvailable(product.getIsAvailable());

        return productModel;
    }

    public static Product toEntity(ProductModel productModel) {
        Product product = new Product();

        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());

        /*
        product.setDescription(productModel.getDescription());
        product.setImageUrl(productModel.getImageUrl());
        product.setIsAvailable(productModel.getIsAvailable());
        */

        return product;
    }
}
