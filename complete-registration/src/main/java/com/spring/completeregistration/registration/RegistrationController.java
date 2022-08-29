package com.spring.completeregistration.registration;

import com.spring.completeregistration.appuser.AppUser;
import com.spring.completeregistration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AppUserService appUserService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


    @PostMapping("/reset")
    public String resetPassword(@RequestParam String email) {
        return appUserService.requestPasswordReset(email);
    }

    @PostMapping("/updatePassword")
    public Optional<AppUser> updatePassword(@RequestParam String email, @RequestParam String token, @RequestParam String newPassword) {
        return appUserService.updatePassword(email,token,newPassword);
    }
}
