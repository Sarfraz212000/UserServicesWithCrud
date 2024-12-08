package in.saffu.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saffu.entity.UserEntity;

public interface UserRepositoy extends JpaRepository<UserEntity, Long>{

}
