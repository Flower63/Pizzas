package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.Pizza;
import com.maven_project.pizzas.ifrastructure.jdbc.PizzaMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Dennis
 *
 * on 4/17/2016.
 */
public class SpringJDBCPizzaRepository implements PizzaRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PizzaMapper pizzaMapper;

    public SpringJDBCPizzaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.pizzaMapper = new PizzaMapper();
    }

    @Override
    public void cookPizzas() {

    }

    @Override
    public Pizza getPizzaByID(Integer id) {
        String sql = "SELECT * FROM pizzas WHERE id = ?";
        Pizza pizza = jdbcTemplate.queryForObject(sql, new Object[] {id}, pizzaMapper);

        return pizza;
    }
}
