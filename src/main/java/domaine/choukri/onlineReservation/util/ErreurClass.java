package domaine.choukri.onlineReservation.util;

public class ErreurClass {
	
	private String erreurMsg;
	
	public ErreurClass(String erreurmsg)
	{
		setErreurMsg(erreurmsg);
	}

	public String getErreurMsg() {
		return erreurMsg;
	}

	public void setErreurMsg(String erreurMsg) {
		this.erreurMsg = erreurMsg;
	}
	

}
