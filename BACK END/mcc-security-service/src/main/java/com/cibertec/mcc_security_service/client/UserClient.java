package com.cibertec.mcc_security_service.client;

import com.cibertec.mcc_security_service.client.dto.UserRequest;
import com.cibertec.mcc_security_service.client.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "mcc-user-service", path = "/users")
public interface UserClient {


    @PostMapping
    UserResponse createUser(@RequestBody UserRequest request);

    @PutMapping("/{id}")
    UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest request);


    @GetMapping("/email/{email}")
    UserResponse getUserByEmail(@PathVariable String email);
}
