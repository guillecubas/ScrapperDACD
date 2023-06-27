package org.example;

import static spark.Spark.get;

public class WebService {
    private final HotelScrapper scrapper;

    public WebService(HotelScrapper scrapper) {
        this.scrapper = scrapper;
    }

    public void start() {
        get("/hotels/:id/:name", (req, res) -> {
            String hotel = req.params("id") + "/" + req.params("name") ;
            scrapper.setUp(hotel);
            res.type("application/json");
            return scrapper.getLocation(hotel);
        });
        get("/hotels/:id/:name/services", (req, res) -> {
            String hotel = req.params("id") + "/" + req.params("name") ;
            scrapper.setUp(hotel);
            res.type("application/json");
            return scrapper.getServices(hotel);
        });
        get("/hotels/:id/:name/comments", (req, res) -> {
            String hotel = req.params("id") + "/" + req.params("name") ;
            scrapper.setUp(hotel);
            res.type("application/json");
            return scrapper.getComments(hotel);
        });
        get("/hotels/:id/:name/ratings", (req, res) -> {
            String hotel = req.params("id") + "/" + req.params("name") ;
            scrapper.setUp(hotel);
            res.type("application/json");
            return scrapper.getRating(hotel);
        });
    }
}