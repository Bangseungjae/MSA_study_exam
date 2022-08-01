package com.example.catalogservice;

import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CatalogService catalogService;

    @EventListener(ApplicationReadyEvent.class)
    public void dataInit() {
        CatalogEntity catalogEntity1 = new CatalogEntity("CATALOG-001", "Berlin", 100, 1500);
        CatalogEntity catalogEntity2 = new CatalogEntity("CATALOG-002", "Tokyo", 110, 1000);
        CatalogEntity catalogEntity3 = new CatalogEntity("CATALOG-003", "Stockholm", 120, 2000);

        catalogService.save(catalogEntity1);
        catalogService.save(catalogEntity2);
        catalogService.save(catalogEntity3);
    }


}
