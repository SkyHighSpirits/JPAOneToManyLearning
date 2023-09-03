package com.example.jpaonetomany.Controller;

import com.example.jpaonetomany.Model.Kommune;
import com.example.jpaonetomany.Model.Region;
import com.example.jpaonetomany.Repository.RegionRepository;
import com.example.jpaonetomany.Service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class RegionRESTController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegioner()
    {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @GetMapping("/getregioner/{name}")
    public List<String> getRegionerInKommune(@PathVariable String name)
    {
        Region region = regionRepository.findByNavn(name);
        Set<Kommune> kommuner = region.getKommuner();
        ArrayList<String> kommunenavne = null;
        for (Kommune kommune: kommuner)
        {
            kommunenavne.add(kommune.getNavn());

        }

        return kommunenavne;
    }

    @DeleteMapping("/deleteregion/{kode}")
    public ResponseEntity<String> deleteRegion(@PathVariable int kode)
    {
        Optional<Region> orgRegion = regionRepository.findById(kode);
        if(orgRegion.isPresent())
        {
            regionRepository.deleteById(kode);
            return ResponseEntity.ok("Region Deleted");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }

    @PostMapping("/postregion/{kode}")
    public ResponseEntity<Region> putRegion(@PathVariable String kode, @RequestBody Region region)
    {
        return null;
    }
}
