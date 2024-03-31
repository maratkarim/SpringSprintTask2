package SprintTask2.Spring.web.repository;

import SprintTask2.Spring.web.entities.ApplicationRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AppRepository extends JpaRepository<ApplicationRequest, Long> {
}
