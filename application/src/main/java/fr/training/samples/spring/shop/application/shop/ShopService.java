package fr.training.samples.spring.shop.application.shop;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.order.Order;

import java.util.List;

public interface ShopService {

    List<Item> getCatalog (String shopId);

    List<Order> getShopOrder(String shopId);

}
