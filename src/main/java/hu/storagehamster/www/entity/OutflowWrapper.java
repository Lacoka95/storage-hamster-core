package hu.storagehamster.www.entity;

import javax.validation.Valid;
import java.util.List;

public class OutflowWrapper {
	@Valid
	private List<Outflow> outflows;

	public OutflowWrapper(List<Outflow> outflows) {
		this.outflows = outflows;
	}

	public OutflowWrapper() {
	}

	public List<Outflow> getOutflows() {
		return outflows;
	}

	public void setOutflows(List<Outflow> outflows) {
		this.outflows = outflows;
	}

	@Override
	public String toString() {
		return "OutflowWrapper{" +
						"outflows=" + outflows +
						'}';
	}
}
