package com.yeonn.portfolio_backend.controller;

import com.yeonn.portfolio_backend.domain.Activity;
import com.yeonn.portfolio_backend.dto.AddActivityRequest;
import com.yeonn.portfolio_backend.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController //HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class ActivityApiController {

    private final ActivityService activityService;

    //HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/addactivity")
    //@RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Activity> addActivity(@RequestBody AddActivityRequest request){
        Activity savedActivity = activityService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedActivity);
    }

    //HTTP 메서드가 GET일 때 절달받은 URL과 동일하면 메서드로 매핑
    @GetMapping("/api/fetchactivity")
    public ResponseEntity<List<Activity>> getAllActivities() {
        // 모든 데이터를 가져옴
        List<Activity> activities = activityService.findAll();

        // 데이터를 ResponseEntity로 반환
        return ResponseEntity.ok(activities); // HTTP 상태 코드 200 OK로 응답
    }

}
