package com.gildedrose.services.quality;

import com.gildedrose.Item;

import static com.gildedrose.ItemNames.*;

public final class QualityService  {

    private final BackstageItemService backstageItemService = new BackstageItemService();
    private final RegularItemService regularItemService = new RegularItemService();
    private final ConjuredItemService conjuredItemService = new ConjuredItemService();
    private final AgedBrieItemService agedBrieItemService = new AgedBrieItemService();

    public Item updateQuality(Item item) {
        if (BACKSTAGE.equals(item.name) ) {
            return backstageItemService.updateQualityForBackstageItem(item);
        } else if (AGED_BRIE.equals(item.name)) {
            return agedBrieItemService.updateQualityForAgedBrieItem(item);
        } else if (CONJURED.equals(item.name)) {
            return conjuredItemService.updateQualityConjuredItem(item);
        } else if (!SULFURAS.equals(item.name)) {
            return regularItemService.updateQualityForRegularItem(item);
        }
        return item;
    }

}
