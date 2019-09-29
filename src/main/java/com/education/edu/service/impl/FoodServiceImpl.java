package com.education.edu.service.impl;

import com.education.edu.dao.FoodDao;
import com.education.edu.model.Bo.FoodInputBo;
import com.education.edu.model.Bo.FoodOutputBo;
import com.education.edu.model.Do.MeatDo;
import com.education.edu.model.Do.SeaFoodDo;
import com.education.edu.service.FoodService;

public class FoodServiceImpl implements FoodService {
    private FoodDao foodDao;

    @Override
    public FoodOutputBo getFood(FoodInputBo foodInputBo) {
        FoodOutputBo foodOutputBo = new FoodOutputBo();
        if ("seaFood".equals(foodInputBo.getFoodType())) {
            SeaFoodDo queryResultMap = foodDao.getSeaFood(foodInputBo.getFoodType());
            foodOutputBo.setName(queryResultMap.getName());
            foodOutputBo.setPrice(queryResultMap.getPrice());
        } else if ("meat".equals(foodInputBo.getFoodType())) {
            MeatDo queryResultMap = foodDao.getMeat(foodInputBo.getFoodType());
            foodOutputBo.setName(queryResultMap.getName());
            foodOutputBo.setPrice(queryResultMap.getPrice());
        }
        
        return foodOutputBo;
    }

    public FoodDao getFoodDao() {
        return foodDao;
    }

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

}
