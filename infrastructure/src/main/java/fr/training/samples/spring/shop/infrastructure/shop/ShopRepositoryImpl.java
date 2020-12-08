package fr.training.samples.spring.shop.infrastructure.shop;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.domain.shop.Shop;
import fr.training.samples.spring.shop.domain.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShopRepositoryImpl implements ShopRepository {

    @Autowired
    private ShopJpaRepository shopJpaRepository;
    private String shopId;

    @Override
    public Shop findById(final String shopId) {
        this.shopId = shopId;
        return shopJpaRepository.findById(shopId).orElseThrow(() -> new NotFoundException());
    }


}
