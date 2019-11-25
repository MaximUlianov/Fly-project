package com.bsuir.tritpo.fly.controllers;


import com.bsuir.tritpo.fly.models.DTOs.ExtrasDTO;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.models.DTOs.SalesOrderDTO;
import com.bsuir.tritpo.fly.services.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/salesOrder")
public class SalesOrderController {

    private SalesOrderService salesOrderService;

    @Autowired
    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @PostMapping(value = "/buyTicket")
    @ResponseBody
    public ResponseEntity buyTicket(@RequestBody FlightDTO ticket) {
        return ResponseEntity.ok(salesOrderService.buyTicket(ticket));
    }


    @PostMapping(value = "/buyExtras")
    @ResponseBody
    public ResponseEntity buyExtras(@RequestBody ExtrasDTO extras) {
        return ResponseEntity.ok(salesOrderService.buyExtras(extras));
    }

    @GetMapping(value = "/getSalesOrder")
    @ResponseBody
    public ResponseEntity getSalesOrder() {
        SalesOrderDTO salesOrderDTO = salesOrderService.getActiveSalesOrder();
        if (salesOrderDTO != null) {
            return ResponseEntity.ok(salesOrderDTO);
        }
        return ResponseEntity.ok("ok");
    }

}
