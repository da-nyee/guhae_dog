package com.example.demo.Item.value;


import com.example.demo.Item.Item;
import org.springframework.context.annotation.Description;

import javax.persistence.Entity;

@Entity
@Description("S")
public class senitation extends Item {

    private String value; //밴드 , 먹는약, 바르는약
    private String deadline; //유통기한

}