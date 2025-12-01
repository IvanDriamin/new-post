package ru.newPost.proj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.newPost.proj.Model.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
}
