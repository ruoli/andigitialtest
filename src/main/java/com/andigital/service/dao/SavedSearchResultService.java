package com.andigital.service.dao;

import java.util.List;

import com.andigital.model.SearchResult;

public interface SavedSearchResultService {
	public void addNewSavedHistory(SearchResult seartchResult);
	public List<SearchResult> getSavedResultHistory();
	public void deleteSavedVenue(Integer id);
}
