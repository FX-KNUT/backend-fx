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

//    public Member() {
//
//    }

    public Member(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

//    public Member(Long id, String name, String password, String color, String img, String start_date, String end_date) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.color = color;
//        this.img = img;
//        this.start_date = start_date;
//        this.end_date = end_date;
//    }
}