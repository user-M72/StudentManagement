package StudentManagment.service;

import StudentManagment.dto.UserRequestDto;
import StudentManagment.dto.UserResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import StudentManagment.mapper.UserMapper;
import StudentManagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;
    @Autowired private UserMapper userMapper;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private RoleService roleService;

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
        Set<Role> roleList = roleService.getByIdList(userRequestDto.roleIds());
        User user =userMapper.toEntity(userRequestDto, roleList, passwordEncoder.encode(userRequestDto.password()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(UUID id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
