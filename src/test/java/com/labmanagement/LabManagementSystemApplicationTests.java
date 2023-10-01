package com.labmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.labmanagement.model.entity.Etablissement;
import com.labmanagement.repository.EtablissementRepository;
import com.labmanagement.service.IEtablissementService;

@SpringBootTest
@SpringJUnitConfig
class LabManagementSystemApplicationTests {

	@Autowired
	private IEtablissementService etablissementService;

	@Autowired
	private EtablissementRepository etablissementRepository;

	@Autowired
	private CacheManager cacheManager;

	@Test
	public void testFindEtablissementById_Caching() {
		// Mock the repository
		Etablissement etablissement = new Etablissement();
		etablissement.setId(1L);
		etablissement.setNom("Test Etablissement");

		when(etablissementRepository.findById(1L)).thenReturn(java.util.Optional.of(etablissement));

		// Retrieve the cache by name
		Cache cache = cacheManager.getCache("etablissements");
		assertNotNull(cache);

		// Call the method multiple times
		Etablissement result1 = etablissementService.findEtablissementById(1L);
		Etablissement result2 = etablissementService.findEtablissementById(1L);
		Etablissement result3 = etablissementService.findEtablissementById(1L);

		// Verify that the repository method is called only once
		verify(etablissementRepository, times(1)).findById(1L);

		// Verify that the results are cached
		assertSame(result1, result2);
		assertSame(result1, result3);

		// Verify that the cache hit count is incremented
//		assertTrue(cache.getStatistics().getHits() >= 2);
	}

}
