package tacos.data;

import com.example.demo.Ingredient;

public interface IngredientRepository {
	
	Iterable<Ingredient> findall();
	
	Ingredient findOne(String id);
	
	Ingredient save(Ingredient ingredient);

}
