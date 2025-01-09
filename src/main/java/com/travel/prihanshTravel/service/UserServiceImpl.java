package com.travel.prihanshTravel.service;

import com.travel.prihanshTravel.dto.UsersDTO;
import com.travel.prihanshTravel.entity.UserRole;
import com.travel.prihanshTravel.entity.UserStatus;
import com.travel.prihanshTravel.entity.Users;
import com.travel.prihanshTravel.exception.TravelException;
import com.travel.prihanshTravel.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public UsersDTO registerUser(UsersDTO usersDTO) throws TravelException {

        // check if user already exists
        Users userExists = userRepo.findByUserEmail(usersDTO.getUserEmail());
        System.out.println("++++++++++++++++++++++++++++: " + userExists);
        if (userExists != null) {
            throw new TravelException("User with this email Id already exists!");
        }

        Users user = modelMapper.map(usersDTO, Users.class);
        if (user.getCreatedBy() == null) {
            // newUser.setCreatedBy();
        }
        user.setCreatedDate(LocalDate.now());
        user.setUserStatus(UserStatus.INACTIVE);

        // set userRole fro userDTO to user entity
        user.setUserRole(UserRole.ADMIN);
        user.setPassword("123456");

        // send email to respective user for verfication(set user active) and set
        // password
        // sendEmail(user.getEmail(), "Please click on the link to verify your email and
        // set password");

        // if (user.getUserRole() == null) {
        // throw new TravelException("Please provide role for the user");
        // }

        return modelMapper.map(userRepo.save(user), UsersDTO.class);
    }

    @Override
    public Boolean login(UsersDTO usersDTO, HttpSession session) throws TravelException {

        Users user = userRepo.findByUserEmail(usersDTO.getUserEmail());
        if (user == null) {
            throw new TravelException("User with this email Id does not exists!");
        }

        if (!user.getPassword().equals(usersDTO.getPassword())) {
            throw new TravelException("Password is incorrect! please give correct password!");
        }

        // if(user.isEmailVerified()){
        // throw new TravelException("User is not verified! please verify your email.
        // Click on the link sent to your email to verify");
        // }

        // if(user.getUserStatus() != UserStatus.ACTIVE){
        // throw new TravelException("User is not active! please ask admin to activate
        // your account");
        // }

        user.setUserLoggedIn(true);

        session.setAttribute("user", user);
        session.setAttribute("name", user.getFirstName() + " " + user.getLastName());
        session.setAttribute("role", user.getUserRole());
        // set max inactive interval for session
        session.setMaxInactiveInterval(60 * 60 * 60);

        return true;
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

    @Override
    public void logout(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        System.out.println("User logged out: " + user.getFirstName());
        System.out.println("User logged out: " + user.isUserLoggedIn());
        user.setUserLoggedIn(false);
        if (user != null) {
            session.removeAttribute("user");
            session.removeAttribute("name");
            session.removeAttribute("role");
           // session.invalidate();            
        }

        userRepo.save(user);
    }

    @Override
    public void autoRun() {
        //Users user = userRepo.findByUserRole(UserRole.ADMIN);
        Users users = userRepo.findByUserEmail("vkv@gmail.com");
        if (users == null) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setFirstName("Vivek");
            usersDTO.setLastName("Kumar");
            usersDTO.setUserEmail("vkv@gmail.com");
            usersDTO.setPassword("123456");
            usersDTO.setUserPhone("1234567890");           

            Users newUsers = modelMapper.map(usersDTO, Users.class);
            newUsers.setUserRole(UserRole.ADMIN);
            newUsers.setUserStatus(UserStatus.ACTIVE);
            newUsers.setCreatedBy("System");
            newUsers.setCreatedDate(LocalDate.now());
            userRepo.save(newUsers);
        }
    }

}
