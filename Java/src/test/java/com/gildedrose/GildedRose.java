package com.gildedrose;

public class GildedRose {

    public Item[] items;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items ){
        this.items = items;
    }

    public static void main(String[] args) {
    }

    // Complexity: 11
    public void updateQuality() {//1

        for( Item item : items ){//1
            // Si aged brie
            if( item.getName().contains( "Aged Brie" ) ){//1
                addQuality( item, 1 );
                continue;
            }
            // Si Backstage passes
            if( item.getName().contains( "Backstage passes" ) ){//1
                if( item.getSellIn() > 10 ){//1
                    addQuality( item, 1 );
                    removeSellIn( item, 1 );
                }
                if( item.getSellIn() <= 10 && item.getSellIn() > 5){// 1 + 1
                    addQuality( item, 2 );
                    removeSellIn( item, 1 );
                }
                if( item.getSellIn() <= 5){//1
                    addQuality( item, 3 );
                    removeSellIn( item, 1 );
                }
                if( item.getSellIn() <= 0){//1
                    item.setQuality( 0 );
                }
                continue;
            }
            // Si non sulfura (objet classique)
            if( !item.getName().contains( "Sulfuras" ) ){//1
                if( item.getSellIn() <= 0 ){//1
                    removeQuality( item, 1 * 2 );
                    removeSellIn( item, 1 * 2 );
                }else{
                    removeQuality( item, 1 );
                    removeSellIn( item, 1 );
                }
            }
        }
    }

    public void addQuality(Item item, int valeur ){
        item.setQuality( item.getQuality() + valeur );
        // Valeur jamais plus de 50
        if( item.getQuality() > 50 && !item.getName().equals( "Sulfuras" ) ){
            item.setQuality( 50 );
        }
    }

    public void removeQuality(Item item, int valeur ){
        item.setQuality( item.getQuality() - valeur );
        // Valeur jamais negative
        if( item.getQuality() < 0 ){
            item.setQuality( 0 );
        }
    }

    public void removeSellIn(Item item, int valeur ){
        item.setSellIn( item.getSellIn() - valeur );
    }
}
