package com.orderhistory.orderhistory.controllers;

import com.orderhistory.orderhistory.models.OrderHistory;
import com.orderhistory.orderhistory.models.OrderHistoryModel;
import com.orderhistory.orderhistory.services.OrderHistoryModelAssembler;
import com.orderhistory.orderhistory.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ordershistory")
@RestController
public class OrderController {
    @Autowired
    OrderService service;

    @Autowired
    private OrderHistoryModelAssembler orderHistoryModelAssembler;

    @Autowired
    private PagedResourcesAssembler<OrderHistory> pagedResourcesAssembler;

    @GetMapping()
    private List<OrderHistory> getAll() {
        return service.getAll();
    }

    @GetMapping("/forConsumerName")
    public List<OrderHistory> getAllFiltered(@RequestParam(defaultValue = "") String consumerName) {
        return service.getAllForConsumer(consumerName);
    }

    @GetMapping("/forConsumerNamePagination")
    public PagedModel<OrderHistoryModel> fetchCustomersWithPagination(@RequestParam(defaultValue = "") String consumerName,
                                                                      @RequestParam(defaultValue = "0") int pageNumber,
                                                                      @RequestParam(defaultValue = "30") int size) {
        var page = service.getAllForConsumerPagination(consumerName, pageNumber, size);
        return pagedResourcesAssembler.toModel(page, orderHistoryModelAssembler);
    }

    @GetMapping("/{id}")
    private OrderHistory get(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    public long save(@RequestBody OrderHistory elem) {
        service.saveOrUpdate(elem);
        return elem.getId();
    }
}
