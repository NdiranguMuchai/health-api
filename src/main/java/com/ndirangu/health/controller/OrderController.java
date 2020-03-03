package com.ndirangu.health.controller;
import com.ndirangu.health.model.Order;
import com.ndirangu.health.service.OrderService;
import com.ndirangu.health.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@Api(tags = {"Order"})
public class OrderController {
    private OrderService orderService;
    private PatientService patientService;

    public OrderController(OrderService orderService, PatientService patientService) {
        this.orderService = orderService;
        this.patientService = patientService;
    }
    @GetMapping({"", "/", "/list"})
    @ApiOperation(value = "Returns a list of all orders available")
    public @ResponseBody  Page<Order> list(Pageable pageable){
        return orderService.list(pageable);
    }
    @GetMapping("/{orderId}")
    @ApiOperation(value = "Finds an order based on its id")
    public @ResponseBody Optional<Order> findOne(@PathVariable UUID orderId) throws Exception{
        orderService.findOne(orderId).orElseThrow(()-> new Exception("Order with id "+orderId+" not found"));
        return orderService.findOne(orderId);
    }
    @PostMapping("/{patientId}/create")
    @ApiOperation(value = "creates an order")
    public @ResponseBody UUID create(
            @ApiParam(value = "Order object store in database table", required = true)
            @RequestBody Order order,
            @PathVariable UUID patientId) throws Exception{
        return patientService.findOne(patientId).map(patient -> {
            order.setPatient(patient);
            return orderService.create(order);
        }).orElseThrow(() -> new Exception("patient with id"+patientId+"not found"));
    }

    @ApiOperation(value = "updates an order given their id")
    @PutMapping("/{orderId}")
    public @ResponseBody UUID update(@RequestBody Order order, @PathVariable UUID orderId) throws Exception{
        orderService.findOne(orderId).orElseThrow(()-> new Exception("patient with id "+orderId+" not found"));
        order.setId(orderId);
        return orderService.update(order);

    }
}
