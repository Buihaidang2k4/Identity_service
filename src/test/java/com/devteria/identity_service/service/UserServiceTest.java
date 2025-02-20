package com.devteria.identity_service.service;

import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.dto.respone.UserResponse;
import com.devteria.identity_service.entity.User;
import com.devteria.identity_service.exception.AppException;
import com.devteria.identity_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import  static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@TestPropertySource("/test.properties")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    private UserCreationRequest request;
    private UserResponse response;
    private LocalDate dob;
    private User user;
    @BeforeEach
    void initData(){
        dob = LocalDate.of(2000, 1, 1);

        request = UserCreationRequest.builder()
                .username("abc1234532")
                .firstname("ThanhVinhChuoi")
                .lastname("kevin")
                .password("12345678")
                .dob(dob)
                .build();

        response = UserResponse.builder()
                .id("b7fe4a536c16")
                .username("abc1234532")
                .firstname("ThanhVinhChuoi")
                .lastname("kevin")
                .dob(dob)
                .build();
        user = User.builder()
                .id("b7fe4a536c16")
                .username("abc1234532")
                .firstname("ThanhVinhChuoi")
                .lastname("kevin")
                .dob(dob)
                .build();
    }

        @Test
        void createUser_ValidRequest_success(){
            // GIVEN
            when(userRepository.existsByUsername(anyString())).thenReturn(false);
            when(userRepository.save(any())).thenReturn(user);

            // WHEN
             var  response1 = userService.createUser(request);


            // THEM
            assertEquals("b7fe4a536c16",response1.getId());
            assertEquals("abc1234532",response1.getUsername());
        }

        @Test
        void createUser_userExisted_fail(){
            // GIVEN
            when(userRepository.existsByUsername(anyString())).thenReturn(true);

            // WHEN
            var exception = assertThrows(AppException.class, () -> userService.createUser(request));

            // THEN
            assertThat(exception.getErrorCode().getCode()).isEqualTo(1002);
        }


        @Test
        @WithMockUser(username = "abc1234532")
        void getMyInfo_valid_success(){
            when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));

            var response = userService.getMyInfo();

            org.assertj.core.api.Assertions.assertThat(response.getUsername()).isEqualTo("abc1234532");
            org.assertj.core.api.Assertions.assertThat(response.getId()).isEqualTo("b7fe4a536c16");

        }


    @Test
    @WithMockUser(username = "abc1234532")
    void getMyInfo_userNotFound_error(){
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.ofNullable(null));

        var exception = assertThrows(AppException.class, () -> userService.getMyInfo());


        org.assertj.core.api.Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1005);

    }

    }

