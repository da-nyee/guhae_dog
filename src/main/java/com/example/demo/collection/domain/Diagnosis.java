package com.example.demo.collection.domain;


import com.example.demo.collection.domain.Air;
import com.example.demo.collection.domain.Corna;
import com.example.demo.collection.domain.Macak;
import com.example.demo.member.vo.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
@Embeddable
@Setter
@NoArgsConstructor
public class Diagnosis {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    private Member member;
    private String name; //진단질병명

    private String dog;
    @ManyToOne
    private Corna corna;

    @ManyToOne
    private Macak macak;

    @ManyToOne
    private Air air;



}