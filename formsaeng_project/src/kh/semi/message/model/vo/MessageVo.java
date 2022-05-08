package kh.semi.message.model.vo;



public class MessageVo {
	private int msgNo; //메시지 번호
	private String msgTitle; //메시지 제목
	private String msgContent; //메시지 내용
	private String msgDate; //메시지 날짜
	private String recevier; //메시지 받은사람
	private String sender; //메시지 보낸사람
	
	private String recevierName; //메시지 받은사람
	private String senderName; // 메시지 보낸사람
	

	
	// 생성자
	public MessageVo() {
		super();
	}


	@Override
	public String toString() {
		return "MessageVo [msgNo=" + msgNo + ", msgTitle=" + msgTitle + ", msgContent=" + msgContent + ", msgDate="
				+ msgDate + ", recevier=" + recevier + ", sender=" + sender + ", recevierName=" + recevierName
				+ ", senderName=" + senderName + "]";
	}


	//게터 세터
	public int getMsgNo() {
		return msgNo;
	}




	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}


	public String getMsgTitle() {
		return msgTitle;
	}


	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}


	public String getMsgContent() {
		return msgContent;
	}


	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public String getMsgDate() {
		return msgDate;
	}


	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}


	public String getRecevier() {
		return recevier;
	}


	public void setRecevier(String recevier) {
		this.recevier = recevier;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}

	
	public String getRecevierName() {
		return recevierName;
	}
	
	
	public void setRecevierName(String recevierName) {
		this.recevierName = recevierName;
	}
	
	
	public String getSenderName() {
		return senderName;
	}
	
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

}
	
	