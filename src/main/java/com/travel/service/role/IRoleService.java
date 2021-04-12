package com.travel.service.role;

import com.travel.model.AppRole;
import com.travel.service.IGeneral;

public interface IRoleService extends IGeneral<AppRole>{
    AppRole findByName(String name);
}
