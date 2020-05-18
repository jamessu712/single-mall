package com.jamessu712.mall.web.api.dto;

import com.jamessu712.mall.common.api.BaseResponse;
//import com.jamessu712.mall.product.dto.ProductDTO;
import com.jamessu712.mall.web.api.dto.ProductDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GenericProductResponse extends BaseResponse {
    private ProductDTO productDTO;
}
