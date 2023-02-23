package com.gildedrose;

import com.gildedrose.services.expired.ExpiredItemService;
import com.gildedrose.services.quality.QualityService;
import com.gildedrose.services.sellIn.SellInService;

import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    QualityService qualityService = new QualityService();
    SellInService sellInService = new SellInService();
    ExpiredItemService expiredItemService = new ExpiredItemService();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items).forEach(item -> {
            item = qualityService.updateQuality(item);
            item = sellInService.updateSellIn(item);
            item = expiredItemService.handleItemExpired(item);
        });
    }


}
