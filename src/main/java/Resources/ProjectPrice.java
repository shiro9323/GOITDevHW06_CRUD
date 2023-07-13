package Resources;

public class ProjectPrice {

    private String id;
    private int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Resources.ProjectPrice{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
