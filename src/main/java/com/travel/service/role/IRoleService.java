package com.travel.service.role;

import com.travel.model.Role;
import com.travel.service.IGeneral;

public interface IRoleService extends IGeneral<Role> {
    Role findByName(String name);
}
