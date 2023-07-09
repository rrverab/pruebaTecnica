package mocksimilar.com.example.mocksimilar;



import lombok.*;


@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Product {


    private long id;


    private String name;

    private Double price;

    private Boolean availability;



}
