package com.travel.service.role;

import com.travel.model.AppRole;
import com.travel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<AppRole> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public AppRole findById(long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void save(AppRole appRole) {
        roleRepository.save(appRole);
    }

    @Override
    public void delete(long id) {
        roleRepository.deleteById(id);
    }
}
