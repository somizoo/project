package refund;

public class RefundVO {
	private int refund_no;		//환불seq
	private int payment_no;		//결제seq
	private int cr_no;			//취소사유seq
	private int member_no;		//회원seq
	private String refund_canceldetail; //취소사유 상세
	private String refund_bank;		//은행명
	private String refund_depositor;	//예금주
	private String refund_account;	//계좌번호
	private int refund_deductmoney;	//차감 금액
	private String refund_reason;	//차감 사유
	private int refund_money;	//환불 금액
	private int refund_state;	//진행 상태
	
	public RefundVO() {
		
	}
	
	public int getRefund_no() {
		return refund_no;
	}
	public void setRefund_no(int refund_no) {
		this.refund_no = refund_no;
	}
	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public int getCr_no() {
		return cr_no;
	}
	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getRefund_canceldetail() {
		return refund_canceldetail;
	}
	public void setRefund_canceldetail(String refund_canceldetail) {
		this.refund_canceldetail = refund_canceldetail;
	}
	public String getRefund_bank() {
		return refund_bank;
	}
	public void setRefund_bank(String refund_bank) {
		this.refund_bank = refund_bank;
	}
	public String getRefund_depositor() {
		return refund_depositor;
	}
	public void setRefund_depositor(String refund_depositor) {
		this.refund_depositor = refund_depositor;
	}
	public String getRefund_account() {
		return refund_account;
	}
	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}
	public int getRefund_deductmoney() {
		return refund_deductmoney;
	}
	public void setRefund_deductmoney(int refund_deductmoney) {
		this.refund_deductmoney = refund_deductmoney;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	public int getRefund_money() {
		return refund_money;
	}
	public void setRefund_money(int refund_money) {
		this.refund_money = refund_money;
	}
	public int getRefund_state() {
		return refund_state;
	}
	public void setRefund_state(int refund_state) {
		this.refund_state = refund_state;
	}
	
}
