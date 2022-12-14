package me.hyunsoo.redissample.cache;

import me.hyunsoo.redissample.beans.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
