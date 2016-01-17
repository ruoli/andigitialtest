package com.andigital.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andigital.model.RestfulDataObject;
import com.andigital.model.SearchResult;

public class RestfulUtil {
	private static Logger LOG = LoggerFactory.getLogger(RestfulUtil.class);
	private static final String CLIENT_ID = "S3YG2222QSVLTGBZHLAIEAJUL54IG5I0X44QJIBB5VRCBQY1";
	private static final String CLIENT_SECRET = "DJV5VL1HBXRYE3HL50LZNE1G3JHURW2TTZPDDPAJKQ4ZJZMM";
	private static final int VERSION = 20130815;
	
	private static ArrayList<SearchResult> tempSearchResultsList;
	
	public static String createQueryUrl(String lag, String lng, String searchTerm) {
		return "https://api.foursquare.com/v2/venues/search?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&v=" + VERSION + "&ll=" + lag + "," + lng + "&query=" + searchTerm;
	}
	
	public static String getPlaceLatitudeAndLongtitude (String place, String latOrLng) {
        try {
            final String geoUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode( place, "UTF-8" );
            final URL url =new URL(geoUrl );

            final Scanner scan = new Scanner(url.openStream ());
            String str = new String ();
            while (scan. hasNext()) {
                str += scan .nextLine ();
            }
            scan .close ();

            final JSONObject obj = new JSONObject(str);
            if (! obj. getString( "status").equals( "OK")) {
                return null ;
            }

            final JSONObject res = obj.getJSONArray( "results").getJSONObject( 0) ;
            final JSONObject loc =
                res.getJSONObject( "geometry").getJSONObject( "location");
            return "" +loc .getDouble (latOrLng );
        } catch (final MalformedURLException e ) {
            LOG.error ("Unable to create GEO URL." , e );
        } catch (final IOException e ) {
            LOG.error ("Unable to create retrieve data from GEOCODE API.", e);
        } catch (final JSONException e ) {
            LOG.error ("Unable to create JSON structure from GEOCODE API.", e);
        }
        return "fail to retrieve info from google api: + " + place ;
    }
	
	public static RestfulDataObject retrieveResultData(String queryUrl) {
		ObjectMapper objectMapper = new ObjectMapper();
		RestfulDataObject data = null;
		 try {
			 data = objectMapper.readValue(new URL(queryUrl), RestfulDataObject.class);
		} catch (JsonParseException e) {
			LOG.error ("Unable to parse JSON." , e );
		} catch (JsonMappingException e) {
			LOG.error ("Unable to map JSON." , e );
		} catch (MalformedURLException e) {
			LOG.error ("Unable to create FourSquare URL." , e );
		} catch (IOException e) {
			LOG.error ("Unable to create retrieve data from FourSquare API." , e );
		}
		return data;
	}

	public static ArrayList<SearchResult> getTempCacheSearchResultsList() {
		return tempSearchResultsList;
	}

	public static void setTempCacheSearchResultsList(ArrayList<SearchResult> tempSearchResultsList) {
		RestfulUtil.tempSearchResultsList = tempSearchResultsList;
	}
	
	
}
