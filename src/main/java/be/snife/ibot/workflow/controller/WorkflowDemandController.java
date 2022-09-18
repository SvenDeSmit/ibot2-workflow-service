package be.snife.ibot.workflow.controller;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.snife.ibot.workflow.in.dto.WorkflowDemand;
import be.snife.ibot.workflow.in.dto.WorkflowDemandReply;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/api/demands", produces = "application/json")
@Slf4j
public class WorkflowDemandController {
	
	//private final WorkflowDemandService wds;
	
	//public WorkflowDemandController(WorkflowDemandService wds) {
	//	this.vds = vds;
	//}
	
	//ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
	//RuntimeService rs = pe.getRuntimeService();
	
	@PostMapping
	public ResponseEntity<WorkflowDemandReply> submitDemand(@RequestBody WorkflowDemand wfDemand) {
		log.info("Submitting a demand with demand id = "+wfDemand.getDemandId() + " ...");
		log.info(wfDemand.toString());
		
		ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
		RuntimeService rs = pe.getRuntimeService();
		Map<String,Object> vars = new HashMap<String,Object>();
		vars.put("dossierId", wfDemand.getDossierId());
		vars.put("demandId", wfDemand.getDemandId());
		
		ObjectValue redl = Variables.objectValue(wfDemand.getRealEstateDemandList()).serializationDataFormat(Variables.SerializationDataFormats.JAVA).create();		
		vars.put("realEstateDemandList", redl);
				
		ProcessInstance pi = rs.startProcessInstanceByKey("simple_demand_process_1", vars);
		String workflowProcessId = pi.getProcessInstanceId();
		log.info("ProcessInstanceId" + pi.getProcessInstanceId());
		log.info("RootProcessInstanceId" + pi.getRootProcessInstanceId());
		log.info("BusinessKey" + pi.getBusinessKey());
		log.info("ProcessDefinitionId" + pi.getProcessDefinitionId());
		
		WorkflowDemandReply replyMsg = new WorkflowDemandReply(wfDemand.getDossierId(), wfDemand.getClientDemandReference() , wfDemand.getDemandId(), workflowProcessId);		
		ResponseEntity<WorkflowDemandReply> result = ResponseEntity.status(HttpStatus.ACCEPTED).body(replyMsg);
		log.info("Workflow process instance created with id : "+workflowProcessId);
		log.info(result.toString());
		return result;
		
	}


}
