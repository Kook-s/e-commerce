package io.commerce.order.domain;

public enum OrderStatus {
    CREATED,            // 주문 생성
    PAYMENT_PENDING,    // 결제 대기
    PAYMENT_COMPLETED,  // 결제 성공
    PAYMENT_FAILED,     // 결제 실패
    CANCELLED,          // 주문 취소
    EXPIRED             // 결제 시간 초과

}
