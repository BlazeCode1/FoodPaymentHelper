package org.example.foodpaymenthelper;



import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class FoodMenu {
    private String Id;
    private String name;
    private int storage;
    private int orders;
    private double price;


}
