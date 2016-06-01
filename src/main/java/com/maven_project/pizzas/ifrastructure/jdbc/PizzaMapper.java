package com.maven_project.pizzas.ifrastructure.jdbc;

import org.springframework.jdbc.core.RowMapper;

import com.maven_project.pizzas.domain.Pizza;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dennis
 *
 * on 4/18/2016.
 */
public class PizzaMapper implements RowMapper<Pizza> {

    @Override
    public Pizza mapRow(ResultSet resultSet, int i) throws SQLException {
        int pizzaID = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Pizza.Type type = Pizza.Type.valueOf(resultSet.getString("type"));
        double cost = resultSet.getDouble("cost");
        return new Pizza(pizzaID, name, type, cost);
    }
}
