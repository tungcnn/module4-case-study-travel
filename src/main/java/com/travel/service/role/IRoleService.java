package com.travel.service.role;

import com.travel.model.Role;
import com.travel.service.IGeneral;

public interface IRoleService extends IGeneral<Role> {
    Iterable<Role> findAll();
    Role findByName(String name);
}
