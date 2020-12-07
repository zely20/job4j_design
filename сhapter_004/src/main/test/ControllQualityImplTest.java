import org.junit.Test;
import ru.job4j.lsp.*;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ControllQualityImplTest {

    @Test
    public void addFoodToWarehouseTest(){
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        Food milk = new Milk("Milk",
                new Date(System.currentTimeMillis()+ 100000), new Date(1607337640000L), 100, 20);
        ControllQualityStrategy controllQualityStrategy = new ControllQualityImpl();
        controllQualityStrategy.addStore(warehouse);
        controllQualityStrategy.addStore(shop);
        controllQualityStrategy.addStore(trash);
        controllQualityStrategy.addFood(milk);
        assertThat(warehouse.getItems().size(), is(1));
    }

    @Test
    public void addFoodToShopTest(){
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        Food milk = new Milk("Milk",
                new Date(System.currentTimeMillis()+ 1000000), new Date(1607337640000L), 100, 20);
        ControllQualityStrategy controllQualityStrategy = new ControllQualityImpl();
        controllQualityStrategy.addStore(warehouse);
        controllQualityStrategy.addStore(shop);
        controllQualityStrategy.addStore(trash);
        controllQualityStrategy.addFood(milk);
        assertThat(shop.getItems().size(), is(1));
    }

    @Test
    public void addFoodToTrashTest(){
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        Food milk = new Milk("Milk",
                new Date(System.currentTimeMillis()+ 10000000), new Date(1607337640000L), 100, 20);
        ControllQualityStrategy controllQualityStrategy = new ControllQualityImpl();
        controllQualityStrategy.addStore(warehouse);
        controllQualityStrategy.addStore(shop);
        controllQualityStrategy.addStore(trash);
        controllQualityStrategy.addFood(milk);
        assertThat(trash.getItems().size(), is(1));
    }
}
