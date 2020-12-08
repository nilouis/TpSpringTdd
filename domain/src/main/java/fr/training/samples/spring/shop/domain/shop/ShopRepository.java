package fr.training.samples.spring.shop.domain.shop;

import java.util.Optional;

public interface ShopRepository {

    Shop findById(String shopId);
}
