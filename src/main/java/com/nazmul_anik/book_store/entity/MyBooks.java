package com.nazmul_anik.book_store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="My_Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MyBooks {
    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
