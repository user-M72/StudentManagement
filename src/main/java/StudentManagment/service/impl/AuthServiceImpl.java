package StudentManagment.service.impl;

import StudentManagment.dto.req.AuthRequestDto;
import StudentManagment.dto.res.AuthResponseDto;
import StudentManagment.entity.User;
import StudentManagment.repository.UserRepository;
import StudentManagment.service.AuthService;
import StudentManagment.service.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthTokenService authtokenService;

    @Override
    public AuthResponseDto register(AuthRequestDto dto) {
        if (repository.findByUsername(dto.username()).isPresent()){
            throw new RuntimeException("User not found");
        };

        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(encoder.encode(dto.password()));
        repository.save(user);

        String token = authtokenService.generateToken(user.getUsername());

        return new AuthResponseDto(user.getUsername(), token);
    }

    @Override
    public AuthResponseDto login(AuthRequestDto dto) {
        User user = repository.findByUsername(dto.username())
                .orElseThrow(()-> new RuntimeException("User not found"));

        if (!encoder.matches(dto.password(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String token = authtokenService.generateToken(user.getUsername());
        return new AuthResponseDto(user.getUsername(), token);
    }
}