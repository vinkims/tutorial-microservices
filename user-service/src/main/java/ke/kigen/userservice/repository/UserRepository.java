package ke.kigen.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ke.kigen.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
