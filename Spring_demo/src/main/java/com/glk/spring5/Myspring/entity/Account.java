package com.glk.spring5.Myspring.entity;

import com.glk.spring5.Myspring.Autowired;
import com.glk.spring5.Myspring.Component;
import com.glk.spring5.Myspring.Qualifier;
import com.glk.spring5.Myspring.Value;
import lombok.Data;

@Component
@Data
public class Account {
    @Value("1")
    private Integer id;
    @Value("张三")
    private String name;
    @Value("22")
    private Integer age;

    @Autowired
    @Qualifier("myOrder")
    private Order order;
}
