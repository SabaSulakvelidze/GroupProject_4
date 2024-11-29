package com.example.GroupProject_4.FeignClients;

import com.example.GroupProject_4.model.feignEntity.ReqresUsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "Reqres-In", url = "https://reqres.in/api")
public interface ReqresFeign {

    @GetMapping("/users")
    ReqresUsersResponse getAllUsers(@RequestParam(required = false) Integer page,
                                          @RequestParam(required = false) Integer per_page);
}
