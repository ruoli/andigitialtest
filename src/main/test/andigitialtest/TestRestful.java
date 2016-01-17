package andigitialtest;



import static com.andigital.utility.RestfulUtil.getPlaceLatitudeAndLongtitude;
import static com.andigital.utility.RestfulUtil.retrieveResultData;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.andigital.model.RestfulDataObject;

public class TestRestful {
	private final String FAIL_TO_RETRIEVE_INFO_FROM_GEOCODE = "fail to retrieve info from google api";
	private final String MOCK_TEST_QUERY = "https://api.foursquare.com/v2/venues/search?client_id=S3YG2222QSVLTGBZHLAIEAJUL54IG5I0X44QJIBB5VRCBQY1&client_secret=DJV5VL1HBXRYE3HL50LZNE1G3JHURW2TTZPDDPAJKQ4ZJZMM&v=20120609&ll=40.7,-74%20&query=sushi";
	@Before
	public void setup(){
		
	}
	
	@Test
	public void getPlaceLatitudeAndLongtitudeIsNotContainingFailingInformation() {
		String lat = getPlaceLatitudeAndLongtitude("London", "lat");
		String lng = getPlaceLatitudeAndLongtitude("London", "lng");
		assertFalse("able to get lat from GEOCODE API", lat.contains(FAIL_TO_RETRIEVE_INFO_FROM_GEOCODE) || lng.contains(FAIL_TO_RETRIEVE_INFO_FROM_GEOCODE));
	}
	
	@Test
	public void ableToRetrieveResultDataByQueryFourSquareAPI() {
		RestfulDataObject testDataObj = retrieveResultData(MOCK_TEST_QUERY);
		assertTrue("able to retrieve list of venues", testDataObj.getResponse().getVenues().size() > 0);
	}
	
}
