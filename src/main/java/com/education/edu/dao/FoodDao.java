package com.education.edu.dao;

import com.education.edu.model.Do.MeatDo;
import com.education.edu.model.Do.SeaFoodDo;

public interface FoodDao {
    public SeaFoodDo getSeaFood(String foodType);
    public MeatDo getMeat(String foodType);
    
}
