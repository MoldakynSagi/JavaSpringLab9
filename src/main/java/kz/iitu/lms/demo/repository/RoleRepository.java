package kz.iitu.lms.demo.repository;

import kz.iitu.lms.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
