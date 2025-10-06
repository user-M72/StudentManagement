package StudentManagment.service;

import StudentManagment.dto.req.AuthRequestDto;
import StudentManagment.dto.res.AuthResponseDto;

public interface AuthService {

    AuthResponseDto register(AuthRequestDto dto);
    AuthResponseDto login(AuthRequestDto dto);
}
