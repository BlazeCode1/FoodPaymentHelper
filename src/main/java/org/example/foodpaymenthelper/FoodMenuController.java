package org.example.foodpaymenthelper;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class FoodMenuController {
        ArrayList<FoodMenu> menu = new ArrayList<>();




    @GetMapping("/init/products")
    public ResponseEntity<FoodMenu> initMenu(){
        menu.add(new FoodMenu("0","Espresso", 80, 50,12));
        menu.add(new FoodMenu("1","Cappuccino", 100, 40,9));
        menu.add(new FoodMenu("2","Mocha", 60, 20,14));
        menu.add(new FoodMenu("3","Cold Brew", 70, 15,9));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create/menu")
    public ResponseEntity<FoodMenu> addToMenu(@RequestBody FoodMenu newMenu){

        menu.add(newMenu);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/menu")
    public ArrayList<FoodMenu> showMenu(){
        return menu;
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<FoodMenu> findById(@PathVariable("id" )String id){
        for (FoodMenu d:menu){
            if(d.getId().equals(id)){
                return ResponseEntity.ok(d);
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    ArrayList<CartItem> cart = new ArrayList<>();

    @GetMapping("/cart")
    public ResponseEntity<ArrayList<CartItem>> getCart(){
        if(cart.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/cart/add/{id}")
    public ResponseEntity<String> addToCart(@PathVariable String id){
        for (FoodMenu item : menu){
            if(id.equals(item.getId()) && item.getStorage() > 0){
                cart.add(new CartItem(item.getId(), item.getName(),1,item.getPrice()));
                item.setStorage(item.getStorage() - 1);
                return ResponseEntity.ok("Item "+item.getName()+" Added");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or out of stock");
    }

    @PostMapping("/cart/remove/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable String id) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProductId().equals(id)) {
                CartItem removedItem = cart.get(i);
                cart.remove(i);
                return ResponseEntity.ok("Removed " + removedItem.getProductName() + " from cart.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not in cart.");
    }

}
