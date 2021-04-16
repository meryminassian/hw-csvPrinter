public class Person {
    private String name;
    private String surname;
    private String Date;
    private Race race;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String surname, String date, Race race, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        Date = date;
        this.race = race;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getName() +
                "," + getSurname() +
                ", " + getDate() +
                ", " + getRace() +
                ", " + getPhoneNumber() +
                ", " + getEmail();
    }
}
