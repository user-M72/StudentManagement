package StudentManagment.service.impl;

import StudentManagment.dto.req.UserRequestDto;
import StudentManagment.dto.res.UserResponseDto;
import StudentManagment.entity.Role;
import StudentManagment.entity.User;
import StudentManagment.mapper.UserMapper;
import StudentManagment.repository.UserRepository;
import StudentManagment.service.RoleService;
import StudentManagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public List<UserResponseDto> get() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getById(UUID id) {
        return userRepository.findById(id).map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto update(UUID id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        Set<Role> roles = roleService.getByIdList(userRequestDto.roleIds());
        userMapper.updateFromDto(userRequestDto, roles, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
