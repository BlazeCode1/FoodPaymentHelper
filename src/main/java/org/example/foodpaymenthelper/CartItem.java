package org.example.foodpaymenthelper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class CartItem {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
}
