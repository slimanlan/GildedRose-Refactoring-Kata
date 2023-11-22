package com.gildedrose.services.sellIn;

import com.gildedrose.Item;

import static com.gildedrose.ItemNames.SULFURAS;

public final class SellInService {

    public Item updateSellIn(Item item) {
        if (!SULFURAS.equals(item.name)) {
            decreaseSellIn(item);
        }
        return item;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

}
