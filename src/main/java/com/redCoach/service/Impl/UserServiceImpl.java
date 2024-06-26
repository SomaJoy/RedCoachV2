package com.redCoach.service.Impl;

import com.redCoach.entity.User;
import com.redCoach.payload.LoginDto;
import com.redCoach.payload.UserDto;
import com.redCoach.repository.UserRepository;
import com.redCoach.service.JwtService;
import com.redCoach.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    @Override
    public User addUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        user.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(4)));
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public String verifyLogin(LoginDto loginDto) {
        Optional<User> opUser = userRepository.findByUserName(loginDto.getUserName());
        if(opUser.isPresent()){
            User user = opUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(), user.getPassword())){
                return jwtService.generateToken(user);
            }
        }
        return null;
    }

    public UserDto mapToDto(User user){
        UserDto dto = modelMapper.map(user, UserDto.class );
        return dto;
    }
    public  User mapToEntity(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

}
