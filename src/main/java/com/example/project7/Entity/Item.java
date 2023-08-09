package com.example.project7.Entity;

public class Item {import javax.persistence.*;

    @Entity
    public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String itemName;
        // ... other fields, getters, setters
    }
}
