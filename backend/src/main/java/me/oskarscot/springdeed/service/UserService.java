package me.oskarscot.springdeed.service;

import me.oskarscot.springdeed.database.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }



}
