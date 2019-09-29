package com.education.edu.service;

import com.education.edu.model.Bo.FoodInputBo;
import com.education.edu.model.Bo.FoodOutputBo;

public interface FoodService {
    public FoodOutputBo getFood(FoodInputBo foodInputBo);
    
}
