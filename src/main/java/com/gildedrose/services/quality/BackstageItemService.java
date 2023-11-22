package com.gildedrose.services.quality;

import com.gildedrose.Item;

import static com.gildedrose.Rules.*;

public final class BackstageItemService {

    public final Item updateQualityForBackstageItem(Item item) {

        if (item.sellIn <= SELL_IN_FIVE_DAYS_VALUE) {
            item.quality = item.quality + BACKSTAGE_QUALITY_INCREASE_FOR_LESS_THAN_FIVE_DAYS;
        } else if (item.sellIn <= SELL_IN_TEN_DAYS_VALUE) {
            item.quality = item.quality + BACKSTAGE_QUALITY_INCREASE_FOR_LESS_THAN_TEN_DAYS;
        } else {
            item.quality = item.quality + REGULAR_QUALITY_INCREASE;
        }

        item.quality = (item.quality > MAX_POSSIBLE_QUALITY) ? MAX_POSSIBLE_QUALITY : item.quality;

        return item;
    }

}
