package fr.training.samples.spring.shop.infrastructure.shop;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopJpaRepository extends JpaRepository<Shop,String> {

}
