package be.snife.ibot.workflow.in.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkflowDemand {
	
	private String dossierId;
	private String demandId;
	
	private List<String> realEstateList;

	private List<String> demandTypeList;
	

}
