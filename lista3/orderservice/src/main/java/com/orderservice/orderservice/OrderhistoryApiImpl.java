//package com.orderservice.orderservice;
//
//import com.orderservice.api.OrdershistoryApi;
//import com.orderservice.model.OrderHistory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class OrderhistoryApiImpl implements OrdershistoryApi {
//
//    @Value("${openapi.openAPIDefinition.base-path:}")
//    private String path;
//
//    @Override
//    public ResponseEntity<List<OrderHistory>> getAll() {
//        System.out.println(path);
//        System.out.println("getAll");
//        return ResponseEntity.ok(new ArrayList<>(){});
//    }
//    @Override
//    public ResponseEntity<OrderHistory> get(Integer id) {
//        System.out.println("get");
//        var elem = new OrderHistory();
//        elem.setId(Long.valueOf(id));
//        return ResponseEntity.ok(elem);
//    }
//}