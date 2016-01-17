package com.andigital.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andigital.model.SearchResult;
import com.andigital.service.dao.SavedSearchResultService;

@Service
public class SearchResultServiceImpl implements SavedSearchResultService{
	@PersistenceContext
    EntityManager em;
	
	
	@Transactional
	public void addNewSavedHistory(SearchResult savedResult) {
		System.out.println("trying to save savedResult id: " +savedResult.getId());
		System.out.println("trying to save savedResult address: " +savedResult.getAddress());
		System.out.println("trying to save savedResult contact number: " +savedResult.getContactNumber());
		System.out.println("trying to save savedResult distance: " +savedResult.getDistance());
		System.out.println("trying to save savedResult venuename: " +savedResult.getVenueName());
		em.persist(savedResult);
	}

	@Transactional
	public List<SearchResult> getSavedResultHistory() {
		CriteriaQuery<SearchResult> c = em.getCriteriaBuilder().createQuery(SearchResult.class);
        c.from(SearchResult.class);
        return em.createQuery(c).getResultList();
	}

	@Transactional
	public void deleteSavedVenue(Integer id) {
		SearchResult result = em.find(SearchResult.class, id);
		if (result != null) {
			em.remove(result);
		}
	}

}
