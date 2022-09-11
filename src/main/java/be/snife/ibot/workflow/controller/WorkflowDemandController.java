package be.snife.ibot.workflow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.snife.ibot.workflow.in.dto.WorkflowDemand;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@RestController
@RequestMapping(path="/api/demands", produces = "application/json")
@Slf4j
public class WorkflowDemandController {
	
	//private final WorkflowDemandService wds;
	
	//public WorkflowDemandController(WorkflowDemandService wds) {
	//	this.vds = vds;
	//}
	
	@PostMapping
	public ResponseEntity<?> submitDemand(@RequestBody WorkflowDemand demand) {
		log.info("Creating a Demand with DemandId = "+demand.getDemandId() + " ...");
		//String demandID = ds.createDemand(demand);
		String workflowProcessId = "123456";
		log.info("Workflow process created with WorkflowProcessId : "+workflowProcessId);
		
		
		ResponseEntity<?> result = ResponseEntity.status(HttpStatus.ACCEPTED).body(workflowProcessId);

		return result;
		
	}


}
