package tntshk.server.dao.repo;

import org.springframework.data.repository.CrudRepository;
import tntshk.server.dao.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
