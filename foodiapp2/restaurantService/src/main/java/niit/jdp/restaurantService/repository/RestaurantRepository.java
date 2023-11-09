package niit.jdp.restaurantService.repository;

import niit.jdp.restaurantService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {
}
