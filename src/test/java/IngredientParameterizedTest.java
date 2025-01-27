import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
  private final Ingredient ingredient;
  private final IngredientType ingredientType;
  private final String name;
  private final float price;

  public IngredientParameterizedTest(IngredientType ingredientType, String name, float price) {
    this.ingredient = new Ingredient(ingredientType, name, price);
    this.ingredientType = ingredientType;
    this.name = name;
    this.price = price;
  }

  @Parameterized.Parameters
  public static Object[][] getCredentials() {
    return new Object[][]{
            {IngredientType.SAUCE, "Фирменный", 90f},
            {IngredientType.FILLING, "Куриная котлета", 422f},
    };
  }

  @Test
  public void testGetType() {
    Assert.assertEquals(ingredientType, ingredient.getType());
  }
  @Test
  public void testGetName() {
    Assert.assertEquals(name, ingredient.getName());
  }

  @Test
  public void testGetPrice() {
    Assert.assertEquals(price, ingredient.getPrice(), 0);
  }
}
