package com.devteria.identity_service.controller;

import com.devteria.identity_service.dto.request.*;
import com.devteria.identity_service.dto.respone.AuthenticationRespone;
import com.devteria.identity_service.dto.respone.IntrospectRespone;
import com.devteria.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationRespone> authenticate(@RequestBody AuthenticationRequest request){
        var result = authenticationService.authenticate(request);
        return  ApiResponse.<AuthenticationRespone>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectRespone> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return  ApiResponse.<IntrospectRespone>builder()
                .result(result)
                .build();
    }


    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return  ApiResponse.<Void>builder()
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationRespone> authenticate(@RequestBody RefreshRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.refeshToken(request);
        return  ApiResponse.<AuthenticationRespone>builder()
                .result(result)
                .build();
    }

}
