package com.gildedrose;

public class GildedRose {

    public Item[] items;
    private int sellInDiminu;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items ){
        this.items = items;
    }

    public static void main(String[] args) {
    }

    public void updateQuality() {

        for( Item item : items ){
            // Si aged brie
            if( item.getName().contains( "Aged Brie" ) ){
                ajoutQuality( item, 1 );
                continue;
            }
            // Si Backstage passes
            if( item.getName().contains( "Backstage passes" ) ){
                if( item.getSellIn() > 10 ){
                    ajoutQuality( item, 1 );
                }
                if( item.getSellIn() <= 10 && item.getSellIn() > 5){
                    ajoutQuality( item, 2 );
                }
                if( item.getSellIn() <= 5){
                    ajoutQuality( item, 3 );
                }
                if( item.getSellIn() <= 0){
                    item.setQuality( 0 );
                }
                continue;
            }
            // Si non sulfura (objet classique)
            if( !item.getName().contains( "Sulfuras" ) ){
                if( item.getSellIn() <= 0 ){
                    diminueQuality( item, 1 * 2 );
                    diminueSellIn( item, 1 * 2 );
                }else{
                    diminueQuality( item, 1 );
                    diminueSellIn( item, 1 );
                }
            }
        }
    }

    public void ajoutQuality(Item i, int valeur ){
        i.setQuality( i.getQuality() + valeur );
        // Valeur jamais plus de 50
        if( i.getQuality() > 50 && !i.getName().equals( "Sulfuras" ) ){
            i.setQuality( 50 );
        }
    }

    public void diminueQuality(Item i, int valeur ){
        i.setQuality( i.getQuality() - valeur );
        // Valeur jamais negative
        if( i.getQuality() < 0 ){
            i.setQuality( 0 );
        }
    }

    public void diminueSellIn( Item i, int valeur ){
        i.setSellIn( i.getSellIn() - valeur );
    }
}
