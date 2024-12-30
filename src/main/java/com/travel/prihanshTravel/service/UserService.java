package com.travel.prihanshTravel.service;


import com.travel.prihanshTravel.dto.UsersDTO;
import com.travel.prihanshTravel.entity.Users;
import com.travel.prihanshTravel.exception.TravelException;

import java.util.List;

public interface UserService {

    public UsersDTO registerUser(UsersDTO usersDTO) throws TravelException;
    public UsersDTO getUserById(int userId);
    public UsersDTO updateUser(UsersDTO usersDTO);
    public UsersDTO updateUserStatus(int userId, String status);
    public List<UsersDTO> getAllUsers();
    public UsersDTO resetPassword(int userId, String password);
    public UsersDTO forgotPassword(String email);

}
