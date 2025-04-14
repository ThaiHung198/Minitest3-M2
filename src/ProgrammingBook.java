public class ProgrammingBook extends Book {
    private String language;
    private String framework;

    public ProgrammingBook() {
        super();
    }
    public ProgrammingBook(int id, String name, double price, String author, String language, String framework) {
        super(id, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public double getPrice() {
        double originalPrice = super.getPrice();
        double discount = originalPrice * 0.95;
        return discount;
    }

    @Override
    public String toString() {
        return "ProgrammingBook{" +
                "id="+getId() +
                ",name="+getName() +
                ",price(original)="+super.getPrice() +
                ",price(discount)="+getPrice() +
                ",author="+getAuthor() +
                "language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
