package com.spring.completeregistration.appuser;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
@Data
public class ResetPassword {
    private String email;
    private String password;
    private String resetKey;
    private LocalDateTime resetDate = null;
}
