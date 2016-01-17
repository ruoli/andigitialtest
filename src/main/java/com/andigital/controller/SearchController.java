package com.andigital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andigital.model.RestfulDataObject;
import com.andigital.model.SearchResult;
import com.andigital.model.Venues;
import com.andigital.service.SavedSearchResultService;

import static com.andigital.utility.RestfulUtil.*;

@Controller
public class SearchController {
	
	
	@Autowired
	private SavedSearchResultService savedSearchResultService;
	
	@RequestMapping("/index")
    public String listHistoryResults(Map<String, Object> map, HttpServletRequest request) {
		
        map.put("searchResultsList", getTempCacheSearchResultsList());

        return "index";
    }
	
	@RequestMapping("/save/{listposition}")
	public String addMyFavouriteToDatabase(@PathVariable("listposition") int listPosition) {
		savedSearchResultService.addNewSavedHistory(getTempCacheSearchResultsList().get(listPosition));
		return "redirect:/favourite";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchResult(HttpServletRequest request) {
		String searchTerm = request.getParameter("searchterm");
		String location = request.getParameter("location");
		
		String lat = getPlaceLatitudeAndLongtitude(location, "lat");
		String lng = getPlaceLatitudeAndLongtitude(location, "lng");
		
		
     	String fourSquareQueryUrl = createQueryUrl(lat, lng, searchTerm);
    	RestfulDataObject data = retrieveResultData(fourSquareQueryUrl);
    	
    	if (data != null) {
    		createSearchListForHomePageDisplay(data);
    	}
    	
        return "redirect:/index";
    }
	
	private void createSearchListForHomePageDisplay(RestfulDataObject data) {
		ArrayList<SearchResult> searchResultsList = new ArrayList<SearchResult>();  
		for(Venues venue: data.getResponse().getVenues()) {
			SearchResult result = new SearchResult();
			result.setVenueName(venue.getName());
			result.setAddress(venue.getLocation().getAddress());
			result.setDistance(venue.getLocation().getDistance());
			result.setContactNumber(venue.getContact().getPhone());
			searchResultsList.add(result);
		}

		setTempCacheSearchResultsList(searchResultsList);
	}
}
