package com.education.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.education.edu.model.Bo.FoodInputBo;
import com.education.edu.model.Bo.FoodOutputBo;
import com.education.edu.model.Dto.FoodDto;
import com.education.edu.model.Dto.FoodRelayDto;
import com.education.edu.service.FoodService;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;
    
    @PostMapping(value = "/getFood", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FoodRelayDto getFood(@RequestBody FoodDto foodDto) {
        FoodInputBo foodInputBo = new FoodInputBo();
        foodInputBo.setFoodType(foodDto.getFoodType());
        
        FoodOutputBo foodOutputBo = foodService.getFood(foodInputBo);
        
        FoodRelayDto foodRelayDto = new FoodRelayDto();
        foodRelayDto.setName(foodOutputBo.getName());
        foodRelayDto.setPrice(foodOutputBo.getPrice());
        
        return foodRelayDto;
    }
    
}
