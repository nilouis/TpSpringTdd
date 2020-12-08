package fr.training.samples.spring.shop.application.shop;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.shop.Shop;
import fr.training.samples.spring.shop.domain.shop.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShopServiceImpl.class})
public class ShopServiceTest {

    @Autowired
    private ShopService shopService;

    @MockBean
    private ShopRepository shopRepositoryMock;


    private Shop getShop() {
        Shop monShop=new Shop();
//        monShop.setId();
        monShop.setName("Mon Shop de test");
        monShop.setListItem(getList());
        return monShop;
    }
    private List<Item> getList(){
        List<Item> maList = new ArrayList<>();
        int nbItem=0;
        while(nbItem<5){
            maList.add(new Item("mocked item n°" + nbItem, nbItem * 10));
            nbItem ++;
        }
        return maList;
    }

    @Test
    public void get_catalog_should_return_catalog_of_given_shop_id(){
        //Given
        String shopId="123e4567-e89b-42d3-a456-55664244333";
        when(shopRepositoryMock.findById(shopId)).thenReturn(getShop());
        //When
        List<Item> monCatalog=shopService.getCatalog(shopId);
        //Then
        assertThat(monCatalog).size().isEqualTo(5);
        assertThat(monCatalog).isNotInstanceOf(Item.class);
        assertThat(monCatalog.get(0).getDescription()).isEqualTo("mocked item n°0");
    }


}
