package com.gildedrose;

public final class Rules {

    public static final int MIN_POSSIBLE_QUALITY = 0;
    public static final int MAX_POSSIBLE_QUALITY = 50;

    /* Regular Item */
    public static final int REGULAR_QUALITY_INCREASE = 1;
    public static final int REGULAR_QUALITY_DECREASE = 1;

    /* BACKSTAGE item */
    public static final int BACKSTAGE_QUALITY_INCREASE_FOR_LESS_THAN_TEN_DAYS = 2;
    public static final int BACKSTAGE_QUALITY_INCREASE_FOR_LESS_THAN_FIVE_DAYS = 3;
    public static final int SELL_IN_FIVE_DAYS_VALUE = 5;
    public static final int SELL_IN_TEN_DAYS_VALUE = 10;

    /* CONJURED ITEM */
    public static final int CONJURED_QUALITY_DECREASE = 2;

    /* AGED BRIE ITEM */
    public static final int AGED_BRIE_QUALITY_INCREASE = 1;
}
