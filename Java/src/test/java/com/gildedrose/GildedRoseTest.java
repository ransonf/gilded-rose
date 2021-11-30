package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].getName());
    }
    
    private List<Item> items = new List<Item>()
    {
        new Item("Generic iTEM",3,3)
    };
    
    PRIVATE Shop shop;
    
    @Testinitialize
    
    
    
    
    @Test
    public void Should_HaveSellInOnItems()
        
        assert equals (3,shop.items(0).SellIn);
    
    
    @Test
            void Should_HaveQualityOnItems()
                
                asser equals (3,shop.items(0).quality);
    
    
    @Test Should_DecreaseQualityAndSellInEveryDay()
    {
        shop updateQuality
            assert 2 shop items sellin
            assert 2 shop items quality
    }
    
    

}
