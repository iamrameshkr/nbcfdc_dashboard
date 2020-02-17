package in.gov.nbcfdc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

	
	
	@Path("/")
	public class Loan {
		
		
		@GET
		@Path("/yearly_amount")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject yearlyAmount() {
		JSONObject obj = LoanResource.getYearlyAmount();
		return obj;
		}
		
		
		@GET
		@Path("/yearly_ben")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject yearlyBen() {
		JSONObject obj = LoanResource.getYearlyBen();
		return obj;
		}
		
		
		@GET
		@Path("/cumulative_amount")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject cumulativeAmount() {
		JSONObject obj = LoanResource.getCumulativeAmount();
		return obj;
		}
		
		@GET
		@Path("/cumulative_ben")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject cumulativeBen() {
		JSONObject obj = LoanResource.getCumulativeBen();
		return obj;
		}
		
		
		@GET
		@Path("/amount_2019_20")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject amount_2019_20() {
		JSONObject obj = LoanResource.getAmount2019_20();
		return obj;
		}
		
		
		@GET
		@Path("/ben_2019_20")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject ben_2019_20() {
		JSONObject obj = LoanResource.getBen2019_20();
		return obj;
		}
		
		@GET
		@Path("/amount_2018_19")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject amount_2018_19() {
		JSONObject obj = LoanResource.getAmount2018_19();
		return obj;
		}
		
		
		@GET
		@Path("/ben_2018_19")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject ben_2018_19() {
		JSONObject obj = LoanResource.getBen2018_19();
		return obj;
		}
		
		
		@GET
		@Path("/amount_2017_18")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject amount_2017_18() {
		JSONObject obj = LoanResource.getAmount2017_18();
		return obj;
		}
		
		
		@GET
		@Path("/ben_2017_18")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject ben_2017_18() {
		JSONObject obj = LoanResource.getBen2017_18();
		return obj;
		}
		
		
		@GET
		@Path("/amount_2016_17")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject amount_2016_17() {
		JSONObject obj = LoanResource.getAmount2016_17();
		return obj;
		}
		
		
		@GET
		@Path("/ben_2016_17")
	    @Produces(MediaType.APPLICATION_JSON)
		public static JSONObject ben_2016_17() {
		JSONObject obj = LoanResource.getBen2016_17();
		return obj;
		}
		
	
		
 
//	public static void main(String[] args) {
//		//	LoanResource.getAmount2016_17();
//			LoanResource.getAmount2017_18();
//
//	}
	
}
