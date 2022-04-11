package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.HAOUserDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.HAOUser;
import edu.tcu.cs.hogwartsartifactsonline.utils.IdWorker;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HAOUserService {

    private HAOUserDao HAOUserDao;
    private IdWorker idWorker;

    public HAOUserService(HAOUserDao HAOUserDao, IdWorker idWorker) {
        this.HAOUserDao = HAOUserDao;
        this.idWorker = idWorker;
    }

    public List<HAOUser> findAll() {
        return HAOUserDao.findAll();
    }

    public HAOUser findById(String userId) {
        return HAOUserDao.findById(userId).get();
    }

    public void save(HAOUser newHAOUser) {
        newHAOUser.setId(idWorker.nextId() + "");
        HAOUserDao.save(newHAOUser);
    }

    public void update(String userId, HAOUser updatedHAOUser) {
        updatedHAOUser.setId(userId);
        HAOUserDao.save(updatedHAOUser);
    }

    public void deleteById(String userId) {
        HAOUserDao.deleteById(userId);
    }
}
