package StudentManagment.service.impl;

import StudentManagment.dto.req.AuthRequestDto;
import StudentManagment.dto.res.AuthResponseDto;
import StudentManagment.repository.UserRepository;
import StudentManagment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public AuthResponseDto register(AuthRequestDto dto) {
        return null;
    }

    @Override
    public AuthResponseDto login(AuthRequestDto dto) {
        return null;
    }
}
