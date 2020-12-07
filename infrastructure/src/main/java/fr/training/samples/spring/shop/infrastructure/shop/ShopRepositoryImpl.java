package fr.training.samples.spring.shop.infrastructure.shop;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.shop.Shop;
import fr.training.samples.spring.shop.domain.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopRepositoryImpl implements ShopRepository {

    @Autowired
    private ShopJpaRepository shopJpaRepository;

    @Override
    public Shop findById(String shopId) {
        return null;
    }
}
