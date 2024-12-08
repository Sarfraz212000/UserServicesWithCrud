package in.saffu.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.saffu.entity.UserEntity;
import in.saffu.exception.UserNotFoundException;
import in.saffu.repositroy.UserRepositoy;
import in.saffu.services.USerService;

@Service
public class UserServiceImpl implements USerService {

	@Autowired
	private UserRepositoy userRepo;

	@Override
	public UserEntity saveUsers(UserEntity users) {
		return userRepo.save(users);
	}

	@Override
	public UserEntity getUserById(Long userId) {
		Optional<UserEntity> OptinalId = userRepo.findById(userId);
		if (OptinalId.isPresent()) {
			return OptinalId.get();
		} else {
			throw new UserNotFoundException("user with id " + userId + " not found");
		}

	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public String deleteById(Long userId) {
		Optional<UserEntity> OptinalId = userRepo.findById(userId);
		if (OptinalId.isPresent()) {
			userRepo.deleteById(userId);
			return "Delete";
		}
		throw new UserNotFoundException("user with id " + userId + " not found");
	}

	@Override
	public Boolean updateUsers(Long userId, UserEntity user) {
		Optional<UserEntity> OptinalId = userRepo.findById(userId);
		if (OptinalId.isPresent()) {
			UserEntity users = OptinalId.get();
			BeanUtils.copyProperties(user, users);
			users.setUserId(userId);
			userRepo.save(users);
			return true;
		}
		throw new UserNotFoundException("user with id " + userId + " not found");
	}

}
