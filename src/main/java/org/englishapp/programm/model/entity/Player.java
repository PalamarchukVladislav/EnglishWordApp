package org.englishapp.programm.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="players")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "player_name")
    private String playerName;

}
