import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

  @Test
  public void testIngredientType() {
    Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
  }

  @Test
  public void testIngredientTypeCount() {
    Assert.assertEquals(IngredientType.values().length, 2);
  }
}
