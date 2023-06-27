package org.example;

public class Controller {
    public void run() {
        new WebService(new Scrapper()).start();
    }
}
