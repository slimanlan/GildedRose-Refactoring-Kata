package com.gildedrose.services.quality;

import com.gildedrose.Item;

import static com.gildedrose.Rules.*;

public final class RegularItemService {

    public final Item updateQualityForRegularItem(Item item) {
        item.quality = item.quality - REGULAR_QUALITY_DECREASE;
        return item;
    }

}
