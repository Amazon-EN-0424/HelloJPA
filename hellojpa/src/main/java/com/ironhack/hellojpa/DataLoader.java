package com.ironhack.hellojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;


    @Override
    public void run(String... args) throws Exception {

//        create 2 coffee
        var coffee1 = new Coffee("ChocoParadise", "Colombia");
        var coffee2 = new Coffee("Light Breeze", "Peru");
//        store them in a database
        System.out.println("The coffee1 to save is: " + coffee1);
        coffeeRepository.save(coffee1);
        System.out.println("The saved coffee1 is: " + coffee1);
        coffeeRepository.save(coffee2);
//        retrieve all of them and print them to the console
        List<Coffee> allCoffees = coffeeRepository.findAll();
        for (Coffee coffee : allCoffees) {
            System.out.println(coffee);
        }
//        retrieve only one of them and print it
        Optional<Coffee> coffeeRetrieved = coffeeRepository.findById(42);
        if (coffeeRetrieved.isPresent()) {
            System.out.println("Coffee found with id 2 is: " + coffeeRetrieved.get());
        } else {
            System.out.println("There is no Coffee with that id");
        }

//        delete one
        System.out.println("Deleting one");
        coffeeRepository.deleteById(2);
//        print all -> expecting one

        var updatedCoffeeList = coffeeRepository.findAll();
        System.out.println("Printing the updated list");
        for (int i = 0; i < updatedCoffeeList.size(); i++) {
            System.out.println(updatedCoffeeList.get(i));
        }
    }
}
