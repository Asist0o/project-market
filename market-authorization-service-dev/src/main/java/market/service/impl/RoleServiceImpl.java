package market.service.impl;

import lombok.AllArgsConstructor;
import market.entity.Role;
import market.repository.RoleRepository;
import market.service.RoleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;


@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getUserRole() {
        return roleRepository.getRoleByAuthority("ROLE_USER").orElseThrow(
                () -> new EntityNotFoundException("Role not found by name: ROLE_USER")
        );
    }

}
