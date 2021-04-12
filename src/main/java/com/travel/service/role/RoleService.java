package com.travel.service.role;

import com.travel.model.AppRole;
import com.travel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppRole findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Iterable<AppRole> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public AppRole findById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public void save(AppRole appRole) {
        roleRepository.save(appRole);
    }

    @Override
    public void delete(long id) {
        roleRepository.delete(id);
    }
}
