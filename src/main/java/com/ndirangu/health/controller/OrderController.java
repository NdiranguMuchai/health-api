package com.ndirangu.health.controller;
import com.ndirangu.health.model.Order;
import com.ndirangu.health.service.OrderService;
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

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
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
    @PostMapping("/create")
    @ApiOperation(value = "creates an order")
    public @ResponseBody UUID create(
            @ApiParam(value = "Order object store in database table", required = true)
            @RequestBody Order order){
        return orderService.create(order);
    }

    @ApiOperation(value = "updates an order given their id")
    @PutMapping("/{orderId}")
    public @ResponseBody UUID update(@RequestBody Order order, @PathVariable UUID orderId) throws Exception{
        orderService.findOne(orderId).orElseThrow(()-> new Exception("patient with id "+orderId+" not found"));
        order.setId(orderId);
        return orderService.update(order);

    }
}
