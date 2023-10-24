package gazmeCodexist.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private GooglePlacesService googlePlacesService;
 
    @GetMapping("/search")
    public List<String> searchNearbyPlaces(@RequestParam double longitude, @RequestParam double latitude, @RequestParam int radius) {
        // Implement the logic to search for nearby places using Google Places API.
        // You can use libraries like RestTemplate or WebClient to make HTTP requests.
        // Save the response in the database and return it.
//        String longitude;
//        String latitude;
//        String radius;
//        
          

               return googlePlacesService.searchNearbyPlaces(latitude, longitude, radius);

    }
    
}
