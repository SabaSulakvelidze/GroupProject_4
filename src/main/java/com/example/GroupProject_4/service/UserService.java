package com.example.GroupProject_4.service;

import com.example.GroupProject_4.FeignClients.ReqresFeign;
import com.example.GroupProject_4.exception.ResourceNotFoundException;
import com.example.GroupProject_4.model.entity.UserEntity;
import com.example.GroupProject_4.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private ReqresFeign reqresFeign;

    @PostConstruct
    public void importUsersFromFeign(){
        reqresFeign.getAllUsers(0, 1_000).getData()
                .stream()
                //.peek(System.out::println)
                .map(UserEntity::toUserEntity)
                .forEach(this::addNewUser);
    }

    public UserEntity addNewUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public Page<UserEntity> getAllUsers(Integer pageNumber, Integer pageSize, Sort.Direction direction, String sortBy) {
        return userRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy)));
    }

    public UserEntity getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id %d was not found".formatted(userId)));
    }

    public String deleteUser(Long userId){
        userRepository.delete(getUserById(userId));
        return "User with id %d was deleted".formatted(userId);
    }

    @Transactional
    public UserEntity editUser(Long userId, UserEntity userEntity){
        UserEntity userToEdit = getUserById(userId);
        userToEdit.setFirstName(userEntity.getFirstName());
        userToEdit.setLastName(userEntity.getLastName());
        userToEdit.setUserName(userEntity.getUserName());
        userToEdit.setBirthDate(userEntity.getBirthDate());
        return userToEdit;
    }
}
