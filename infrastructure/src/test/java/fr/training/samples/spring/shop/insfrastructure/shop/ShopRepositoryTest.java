package fr.training.samples.spring.shop.insfrastructure.shop;

import static org.assertj.core.api.Assertions.assertThat;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.shop.Shop;
import fr.training.samples.spring.shop.domain.shop.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void shopId_should_return_itemList(){
        //Given
        String shopId="123e4567-e89b-42d3-a456-55664244333";
        Shop shop= shopRepository.findById(shopId);
        //When
        List<Item> itemList=shop.getListItem();
        //Then
        assertThat(itemList).size().isEqualTo(3);
    }

}
