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
public class InfoSource implements Serializable {
	
	private String infoSourceId;
	private String infoSourceName;
	private String categoryId;

}
