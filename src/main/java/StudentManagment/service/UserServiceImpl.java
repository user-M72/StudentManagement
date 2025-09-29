package StudentManagment.service;

import StudentManagment.dto.UserRequestDto;
import StudentManagment.dto.UserResponseDto;
import StudentManagment.entity.User;
import StudentManagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto update(UUID id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
