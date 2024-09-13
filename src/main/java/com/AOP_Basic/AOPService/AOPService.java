package com.AOP_Basic.AOPService;

import com.AOP_Basic.Exception.MyException;
import com.AOP_Basic.Model.Product;
import com.AOP_Basic.Repository.AOPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component("AopService")
@Service

public class AOPService {
    @Autowired
    private AOPRepository aopRepository;

    public Product saveProduct(Product product) {
        Product save = aopRepository.save(product);
        return save;
    }
    public Product getProduct(String id) {
        Product save = aopRepository.findById(id).get();
        //throwException();
        return save;
    }
    public List<Product> getAllProduct() {
        List<Product> productList = aopRepository.findAll();
        return productList;
    }
//    public void throwException() {
//       throw new MyException("this is custom thrown exception");
//    }

}
