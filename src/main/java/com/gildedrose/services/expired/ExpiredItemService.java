package com.gildedrose.services.expired;

import com.gildedrose.Item;
import com.gildedrose.services.quality.QualityService;

import static com.gildedrose.ItemNames.*;
import static com.gildedrose.Rules.MIN_POSSIBLE_QUALITY;

public final class ExpiredItemService {

    private final QualityService qualityService = new QualityService();

    public Item handleItemExpired(Item item) {
        if (item.sellIn < 0) {
            if (BACKSTAGE.equals(item.name)) {
                item.quality = MIN_POSSIBLE_QUALITY;
            } else if (AGED_BRIE.equals(item.name) || !item.name.equals(SULFURAS) ) {
                qualityService.updateQuality(item);
            }
        }
        return item;
    }

}
