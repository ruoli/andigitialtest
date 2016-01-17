package andigitialtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.andigital.model.SearchResult;
import com.andigital.service.SavedSearchResultService;


public class TestDAO {
	@Autowired
	private SavedSearchResultService savedSearchResultService;
	SearchResult mockSearchResltObj;
	@Before
	public void setup() {
		mockSearchResltObj = new SearchResult();
		mockSearchResltObj.setAddress("1 abc road");
		mockSearchResltObj.setContactNumber("07838888372");
		mockSearchResltObj.setDistance("333");
		mockSearchResltObj.setVenueName("KFC");
		savedSearchResultService.addNewSavedHistory(mockSearchResltObj);
	}
	
	@Test
	public void ableToAddAndFindFavouriteVenueInDatabase(){
		assertTrue("found the correct record", savedSearchResultService.getSavedResultHistory().get(0).getVenueName().equals("KFC"));
	}
	
	@Test
	public void ableToDeleteResultEntryFromDatabase(){
		savedSearchResultService.deleteSavedVenue(0);
		assertTrue("record deleted", savedSearchResultService.getSavedResultHistory().size() == 0);
	}
	
}
