package by.anpoliakov.entity;

import by.anpoliakov.constants.Constants;

/* Представляет из себя скидочную карточку клиента */
public class Card {
    private int id;
    private int discountSize;
    private User cardUser;

    public Card(int id, int discountSize, User cardUser) {
        this.id = id;
        this.cardUser = cardUser;
        this.discountSize = discountSize;
    }

    public int getId() {
        return id;
    }

    public int getDiscountSize() {
        return discountSize;
    }

    public void setDiscountSize(int discountSize) {
        this.discountSize = discountSize;
    }

    public User getCardUser() {
        return cardUser;
    }

    public void setCardUser(User cardUser) {
        this.cardUser = cardUser;
    }
}
