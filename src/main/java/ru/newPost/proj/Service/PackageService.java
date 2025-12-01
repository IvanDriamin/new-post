package ru.newPost.proj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.newPost.proj.Repository.PackageRepository;
import ru.newPost.proj.Model.Package;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {
    private final PackageRepository PackageRepository;

    @Autowired
    public PackageService (PackageRepository PackageRepository) {
        this.PackageRepository = PackageRepository;
    }

    public List<Package> getAllPackage() {
        return PackageRepository.findAll();
    }

    public Optional<Package> getPackageById(Long id) {
        Optional<Package> Package = PackageRepository.findById(id);
        return PackageRepository.findById(id);
    }

    public Package createPackage(Package Package) {
        return PackageRepository.save(Package);
    }

    public Package updatePackage(Long id, Package updatedPackage) {
        Optional<Package> existingPackage = PackageRepository.findById(id);
        if (existingPackage.isPresent()) {
            return PackageRepository.save(updatedPackage);
        } else {
            return null;
        }
    }

    public void deletePackage(Long id) {
        PackageRepository.deleteById(id);
    }
}
