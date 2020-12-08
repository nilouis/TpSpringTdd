package fr.training.samples.spring.shop.domain.shop;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SHOP")
public class Shop extends AbstractBaseEntity {

    private String name;

    @ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> listItem = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }

}
