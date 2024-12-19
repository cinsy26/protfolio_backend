package com.yeonn.portfolio_backend.dto;

import com.yeonn.portfolio_backend.domain.Activity;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor //기본 생성자 추가
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddActivityRequest {

    private LocalDate startdate;
    private LocalDate enddate;
    private String content;

    public Activity toEntity(){ //toEntity는 빌더 패턴을 사용해 DTO를 엔티티로 만들어주는 메서드. 추후 활동 추가할 때 저장할 엔티티로 변환하는 용도로 사용
        return Activity.builder()
                .startdate(startdate)
                .enddate(enddate)
                .content(content)
                .build();
    }
}
