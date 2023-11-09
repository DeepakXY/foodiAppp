package niit.jdp.restaurantService.service;

import niit.jdp.restaurantService.model.Cuisine;
import niit.jdp.restaurantService.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant addCuisineToRestaurant(Cuisine cuisine ,String restaurantId);
    Restaurant deleteCuisineFromRestaurant(String restaurantId, String cuisineId);
    List<Cuisine> getAllCuisine(String restaurantId);
    List<Restaurant> getAllRestaurant() ;
    public Restaurant getRestaurantDetails(String restaurantId);
    boolean deleteProduct(String restaurantId);
}
