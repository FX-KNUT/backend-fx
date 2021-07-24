package alpacaCorp.shopSite.DTO;

import lombok.Data;

@Data
public class Profile {
    /**
     * Color, Name, Image, Id, Start_date, End_date
     */
    Long id;
    String name;
    String color;
    String img;
    String start_date;
    String end_date;
}
