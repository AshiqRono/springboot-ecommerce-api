package com.ashiqulhoque.ecommerce_api.service;

import com.ashiqulhoque.ecommerce_api.domain.Product;
import com.ashiqulhoque.ecommerce_api.domain.Wishlist;
import com.ashiqulhoque.ecommerce_api.dto.ProductInfoDTO;
import com.ashiqulhoque.ecommerce_api.dto.WishlistDTO;
import com.ashiqulhoque.ecommerce_api.repository.ProductRepository;
import com.ashiqulhoque.ecommerce_api.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;

    public WishlistService(WishlistRepository wishlistRepository,  ProductRepository productRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
    }

    public WishlistDTO getByCustomerId(Long custId) {
        Wishlist wishlist = wishlistRepository.findByCustIdAndRetiredDateIsNull(custId);

        Set<Product> productList = productRepository.findByIdIn(wishlist.getProductIds());

        List<ProductInfoDTO> productInfoDTOList = productList.stream()
                .map(p -> new ProductInfoDTO(p.getName(), p.getDescription(), p.getPrice()))
                .toList();

        return new WishlistDTO(productInfoDTOList);
    }
}
