package com.connectify.eurekaserver.user.service;

import com.connectify.eurekaserver.user.model.User;
import com.connectify.eurekaserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        rabbitTemplate.convertAndSend("user.exchange", "user.routingkey", savedUser);
        return savedUser;
    }
}