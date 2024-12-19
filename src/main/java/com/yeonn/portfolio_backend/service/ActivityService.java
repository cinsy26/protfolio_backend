package com.yeonn.portfolio_backend.service;

import com.yeonn.portfolio_backend.domain.Activity;
import com.yeonn.portfolio_backend.dto.AddActivityRequest;
import com.yeonn.portfolio_backend.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor //final 키워드나 @NotNull이 붙은 필드로 생성자를 만들어준다
@Service //해당 클래스를 빈으로 서블릿 컨테이너에 등록
public class ActivityService {

    private final ActivityRepository activityRepository;

    //활동 추가 메서드
    public Activity save(AddActivityRequest request){ //save 메서드는 JpaRepository에서 지원하는 저장 메서드. AddActivityRequest 클래스에 저장된 값들을 activit 데이터베이스에 저장y
        return activityRepository.save(request.toEntity());
    }

    // 모든 활동 데이터 가져오는 메서드
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }
}
