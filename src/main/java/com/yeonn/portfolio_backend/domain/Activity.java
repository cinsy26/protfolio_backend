package com.yeonn.portfolio_backend.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter //
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false)
    private Long id;

    @Column(name ="startdate", nullable = false)
    private LocalDate startdate;

    @Column(name ="enddate", nullable = true)
    private LocalDate enddate;

    @Column(name="content", nullable = false)
    private String content;

    @Builder //빌더 패턴으로 객체 생성. 롬복에서 지원. 생성자 위에 입력하면 빌더 패턴 방식으로 객체 생성 가능.
    public Activity(LocalDate startdate, LocalDate enddate, String content){
        this.startdate = startdate;
        this.enddate = enddate;
        this.content = content;
    }

    //Getter 어노테이션
    /*protected Activity(){

    }

    public Long getId(){
        return id;
    }

    public LocalDate getDate(){
        return date;
    }

    public String getContent(){
        return content;
    }*/
}
