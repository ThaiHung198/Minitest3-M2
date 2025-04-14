public class FictionBook extends Book {
    private String category;
    public FictionBook() {
        super();
    }

    public FictionBook(int id, String name, double price, String author, String category) {
        super(id, name, price, author);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double getPrice() {
        double originalPrice = super.getPrice();
        double discountPrice = originalPrice * 0.93;
        return discountPrice;
    }

    @Override
    public String toString() {
        return "FictionBook{" +
                "id=" +getId() +
                ", name='" + getName() + '\'' +
                ",price(original)=" + getPrice() +
                ",price(discount)=" + getPrice() +
                ",author='" + getAuthor() + '\'' +
                "category='" + category + '\'' +
                '}';
    }
}
