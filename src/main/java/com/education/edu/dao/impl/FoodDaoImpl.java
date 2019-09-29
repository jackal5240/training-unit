package com.education.edu.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.education.edu.dao.FoodDao;
import com.education.edu.model.Do.MeatDo;
import com.education.edu.model.Do.SeaFoodDo;
import com.education.edu.rowmapper.MeatRowMapper;
import com.education.edu.rowmapper.SeaFoodRowMapper;

public class FoodDaoImpl implements FoodDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall getSeaFoodJdbcCall;
    private SimpleJdbcCall getMeatJdbcCall;

    @PostConstruct
    public void init() {
        getSeaFoodJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PG_HW_FOOD_20225")
                .withProcedureName("SP_GET_FOOD_INFO")
                .returningResultSet("O_OUT", new SeaFoodRowMapper());
        getMeatJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PG_HW_FOOD_20225")
                .withProcedureName("SP_GET_FOOD_INFO")
                .returningResultSet("O_OUT", new MeatRowMapper());
    }

    @Override
    public SeaFoodDo getSeaFood(String foodType) {
        MapSqlParameterSource in = new MapSqlParameterSource()
                .addValue("i_food_type", foodType);

        Map<String, Object> out = getSeaFoodJdbcCall.execute(in);
        
        return ((List<SeaFoodDo>) out.get("O_OUT")).get(0);
    }

    @Override
    public MeatDo getMeat(String foodType) {
        MapSqlParameterSource in = new MapSqlParameterSource()
                .addValue("i_food_type", foodType);

        Map<String, Object> out = getMeatJdbcCall.execute(in);
        
        return ((List<MeatDo>) out.get("O_OUT")).get(0);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
