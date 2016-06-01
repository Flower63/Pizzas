package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.ifrastructure.jdbc.PizzaMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import javax.sql.DataSource;

/**
 * Created by Dennis
 *
 * on 4/17/2016.
 */
@Deprecated
public class SpringJDBCPizzaRepository implements PizzaRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PizzaMapper pizzaMapper;

    public SpringJDBCPizzaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.pizzaMapper = new PizzaMapper();
    }

    public Pizza getPizzaByID(Integer id) {
        String sql = "SELECT * FROM pizzas WHERE id = ?";
        Pizza pizza = jdbcTemplate.queryForObject(sql, new Object[] {id}, pizzaMapper);

        return pizza;
    }

    public int savePizza(Pizza pizza) {
        return 0;
    }

    public boolean deletePizza(Pizza pizza) {
        return false;
    }

    public boolean updatePizza(Pizza pizza) {
        return false;
    }

	public List<Pizza> getAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pizza> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pizza> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Pizza> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Pizza> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pizza entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Pizza> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
