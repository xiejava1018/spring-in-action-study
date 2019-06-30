package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
