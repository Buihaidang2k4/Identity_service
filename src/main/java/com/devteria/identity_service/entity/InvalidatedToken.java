package com.devteria.identity_service.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder // Su dung mau thiet ke buider de tao thiet ke user linh hoat
@NoArgsConstructor // tao constructor  khong tham so
@AllArgsConstructor // tao mot constructor  co tham so voi full row
@FieldDefaults(level = AccessLevel.PRIVATE) // dat tat ca cac truong theo private theo pham vi truy cap
@Entity // danh dau la mot thuc the duoc anh xa trong csdl
public class InvalidatedToken {
    @Id
    String id;

    Date expiryTime; // Thoi gian het han token
}
