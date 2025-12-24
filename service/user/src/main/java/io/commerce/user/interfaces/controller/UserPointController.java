package io.commerce.user.interfaces.controller;

import io.commerce.user.application.dto.UserPointResult;
import io.commerce.user.application.service.UserPointService;
import io.commerce.user.interfaces.dto.DecreaseRequest;
import io.commerce.user.interfaces.dto.IncreaseRequest;
import io.commerce.user.interfaces.dto.PointResponse;
import io.commerce.user.interfaces.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/user-point")
@RequiredArgsConstructor
public class UserPointController {

    private final UserPointService userPointService;

    @GetMapping("/points/{userId}")
    public ResponseEntity<PointResponse> getPoints(@PathVariable("userId") Long userId) {
        UserPointResult userPoint = userPointService.getUserPoint(userId);
        return ResponseEntity.ok().body(PointResponse.from(userPoint));
    }

    @PostMapping("/{userId}/increase")
    public ResponseEntity<Void> increase(@PathVariable("userId") Long userId, @RequestBody IncreaseRequest request) {
        userPointService.increaseBalance(userId, request.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{userId}/decrease")
    public ResponseEntity<Void> decrease(@PathVariable("userId") Long userId, @RequestBody DecreaseRequest request) {
        userPointService.decreaseBalance(userId, request.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
