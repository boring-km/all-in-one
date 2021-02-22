package com.aio.allinone.product;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@Api(value = "ProductController")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "정상 호출"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/product/{product}")
    public ProductResponse getProductList(
            @ApiParam(value = "제품 구분", required = true, example = "VehicleProduct")
            @PathVariable String product) {
        return productService.getProductList(product);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "정상 호출"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/product/{product}/{sellerId}")
    public ProductResponse findProductBy(
            @ApiParam(value = "제품 구분", required = true, example = "VehicleProduct")
            @PathVariable String product,
            @ApiParam(value = "판매자 ID", required = true, example = "kmjin")
            @PathVariable String sellerId) {
        return productService.findProductBy(product, sellerId);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "정상 호출"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @PutMapping("/product/register")
    public ProductResponse registerProduct(
            @ApiParam(value = "등록할 제품 정보", required = true)
            @RequestBody LinkedHashMap<String, Object> targetProduct) {
        return productService.registerProduct(targetProduct);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "정상 호출"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @PatchMapping("/product/update")
    public ProductResponse updateProduct(
            @ApiParam(value = "수정할 제품 정보", required = true)
            @RequestBody LinkedHashMap<String, Object> targetProduct) {
        return productService.updateProduct(targetProduct);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "정상 호출"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @PatchMapping("/product/finish/{product}/{id}")
    public ProductResponse finishProduct(
            @ApiParam(value = "마감 제품 구분", required = true)
            @PathVariable String product,
            @ApiParam(value = "제품 이용 마감 처리할 id", required = true)
            @PathVariable String id) {
        return productService.finishProduct(product, id);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "정상 호출"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @DeleteMapping("/product/delete/{product}/{id}")
    public ProductResponse deleteProduct(
            @ApiParam(value = "제품 구분", required = true)
            @PathVariable String product,
            @ApiParam(value = "제품 취소할 id", required = true)
            @PathVariable String id) {
        return productService.deleteProduct(product, id);
    }
}
