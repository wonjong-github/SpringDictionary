package com.demo.manager.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "MNG_DIC")
@SequenceGenerator(name = "dicSeqGenerator", sequenceName = "DIC_SEQ", initialValue = 1, allocationSize = 1)
public class Dictionary {

    public Dictionary(String key, String value){
        this.key = key;
        this.value = value;
    }
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dicSeqGenerator")
    @Column(name = "DIC_ID")
    private Long id;

    @Column(name = "DIC_KEY")
    private String key;

    @Column(name = "DIC_VAL")
    private String value;

    public void updateValue(String newValue){
        this.value = newValue;
    }
}
