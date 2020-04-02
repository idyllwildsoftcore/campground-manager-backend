package com.idyllwildsoft.campgroundmanager.repository;

import com.idyllwildsoft.campgroundmanager.businessobjects.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
