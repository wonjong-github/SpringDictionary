package me.hyunsoo.redissample.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyunsoo.redissample.beans.Product;
import me.hyunsoo.redissample.cache.ProductRepository;
import me.hyunsoo.redissample.db.ProductDBRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    //DB
    private final ProductDBRepository productDBRepository;
    //CACHE
    private final ProductRepository productRepository;

    public Product getProduct(Long id){
        //CACHE 에서 검색
        return productRepository.findById(id).orElseGet(
                ()->{
                    Product foundFromDB = productDBRepository.getProduct(id);
                    productRepository.save(foundFromDB);
                    return foundFromDB;
                }
        );
    }
}
