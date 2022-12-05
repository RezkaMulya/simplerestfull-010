/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.projectbulidrestful;

import java.util.HashMap;
import java.util.Map;
import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class restController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static{
        //membuat id dan nama product
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);
        
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }
    
    //fungsi delete
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){

        //jika id yg dimasukkan tidak ada maka akan menampilkan "Product deleted not found"
        if(!productRepo.containsKey(id)){
           return new ResponseEntity<>("Product deleted not found", HttpStatus.NOT_FOUND);
       }
      
        //jika berhasil menghapus product
           productRepo.remove(id);
           return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.NOT_FOUND);
       
        

    }
    
    //fungsi update
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
      
        //jika id tidak ada maka akan menampilkan "Product updated not found"
        if(!productRepo.containsKey(id)){
           return new ResponseEntity<>("Product updated not found", HttpStatus.NOT_FOUND);
       }
       
        //jika berhasil mengupdate product
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is update successfully", HttpStatus.OK);
   
        
    }
    
    //fungsi create
    @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody @Validated Product product) {
       //jika id sudah ada maka akan menampilkan "Product not duplicate"
      if(productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("Product not duplicate", HttpStatus.OK);
       }
      
      //jika berhasil menambah product baru
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
       
   }
    
   //fungsi untuk menampilkan data
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
}
