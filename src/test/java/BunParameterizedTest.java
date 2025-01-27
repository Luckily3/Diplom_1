import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
  private final Bun bun;
  private final String name;
  private final float price;

  public BunParameterizedTest(String name, float price) {
    this.name = name;
    this.price = price;
    this.bun = new Bun(name, price);
  }

  @Parameterized.Parameters
  public static Object[][] getCredentials() {
    return new Object[][]{
            {"Флюоресцентная", 988f},
            {"Краторная", 1255f},
            {"Тестовая", 1917f},
    };
  }

  @Test
  public void testGetName() {
    Assert.assertEquals(name, bun.getName());
  }

  @Test
  public void testGetPrice() {
    Assert.assertEquals(price, bun.getPrice(), 0);
  }
}
