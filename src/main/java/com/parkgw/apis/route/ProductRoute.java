package com.parkgw.apis.route;

import com.parkgw.apis.model.Product;
import com.parkgw.apis.model.Sale;
import  com.parkgw.apis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    };

    @GetMapping("")
    @ResponseBody
    public List<Product> getProducts() {
        return this.productService.findAll();
    };

    @GetMapping("/{productId}")
    @ResponseBody
    public Product getProduct(@PathVariable(value = "productId") String productId) throws Exception{
        return this.productService.find(Integer.parseInt(productId));
    };

    @GetMapping("/initialize")
    public void initializers() {
        this.productService.initializeProducts();
    };
};