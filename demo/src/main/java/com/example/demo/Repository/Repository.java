package com.example.demo.Repository;
import com.example.demo.model.Models;
import com.example.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
public class Repository {


    public interface UserRepository extends JpaRepository<Models.User, String> {}

    public interface RoleRepository extends JpaRepository<Models.Role, Long> {}

    public interface TaskRepository extends JpaRepository<Models.Task, Long> {}

    public interface StatusRepository extends JpaRepository<Status, Long> {}

    public interface OrganizationRepository extends JpaRepository<Models.Organization, Long> {}

    public interface FavoriteRepository extends JpaRepository<Models.Favorite, Long> {}
}
