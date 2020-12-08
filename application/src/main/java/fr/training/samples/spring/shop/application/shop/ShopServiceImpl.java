package fr.training.samples.spring.shop.application.shop;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.domain.shop.Shop;
import fr.training.samples.spring.shop.domain.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    ShopRepository shopRepository;

    @Override
    public List<Item> getCatalog(String shopId) {
        Shop aShop=shopRepository.findById(shopId);
        return aShop.getListItem();
    }

    @Override
    public List<Order> getShopOrder(String shopId) {
        return null;
    }
}
