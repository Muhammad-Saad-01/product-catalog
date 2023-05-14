package net.muhammadsaad.rest.mapper;

import lombok.extern.slf4j.Slf4j;
import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.model.ProductModel;
import net.muhammadsaad.rest.repository.CategoryRepository;

@Slf4j
public class ProductMapper {
    public static ProductModel toModel(Product product) {
        ProductModel productModel = new ProductModel();
        /*
         * what if product == null
         * */


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

        if (productModel.getQuantity() == 0) {
            productModel.setQuantity(1);
        }
        if (productModel.getDescription() == null) {
            productModel.setDescription("");
        }
        if (productModel.getImageUrl() == null) {
            productModel.setImageUrl("https://storage.googleapis.com/proudcity/mebanenc/uploads/2021/03/placeholder-image.png");
        }


        log.info("Category :{}", productModel.getCategory());
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());


        product.setDescription(productModel.getDescription());
        product.setImageUrl(productModel.getImageUrl());
        product.setIsAvailable(productModel.getIsAvailable());
        product.setCategory(CategoryMapper.toEntity(productModel.getCategory()));
        product.setQuantity(productModel.getQuantity());
        return product;
    }
}
