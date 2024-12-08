package in.saffu.services;

import java.util.List;

import in.saffu.entity.UserEntity;

public interface USerService {
	
	public UserEntity saveUsers(UserEntity users);
	
	public UserEntity getUserById(Long userId);
	
	public List<UserEntity> getAllUsers();
	
	public String deleteById(Long userId);
	
	public Boolean updateUsers(Long userId,UserEntity user);

}
