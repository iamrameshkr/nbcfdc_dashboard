package in.gov.nbcfdc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;


@Path("/")
public class Skill {
	
	
	
	@GET
	@Path("/yearly_skill_amount")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject yearlyAmountSanctioned() {
	JSONObject obj = SkillResource.getYearlyAmountSanctioned();
	return obj;
	}
	
	
	@GET
	@Path("/yearly_trainee_trained")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject yearlyTraineesTrained() {
	JSONObject obj = SkillResource.getYearlyTraineesTrained();
	return obj;
	}
	
	
	@GET
	@Path("/cumulative_amount_sanctioned")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject cumulativeSkillAmountSanctioned() {
	JSONObject obj = SkillResource.getCumulativeAmountSanctioned();
	return obj;
	}
	
	
	@GET
	@Path("/cumulative_trainees_trained")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject cumulativeTraineesTrained() {
	JSONObject obj = SkillResource.getCumulativeTraineesTrained();
	return obj;
	}
	
	
	
	
	@GET
	@Path("/amount_sanctioned_2019_20")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject amount_al_2019_20() {
	JSONObject obj = SkillResource.getAmountSanctioned2019_20();
	return obj;
	}
	
	
	@GET
	@Path("/trainee_2019_20")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject trainee_2019_20() {
	JSONObject obj = SkillResource.getTraineesTrained2019_20();
	return obj;
	}
	
	@GET
	@Path("/amount_sanctioned_2018_19")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject amount_db_2018_19() {
	JSONObject obj = SkillResource.getAmountSanctioned2018_19();
	return obj;
	}
	
	
	@GET
	@Path("/trainee_2018_19")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject trainee_2018_19() {
	JSONObject obj = SkillResource.getTraineesTrained2018_19();
	return obj;
	}
	
	
	@GET
	@Path("/amount_sanctioned_2017_18")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject amount_db_2017_18() {
	JSONObject obj = SkillResource.getAmountSanctioned2017_18();
	return obj;
	}
	
	
	@GET
	@Path("/trainee_2017_18")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject trainee_2017_18() {
	JSONObject obj = SkillResource.getTraineesTrained2017_18();
	return obj;
	}
	
	@GET
	@Path("/amount_sanctioned_2016_17")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject amount_db_2016_17() {
	JSONObject obj = SkillResource.getAmountSanctioned2016_17();
	return obj;
	}
	
	
	@GET
	@Path("/trainee_2016_17")
    @Produces(MediaType.APPLICATION_JSON)
	public static JSONObject trainee_2016_17() {
	JSONObject obj = SkillResource.getTraineesTrained2016_17();
	return obj;
	}
	
	

//	public static void main(String[] args) {
//	//	SkillResource.instituteEmployment1617();
//	//	SkillResource.getCumulativeTraineesTrained();
//	//	SkillResource.getAmountDisbursed2017_18();
//		//SkillResource.getTraineesTrained2018_19();
//		SkillResource.getYearlyTraineesTrained();
//	}
		
	
}
