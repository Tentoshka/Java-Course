package tntshk.tracker.dao.repo;

import org.springframework.data.repository.CrudRepository;
import tntshk.tracker.dao.Point;

public interface PointRepository extends CrudRepository<Point, Integer> {
}
