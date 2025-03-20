package com.micael1ma.dscommerce.services;

import com.micael1ma.dscommerce.entities.User;
import com.micael1ma.dscommerce.services.execptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void valideteSelfOrAdmin(long userId) {
        User me = userService.authenticate();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
