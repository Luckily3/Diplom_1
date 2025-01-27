import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
  private Burger burger;

  @Mock
  Bun bun;

  @Mock
  private Ingredient ingredient, ingredient2;

  @Before
  public void createBurger() {
    burger = new Burger();
  }

  @Test
  public void testSetBun() {
    burger.setBuns(bun);
    Assert.assertEquals(bun.getName(), burger.bun.getName());
  }

  @Test
  public void testAddIngredient() {
    burger.addIngredient(ingredient);
    assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void testRemoveIngredient() {
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient2);
    assertEquals(2, burger.ingredients.size());

    burger.removeIngredient(0);
    assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void testMoveIngredient() {
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient2);

    burger.moveIngredient(1, 0);

    assertEquals(ingredient2, burger.ingredients.get(0));
    assertEquals(Arrays.asList(ingredient2, ingredient), burger.ingredients);
  }

  @Test
  public void testGetPrice() {
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient2);

    when(bun.getPrice()).thenReturn(10F);
    when(ingredient.getPrice()).thenReturn(5F);
    when(ingredient2.getPrice()).thenReturn(13F);

    float expectedPrice = (10F * 2) + 5F + 13F;
    assertEquals(expectedPrice, burger.getPrice(), 0);
  }

  @Test
  public void testGetReceipt() {
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient2);

    when(bun.getName()).thenReturn("bun");
    when(ingredient.getName()).thenReturn("chilli");
    when(ingredient2.getName()).thenReturn("chicken cutlet");
    when(bun.getPrice()).thenReturn(10F);
    when(ingredient.getPrice()).thenReturn(5F);
    when(ingredient2.getPrice()).thenReturn(13F);
    when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
    when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

    String expectedReceipt = "(==== bun ====)\r\n" +
            "= sauce chilli =\r\n" +
            "= filling chicken cutlet =\r\n" +
            "(==== bun ====)\r\n" +
            "\r\n" +
            "Price: 38,000000\r\n";
    assertEquals(expectedReceipt, burger.getReceipt());
  }
}
