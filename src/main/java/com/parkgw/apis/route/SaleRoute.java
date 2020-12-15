package com.parkgw.apis.route;

import com.parkgw.apis.model.Sale;
import com.parkgw.apis.model.User;
import com.parkgw.apis.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sale")
public class SaleRoute {
    private final SaleService saleService;

    @Autowired
    public SaleRoute(SaleService saleService) {
        this.saleService = saleService;
    };

    @GetMapping("")
    @ResponseBody
    public List<Sale> getSales() {
        return this.saleService.findAll();
    };

    @GetMapping("/{saleId}")
    @ResponseBody
    public Sale getSale(@PathVariable(value = "saleId") String saleId) throws Exception{
        return this.saleService.find(Integer.parseInt(saleId));
    };

    @GetMapping("/initialize")
    public void initializers() {
        this.saleService.initializeSales();
    };
}