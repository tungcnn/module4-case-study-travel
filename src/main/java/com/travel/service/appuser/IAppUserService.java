package com.travel.service.appuser;

import com.travel.model.User;

public interface IAppUserService {
    User getUserByUserName(String username);
    User getCurrentUser();
}
