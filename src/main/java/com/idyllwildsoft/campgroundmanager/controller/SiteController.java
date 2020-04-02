package com.idyllwildsoft.campgroundmanager.controller;

import com.idyllwildsoft.campgroundmanager.businessobjects.Site;
import com.idyllwildsoft.campgroundmanager.exceptions.ResourceNotFoundException;
import com.idyllwildsoft.campgroundmanager.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;

    @GetMapping("/sites")
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @GetMapping("/sites/{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable(value = "id") Long siteId)
            throws ResourceNotFoundException {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(() -> new ResourceNotFoundException("Site not found for this id :: " + siteId));
        return ResponseEntity.ok().body(site);
    }
    @PutMapping("/sites")
    public Site updateSite(@Valid @RequestBody Site site) {
        return siteRepository.save(site);
    }

    @PutMapping("/sites/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Site siteFE) throws ResourceNotFoundException {
        Site site = siteRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        site.setWidth(siteFE.getWidth());
        site.setLength(siteFE.getLength());
        site.setElectricity(siteFE.getElectricity());
        site.setElectricityAmp(siteFE.getElectricityAmp());
        site.setWater(siteFE.getWater());
        site.setSewage(siteFE.getSewage());
        site.setSlope(siteFE.getSlope());

        final Site updatedSite = siteRepository.save(site);
        return ResponseEntity.ok(updatedSite);
    }

    @PostMapping("/site")
    public Site createSite(@Valid @RequestBody Site site) {
        return siteRepository.save(site);
    }


    @DeleteMapping("/sites/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long siteId)
            throws ResourceNotFoundException {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(() -> new ResourceNotFoundException("Site not found for this id :: " + siteId));
        siteRepository.delete(site);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
