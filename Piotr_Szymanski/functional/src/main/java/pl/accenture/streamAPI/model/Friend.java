package pl.accenture.streamAPI.model;

public class Friend {
    String name;
    String day;
    String activity;

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getActivity() {
        return activity;
    }

    public Friend(String name, String day, String activity) {
        this.name = name;
        this.day = day;
        this.activity = activity;
    }
}