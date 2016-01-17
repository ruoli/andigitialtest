package com.andigital.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andigital.model.SearchResult;
import com.andigital.service.dao.SavedSearchResultService;

@Controller
public class FavouriteResultController {

	@Autowired
	private SavedSearchResultService savedSearchResultService;

    @RequestMapping("/favourite")
    public String listFavouriteVenues(Map<String, Object> map) {

        map.put("favouriteList", savedSearchResultService.getSavedResultHistory());

        return "favourite";
    }

    @RequestMapping(value = "/delete/{resultid}", method = RequestMethod.POST)
    public String deleteVenue(@PathVariable("resultid") Integer resultId) {
    	savedSearchResultService.deleteSavedVenue(resultId);
        return "redirect:/favourite";
    }
}
