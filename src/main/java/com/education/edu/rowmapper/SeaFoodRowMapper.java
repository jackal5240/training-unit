package com.education.edu.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.education.edu.model.Do.SeaFoodDo;

public class SeaFoodRowMapper implements RowMapper<SeaFoodDo> {

    @Override
    public SeaFoodDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SeaFoodDo seaFoodDo = new SeaFoodDo();
        seaFoodDo.setName(rs.getString("name"));
        seaFoodDo.setPrice(rs.getInt("price"));
        return seaFoodDo;
    }

}
