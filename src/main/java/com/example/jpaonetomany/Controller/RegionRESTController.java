package com.example.jpaonetomany.Controller;

import com.example.jpaonetomany.Model.Region;
import com.example.jpaonetomany.Repository.RegionRepository;
import com.example.jpaonetomany.Service.ApiServiceGetRegioner;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/postregion/{kode}")
    public ResponseEntity<Region> putRegion(@PathVariable String kode, @RequestBody Region region)
    {
        return null;
    }
}
