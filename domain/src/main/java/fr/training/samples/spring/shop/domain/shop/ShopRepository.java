package fr.training.samples.spring.shop.domain.shop;

import fr.training.samples.spring.shop.domain.item.Item;

import java.util.List;

public interface ShopRepository {

    Shop findById(String shopId);
}
