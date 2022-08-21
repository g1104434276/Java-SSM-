package com.glk.spring5.Myspring.entity;

import com.glk.spring5.Myspring.Component;
import com.glk.spring5.Myspring.Value;
import lombok.Data;

@Component("myOrder")
@Data
public class Order {
    @Value("xxx123")
    private String orderId;
    @Value("100.2")
    private Float price;
}
