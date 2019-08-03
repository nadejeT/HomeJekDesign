package Models;

public class HomeListView {

    private int image;
    private  String title;
    private String description;
    private String state;
    private int stateIcon;


    public HomeListView(int image, String title, String description, String state, int stateIcon) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.state = state;
        this.stateIcon = stateIcon;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public int getStateIcon() {
        return stateIcon;
    }

    public void setStateIcon(int stateIcon) {
        this.stateIcon = stateIcon;
    }
}
