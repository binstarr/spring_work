package com.example.demo.controller;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    @GetMapping("/user")
    public User get(@Size(min = 2, max = 10) @RequestParam String name, @Min(value = 2) @RequestParam Integer age) {
        System.out.println("GET 코드 실행 시작");
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user")
    public User post(@Valid @RequestBody User user) {
        System.out.println("POST 코드 실행 시작");
        System.out.println("user : " + user);
        return user;
    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        System.out.println("==========");
//
//        System.out.println("controller 안에서 직업 예외 처리도 가능하다 ~");
//        System.out.println(e.getLocalizedMessage());
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
//    }

}