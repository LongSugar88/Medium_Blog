package com.example.demo.api;

import com.example.demo.ImplService.AccountServiceImpl;
import com.example.demo.jwt.JwtUntil;
import com.example.demo.model.Account;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.jwt.AuthRequest;
import com.example.demo.model.jwt.HttpResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {
    @Autowired
    JwtUntil jwtUntil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public HttpResponse authenticateUser(@RequestBody AuthRequest authRequest) {
        HttpResponse response = new HttpResponse();
        Account resposeAccount = this.accountService.findAccountByEmail(authRequest.getEmail());
        // Xác thực từ username và password.
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );

            // Nếu không xảy ra exception tức là thông tin hợp lệ
            // Set thông tin authentication vào Security Context
            SecurityContextHolder.getContext().setAuthentication(authentication);
            response.setMessage("Login success");
            response.setToken(jwtUntil.generateToken(authRequest.getEmail()));
            resposeAccount.setEmail(authRequest.getEmail());
            response.setAccount_id(resposeAccount.getId());
        }
        catch (ExpiredJwtException e){
            response.setMessage("Expired Jwt token");
        }
        catch (Exception ex){
            response.setMessage("Email or password is not correct");
        }

        // Trả về jwt cho người dùng.
        String jwt = jwtUntil.generateToken(authRequest.getEmail());
        return response;
    }


}
