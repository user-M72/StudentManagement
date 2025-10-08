package StudentManagment.API;

import StudentManagment.dto.req.AuthRequestDto;
import StudentManagment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/v1")
public class AuthApi {

    @Autowired
    private AuthService authService;

    @PostMapping
    public String login(@RequestBody AuthRequestDto dto){
        return authService.login(dto);

    }

    @PostMapping
    public String register(@RequestBody AuthRequestDto dto){
        return authService.register(dto);
    }
}
