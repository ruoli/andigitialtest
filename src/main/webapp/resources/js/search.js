$(document).ready(function(){

});

function doAjaxCall(endpoint, lat, lng, searchterm) {
	$.ajax({ 
   	 url: endpoint + "/" + lat + "/" + lng + "/" + searchterm, 
   	 type: 'POST', 
   	 data: {  
   		 	'type': updateType,
   	        'status': status
   	    }, 
   	 success: function (data) { 
   		 $(recallType + id).text(status);
   		console.log("done! status is " + status);
   	 }, 
   	 statusCode: { 
   		 404: function (content) { console.log("cannot find resource"); }, 
   		 505: function (content) { console.log("internal server error"); } 
   		 }, 
   		 error: function (req, status, errorObj) { 
   			 console.log("ajax call failed");
   		 }
    });
}

