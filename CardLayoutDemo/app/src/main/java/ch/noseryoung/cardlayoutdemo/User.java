package ch.noseryoung.cardlayoutdemo;

public class User {

    private String name;
    private String vorname;

    public User(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
