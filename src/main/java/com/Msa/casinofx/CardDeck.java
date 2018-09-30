//package com.Msa.casinofx;
//
//import com.Msa.casinofx.Card;
//import com.Msa.casinofx.Card.Rank;
//import com.Msa.casinofx.Card.Suit;
//
//public class CardDeck {
//
//    private Card[] deck = new Card[52];
//
//    public CardDeck() {
//        refillDeck();
//    }
//
//    public final void refillDeck() {
//        int i = 0;
//        for (Suit suit : Suit.values()) {
//            for (Rank rank : Rank.values()) {
//                deck[i++] = new Card(suit, rank);
//            }
//        }
//    }
//
//    public final Card takeCard() {
//        Card card = null;
//        while (card == null) {
//            int index = (int)Math.random() * deck.length;
//            card = deck[index];
//            deck[index] = null;
//        }
//        return card;
//    }
//}
