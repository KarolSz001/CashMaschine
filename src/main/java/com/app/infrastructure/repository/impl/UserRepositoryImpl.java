package com.app.infrastructure.repository.impl;

import com.app.domain.user.User;
import com.app.domain.user.UserRepository;
import com.app.infrastructure.repository.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;


    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByUsername(username);
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(jpaUserRepository.save(user));
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return jpaUserRepository.saveAll(users);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public List<User> findAllById(List<Long> users) {
        return jpaUserRepository.findAllById(users);
    }

    @Override
    public Optional<User> findById(Long idUser) {
        return jpaUserRepository.findById(idUser);
    }

    @Override
    public Optional<User> delete(Long userId) {
        var item =  findById(userId);
        jpaUserRepository.deleteById(userId);
        return item;

    }
}
