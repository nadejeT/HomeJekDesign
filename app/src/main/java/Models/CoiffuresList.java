package Models;

public class CoiffuresList {


    private String title;
    private String price;
    private String detail;


    public CoiffuresList(String title, String price, String detail) {


        this.title = title;
        this.price = price;
        this.detail = detail;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
