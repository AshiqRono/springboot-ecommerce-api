package com.ashiqulhoque.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDTO {
    private List<ProductInfoDTO> productInfoDTOList;
}
