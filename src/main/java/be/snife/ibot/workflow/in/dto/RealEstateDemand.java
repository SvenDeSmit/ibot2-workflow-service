package be.snife.ibot.workflow.in.dto;

import java.io.Serializable;
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
public class RealEstateDemand implements Serializable {
	
	private RealEstate realEstate;

	private List<InfoSource> infoSourceList;

}
