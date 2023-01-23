package com.plant_discussion_app.plant_discussion_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.plant_discussion_app.plant_discussion_app.entities.User;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNotFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNameAlreadyExistsException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNameNotFoundException;
import com.plant_discussion_app.plant_discussion_app.repositories.UserRepository;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsResponseDto;



@Service
public class UserServiceImpl implements UserService{

    
    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User createUser(User userDetails) {
         Optional<User> storedUserByUserName = userRepository.findByUsername(userDetails.getUsername());
         if(storedUserByUserName.isPresent()){
             throw new UserNameAlreadyExistsException(userDetails.getUsername());
         }
            userRepository.save(userDetails);
            return userDetails;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        } else{
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNameNotFoundException(username);
        }
    }

    @Override
    public List<UserDetailsResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDetailsResponseDto>usersDto = new ArrayList<>();
            for(User user : users){
                UserDetailsResponseDto userDto = new UserDetailsResponseDto();
                BeanUtils.copyProperties(user, userDto);
                usersDto.add(userDto);
            
        }    
        return usersDto;
    }
    
    public void saveUser(User user){
        userRepository.save(user);
    }

   
}
