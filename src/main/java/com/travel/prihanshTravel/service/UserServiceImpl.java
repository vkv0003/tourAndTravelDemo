package com.travel.prihanshTravel.service;

import com.travel.prihanshTravel.dto.UsersDTO;
import com.travel.prihanshTravel.entity.UserStatus;
import com.travel.prihanshTravel.entity.UserType;
import com.travel.prihanshTravel.entity.Users;
import com.travel.prihanshTravel.exception.TravelException;
import com.travel.prihanshTravel.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UsersDTO registerUser(UsersDTO usersDTO) throws TravelException {

        //check if user already exists
        Users user = userRepo.findByUserEmail(usersDTO.getUserEmail());
        if(user != null){
            throw new TravelException("User already exists");
        }

        Users newUser = modelMapper.map(usersDTO, Users.class);
        if (newUser.getCreatedBy() == null) {
            newUser.setCreatedBy(usersDTO.getUserEmail()+" "+usersDTO.getLastName());
        }
        newUser.setCreatedDate(LocalDate.now());
        newUser.setUserStatus(UserStatus.ACTIVE);
        if (newUser.getUserType() == null) {
            newUser.setUserType(UserType.USER);
        }


        return modelMapper.map(userRepo.save(newUser), UsersDTO.class);
    }

    @Override
    public UsersDTO getUserById(int userId) {
        return null;
    }

    @Override
    public UsersDTO updateUser(UsersDTO usersDTO) {
        return null;
    }

    @Override
    public UsersDTO updateUserStatus(int userId, String status) {
        return null;
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UsersDTO resetPassword(int userId, String password) {
        return null;
    }

    @Override
    public UsersDTO forgotPassword(String email) {
        return null;
    }
}
