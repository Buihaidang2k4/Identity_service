package com.devteria.identity_service.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.dto.respone.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
public class UserControllerIntegrationTest {
    @Container
    static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:latest");

    @DynamicPropertySource
    static void configProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "com.mysql.cj.jdbc.Driver");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    @Autowired
    private MockMvc mockMvc;

    private UserCreationRequest request;
    private UserResponse response;
    private LocalDate dob;

    @BeforeEach
    void initData() {
        dob = LocalDate.of(2000, 1, 1);

        request = UserCreationRequest.builder()
                .username("abc1234532")
                .firstname("ThanhVinhChuoi")
                .lastname("kevin")
                .password("12345678")
                .dob(dob)
                .build();

        response = UserResponse.builder()
                .id("274c68b0-1db4-4074-95a8-af0203fcbe35")
                .username("abc1234532")
                .firstname("ThanhVinhChuoi")
                .lastname("kevin")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() throws Exception {
        // GIVEN
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writeValueAsString(request); // Convert json request

        // WHEN
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("result.username").value("abc1234532"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.firstname").value("ThanhVinhChuoi"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.lastname").value("kevin"));

        log.info("Result: ", response.getUsername());

        // THEN
    }
}
