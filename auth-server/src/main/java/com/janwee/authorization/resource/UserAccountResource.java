package com.janwee.authorization.resource;

import com.janwee.authorization.domain.User;
import com.janwee.authorization.domain.UserService;
import com.janwee.authorization.resource.presentation.ChangingUserInfoCommand;
import com.janwee.authorization.resource.presentation.RegisteringUserCommand;
import com.janwee.authorization.resource.presentation.UserPresentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(tags = {"User Management API"})
@RequestMapping("/user")
public class UserAccountResource {
    private UserService userService;

    @Autowired
    public UserAccountResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public UserPresentation register(@RequestBody RegisteringUserCommand cmd) {
        return Optional.ofNullable(userService.register(cmd.toUser())).map(UserPresentation::fromUser)
                .orElse(null);
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改用户")
    public UserPresentation changeUserInfo(@RequestBody ChangingUserInfoCommand cmd) {
        return Optional.ofNullable(userService.changeUserInfo(cmd.toUser())).map(UserPresentation::fromUser)
                .orElse(null);
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "查询用户")
    public UserPresentation user(@PathVariable String username) {
        return Optional.ofNullable(userService.loadUserByUsername(username))
                .map(user -> UserPresentation.fromUser((User) user)).orElse(null);
    }

    @GetMapping
    @ApiOperation(value = "查询所有用户")
    public List<UserPresentation> users() {
        return userService.users().stream().map(UserPresentation::fromUser).collect(Collectors.toList());
    }
}
