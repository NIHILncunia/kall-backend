package com.project.kall.controller;


import com.project.kall.dto.CartDTO;
import com.project.kall.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController {

    @Autowired
    CartService cartService;
    
    @GetMapping("")
    public List<CartDTO> getCarts() {
        return cartService.getCarts();
    }

//    -----------------------------------userId 별 카트 목록 --------------------------------------------------------
    @GetMapping("/user/{userId}") //id=user_id
    public List<CartDTO> cartList(@PathVariable String userId) {
        return cartService.cartList(userId);
    }

    @PostMapping("")
    public void cartAdd(@RequestBody List<CartDTO> cartDTOList) {
        cartService.cartAdd(cartDTOList);
    }
    
    @DeleteMapping("")
    public Map<String, Integer> deleteCarts(@RequestBody List<Integer> ids) {
        return cartService.deleteCarts(ids);
    }
}
