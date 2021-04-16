package com.travel.service.role;

import com.travel.model.Role;
import com.travel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
