package ru.newPost.proj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.newPost.proj.Service.PackageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/package")
public class PackageController {
    @Autowired
    private final PackageService PackageService;

    @Autowired
    public PackageController (PackageService PackageSevice) {
        this.PackageService = PackageSevice;
    }

    @GetMapping("/getAll")
    public List<Package> GetAllPackage () {
        return PackageService.getAllPackage();
    }

    @GetMapping("/get/{id}")
    public Optional<Package> GetJournal (@PathVariable Long id) {
        return PackageService.getPackageById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Package> CreatePackage (@RequestBody Package Package/*, EventService eventService*/) {
        Package createdPackage = PackageService.createPackage(Package);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPackage);
        //return eventService.createEvent(Event);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Package> updatePackage (@PathVariable Long id, @RequestBody Package updatedPackage/*Event Event, EventService eventService*/) {
        //return eventService.updateEvent(Event);

        Package updated =  PackageService.updatePackage(id, updatedPackage);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeletePackage (@PathVariable Long id/*, EventService eventService*/) {
        //eventService.deleteEvent(id);

        PackageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }
}
