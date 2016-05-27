package br.com.caelum.lojavirtual.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener{

	private static final long serialVersionUID = 20160526L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();

		if("/login.xhtml".equals(context.getViewRoot().getViewId()))
			return;

		// TODO Auto-generated method stub
	}

	@Override
	public void beforePhase(PhaseEvent event) { }

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
