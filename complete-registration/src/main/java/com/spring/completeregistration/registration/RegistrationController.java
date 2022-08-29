package com.spring.completeregistration.registration;

import com.spring.completeregistration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public String updatePassword(@RequestParam String email, @RequestParam String newPassword) {
        return appUserService.changePassword(email,newPassword);
    }

    // update password

}
