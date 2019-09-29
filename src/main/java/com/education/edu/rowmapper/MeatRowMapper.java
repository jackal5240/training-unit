package com.education.edu.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.education.edu.model.Do.MeatDo;

public class MeatRowMapper implements RowMapper<MeatDo> {

    @Override
    public MeatDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        MeatDo meatDo = new MeatDo();
        meatDo.setName(rs.getString("name"));
        meatDo.setPrice(rs.getInt("price"));
        return meatDo;
    }

}
