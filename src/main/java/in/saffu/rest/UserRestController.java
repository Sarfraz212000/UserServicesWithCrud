package in.saffu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.saffu.entity.UserEntity;
import in.saffu.services.USerService;

@RestController
public class UserRestController {

	@Autowired
	private USerService uSerService;

	@PostMapping("/user")
	public ResponseEntity<UserEntity> saveUsers(@RequestBody UserEntity users) {
		UserEntity savedUsers = uSerService.saveUsers(users);
		return new ResponseEntity<UserEntity>(savedUsers, HttpStatus.OK);

	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserEntity> gerUserById(@PathVariable Long userId) {
		UserEntity user = uSerService.getUserById(userId);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> allUsers = uSerService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(allUsers, HttpStatus.OK);
	}

	@DeleteMapping("/delete/user/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
		String deleteUser = uSerService.deleteById(userId);
		if (deleteUser.equals("Delete")) {
			return new ResponseEntity<String>(" User deleted successfully with userId=" + userId, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(" User successfully Not deleted userId" + userId, HttpStatus.OK);
		}

	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<String> updateUserServices(@PathVariable Long userId,@RequestBody UserEntity user){
		Boolean status = uSerService.updateUsers(userId, user);
		if (status) {
			return new ResponseEntity<String>("update successfully",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("update not successfully",HttpStatus.NOT_FOUND);
		}
	}

}
