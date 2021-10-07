package cz.osu.student.r19584.mvc.models;

public class Club {
    private String title;
    private String city;

    public Club(String title, String city) {
        this.title = title;
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
