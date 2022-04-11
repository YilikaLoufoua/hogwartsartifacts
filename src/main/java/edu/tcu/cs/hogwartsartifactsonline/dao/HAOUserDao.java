package edu.tcu.cs.hogwartsartifactsonline.dao;

import edu.tcu.cs.hogwartsartifactsonline.domain.HAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HAOUserDao extends JpaRepository<HAOUser, String> {
}
