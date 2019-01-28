package com.stackroute.MuzixApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Document(collection = "Tracks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Track
{
    @Id
    private int id;
    private String name;
    private String comment;

}
