package com.devteria.identity_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Builder // Su dung mau thiet ke buider de tao thiet ke user linh hoat
@NoArgsConstructor // tao constructor  khong tham so
@AllArgsConstructor // tao mot constructor  co tham so voi full row
@FieldDefaults(level = AccessLevel.PRIVATE) // dat tat ca cac truong theo private theo pham vi truy cap
@Entity // danh dau la mot thuc the duoc anh xa trong csdl
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Chuoi ngau nhien
    String id;
    String username;
    String password;
    String firstname;
    String lastname;
    LocalDate dob;
    @ElementCollection
    Set<String> roles;
}
