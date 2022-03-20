package by.anpoliakov.entity;

/* Представляет из себя скидочную карточку клиента */
//TODO: поле с % скидки по данной карточке
public class Card {
    private int id;
    private int discountSize;
    private User cardUser;

    public Card(int id, int discountSize, User cardUser) {
        this.id = id;
        this.discountSize = discountSize;
        this.cardUser = cardUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
