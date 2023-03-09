package com.prosoft.service;

import com.prosoft.domain.UserAccess;
import com.prosoft.repository.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserAccessServiceImpl implements UserAccessService {

    private final UserAccessRepository userAccessRepository;

    @Autowired
    public UserAccessServiceImpl(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    @Override
    public UserAccess getUserAccess(String login) {
        List<UserAccess> userAccessList = userAccessRepository.findByLogin(login);
        return userAccessList.size() == 1 ? userAccessList.get(0) : null;
    }
}
