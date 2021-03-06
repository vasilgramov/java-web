package com.authjwt.authjwt.controllers;

import com.authjwt.authjwt.models.binding_models.RegisterUser;
import com.authjwt.authjwt.models.view_models.ViewUser;
import com.authjwt.authjwt.security.JwtTokenUtil;
import com.authjwt.authjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private final UserService userService;

    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserController(UserService userService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody RegisterUser registerUser) {
        try {
            this.userService.register(registerUser);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<ViewUser> getMyProfile(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader).substring(7);

        String username = this.jwtTokenUtil.getUsernameFromToken(token);

        ViewUser viewUser = this.userService.getUserData(username);
        return new ResponseEntity<>(viewUser, HttpStatus.OK);
    }
}
