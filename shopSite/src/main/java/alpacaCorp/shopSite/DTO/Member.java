package alpacaCorp.shopSite.DTO;


import lombok.Data;

@Data
public class Member {
    /*
     * ID, Name, Password, Color, Image, Start date, End date
     */
    Long id;
    String name;
    String password;
    String color;
    String img;
    String start_date;
    String end_date;

    public Member() {

    }

    public Member(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}