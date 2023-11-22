package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.gildedrose.ItemNames.*;

class GildedRoseTest {

    /*
    * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    * */
    @Test
    void test_conjured_item_updated_quality() {
        // given
        Item[] items = new Item[] {  new Item(CONJURED, 3, 6) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(CONJURED, app.items[0].name);
        assertEquals(4, app.items[0].quality); // "Conjured" items degrade in Quality twice as fast as normal items
    }

    @Test
    void test_conjured_item_updated_sellIn() {
        // given
        Item[] items = new Item[] {  new Item(CONJURED, 3, 6) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(CONJURED, app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
    }

    /*
    * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    * */
    @Test
    void test_sulfuras_item_updated_quality() {
        // given
        Item[] items = new Item[] {  new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(SULFURAS, app.items[0].name);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_sulfuras_item_updated_sellIn() {
        // given
        Item[] items = new Item[] {  new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(SULFURAS, app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
    }

    /*
     * "Aged Brie" actually increases in Quality the older it gets
     *
     */
    @Test
    void test_agedBrie_item_updated_quality() {
        // given
        Item[] items = new Item[] {  new Item(AGED_BRIE, 2, 0) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void test_agedBrie_item_updated_sellIn() {
        // given
        Item[] items = new Item[] {  new Item(AGED_BRIE, 2, 0) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
    }



    /*
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        Quality drops to 0 after the concert
     *
     */
    @Test
    void test_backstage_item_updated_quality() {
        // given
        Item[] items = new Item[] {
            new Item(BACKSTAGE, 15, 20),
            new Item(BACKSTAGE, 10, 49),
            new Item(BACKSTAGE, 5, 49),
            new Item(BACKSTAGE, 10, 20),
            new Item(BACKSTAGE, 5, 31)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(21, app.items[0].quality);

        assertEquals(BACKSTAGE, app.items[1].name);
        assertEquals(50, app.items[1].quality); // quality is never more tha 50

        assertEquals(BACKSTAGE, app.items[2].name);
        assertEquals(50, app.items[2].quality); // quality is never more tha 50

        assertEquals(BACKSTAGE, app.items[3].name);
        assertEquals(22, app.items[3].quality);

        assertEquals(BACKSTAGE, app.items[4].name);
        assertEquals(34, app.items[4].quality);
    }

    @Test
    void test_backstage_item_updated_sellIn() {
        // given
        Item[] items = new Item[] {
            new Item(BACKSTAGE, 15, 20),
            new Item(BACKSTAGE, 10, 49),
            new Item(BACKSTAGE, 5, 49)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(14, app.items[0].sellIn);

        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(9, app.items[1].sellIn);

        assertEquals(BACKSTAGE, app.items[0].name);
        assertEquals(4, app.items[2].sellIn);
    }


    @Test
    void test_Elixir_item_updated_quality() {
        // given
        Item[] items = new Item[] {  new Item(ELIXIR, 5, 7) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(ELIXIR, app.items[0].name);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void test_Elixir_item_updated_sellIn() {
        // given
        Item[] items = new Item[] {  new Item(ELIXIR, 5, 7) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(ELIXIR, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
    }


    @Test
    void test_expired_item() {
        // given
        Item[] items = new Item[] {
            new Item(ELIXIR, -1, 7),
            new Item(AGED_BRIE, -2, 12),
            new Item(BACKSTAGE, -1, 8)
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(5, app.items[0].quality);
        assertEquals(14, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    void test_item_to_string_method() {
        // given
        Item[] items = new Item[] {
            new Item(AGED_BRIE, 12, 12),
        };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals("Aged Brie, 11, 13", app.items[0].toString());
    }
}
