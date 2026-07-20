package com.saonnet.ludo.leaderboard.repository;

import com.saonnet.ludo.leaderboard.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> { }
