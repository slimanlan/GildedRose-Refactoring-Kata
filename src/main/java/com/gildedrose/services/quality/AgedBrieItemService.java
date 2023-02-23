package com.gildedrose.services.quality;

import com.gildedrose.Item;

import static com.gildedrose.Rules.AGED_BRIE_QUALITY_INCREASE;
import static com.gildedrose.Rules.MAX_POSSIBLE_QUALITY;

public final class AgedBrieItemService {

    public final Item updateQualityForAgedBrieItem(Item item) {
        if (item.quality > MAX_POSSIBLE_QUALITY) return item;
        item.quality = item.quality + AGED_BRIE_QUALITY_INCREASE;
        return item;
    }

}
