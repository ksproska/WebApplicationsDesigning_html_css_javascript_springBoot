package com.orderhistory.orderhistory.services;

import com.orderhistory.orderhistory.controllers.OrderController;
import com.orderhistory.orderhistory.models.OrderHistory;
import com.orderhistory.orderhistory.models.OrderHistoryModel;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryModelAssembler extends RepresentationModelAssemblerSupport<OrderHistory, OrderHistoryModel> {
    public OrderHistoryModelAssembler() {
        super(OrderController.class, OrderHistoryModel.class);
    }

    @Override
    public OrderHistoryModel toModel(OrderHistory entity) {
        var model = new OrderHistoryModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }
}
