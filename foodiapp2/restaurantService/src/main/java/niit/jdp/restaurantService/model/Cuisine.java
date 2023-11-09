package niit.jdp.restaurantService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cuisine {
    private  int cuisineId;
    private byte[] image;
    private String cuisinesName;
    private String cuisinesDescription;
    private  String price;
}
