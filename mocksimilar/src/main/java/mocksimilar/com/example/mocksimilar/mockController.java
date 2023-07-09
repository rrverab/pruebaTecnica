package mocksimilar.com.example.mocksimilar;


import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController()

public class mockController {

        private Map<Integer,Product> catalogo = Map.of(
                1,new Product(1,"camisa",7.00,true),
                2,new Product(2,"shirt",20.00,true),
                3,new Product(3,"jean",5.00,false),
                4,new Product(4,"reloj",4.00,true),
                5,new Product(5,"sueter",20.00,false),
                6,new Product(6,"short",10.00,true),
                7,new Product(7,"short",10.00,true)
        );
        @GetMapping("product/{productid}")
        public ResponseEntity getProductById(@PathVariable("productid") Integer id){

                return catalogo.get(id) == null
                        ? ResponseEntity.status(404).body(null)
                        : ResponseEntity.ok(catalogo.get(id));


        }

        private Map<Integer, List<Integer>> similar = Map.of(
                1,List.of(1,2,3),
                2,List.of(4,5,6),
                3,List.of(7,8,9),
                4,List.of(100,200,300),
                5,List.of(20,30,40),
                6,List.of(50,60,70),
                7,List.of(70,80,90)
        );


        @GetMapping("product/{productid}/similarids")
        public ResponseEntity getSimilarById(@PathVariable("productid") Integer id){

                return similar.get(id) == null
                        ? ResponseEntity.status(404).body(null)
                        : ResponseEntity.ok(similar.get(id));


        }






}
