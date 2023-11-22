package com.gildedrose.services.quality;

import com.gildedrose.Item;

import static com.gildedrose.Rules.*;

public final class ConjuredItemService {

    public final Item updateQualityConjuredItem(Item item) {
        item.quality = item.quality - CONJURED_QUALITY_DECREASE;
        return item;
    }
}
