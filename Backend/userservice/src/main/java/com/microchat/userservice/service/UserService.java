package com.microchat.userservice.service;

import com.microchat.userservice.exception.MicroServiceException;

public interface UserService {
    public Long gerUser(Long id);
    public Long getUser(String name);
    public Long getUserByEmail(String email);
}
