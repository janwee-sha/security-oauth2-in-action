package com.janwee.authorization.resource;

import com.janwee.authorization.application.UserAccountApplicationService;
import com.janwee.authorization.resource.presentation.ChangingUserInfoCommand;
import com.janwee.authorization.resource.presentation.RegisteringUserCommand;
import com.janwee.authorization.resource.presentation.UserPresentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = {"User Management API"})
@RequestMapping("/user")
public class UserAccountResource {
    private final UserAccountApplicationService userAccountAppService;

    @Autowired
    public UserAccountResource(UserAccountApplicationService userAccountAppService) {
        this.userAccountAppService = userAccountAppService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public void register(@RequestBody RegisteringUserCommand cmd) {
        userAccountAppService.register(cmd.toUser());
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改用户")
    public void changeUserInfo(@RequestBody ChangingUserInfoCommand cmd) {
        userAccountAppService.changeUserInfo(cmd.toUser());
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "查询用户")
    public ResponseEntity<UserPresentation> user(@PathVariable String username) {
        return ResponseEntity.ok(UserPresentation.fromUser(userAccountAppService.user(username)));
    }

    @GetMapping
    @ApiOperation(value = "查询所有用户")
    public ResponseEntity<List<UserPresentation>> users() {
        return ResponseEntity.ok(userAccountAppService.users().stream().map(UserPresentation::fromUser)
                .collect(Collectors.toList()));
    }
}
