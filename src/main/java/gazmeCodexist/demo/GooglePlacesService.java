package gazmeCodexist.demo;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GooglePlacesService {
    private static final String API_KEY = "Your-Key"; //API buraya yazalım.
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DataBase database;
    public List<String> searchNearbyPlaces(double latitude, double longitude, int radius) {
        List<String> get = database.getDatabase().get(String.valueOf(longitude)+String.valueOf(latitude)+String.valueOf(radius));
        if (get!=null){
            return get;
            
        }
        List<String> places = new ArrayList<>();
        // Create a GeoApiContext with your API key
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        // Define a location (latitude and longitude)
        LatLng location = new LatLng(latitude, longitude); // San Francisco coordinates

        try {
            // Create a Places API request
            PlacesSearchResponse response = PlacesApi.nearbySearchQuery(context, location)
                    .radius(radius) // Search radius in meters
                    .keyword("restaurant") //  search keyword
                    .language("en") // Language preference
                    .await();

            // Process the response
            for (int i = 0; i < response.results.length; i++) {
                places.add(response.results[i].name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        database.getDatabase().put(String.valueOf(longitude)+String.valueOf(latitude)+String.valueOf(radius), places);
        return places;
    
    }
}
