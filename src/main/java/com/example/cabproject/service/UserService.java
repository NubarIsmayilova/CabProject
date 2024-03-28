package com.example.cabproject.service;

import com.example.cabproject.dto.UserResponseDto;
import com.example.cabproject.entity.UserEntity;
import com.example.cabproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserResponseDto> getAllUsers(){
        List<UserEntity> all = userRepository.findAll();
        return all.stream().map(x -> modelMapper.map(x, UserResponseDto.class)).toList();
    }

    public void userRegistration(){

    }

    public void deleteAccount(){

    }

    public void updateAccountDetails(){

    }



}
