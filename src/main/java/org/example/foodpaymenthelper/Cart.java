package org.example.foodpaymenthelper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    private String cartId;
    private ArrayList<CartItem> items;
    private int totalQuantity;
    private double totalPrice;

}
