package payment;

import java.sql.Date;

public class PaymentVO {
	private int payment_no;		//결제seq
	private String payment_id;	//결제번호
	private int product_no;		//상품번호seq
	private int member_no;		//회원보호seq
	private int gr_no;			//객실번호seq
	private int uc_no;			//쿠폰 사용여부 구분 seq
	private Date payment_reservedate;	//예약날짜
	private Date payment_date;			//결제날짜
	private int payment_people;			//인원
	private int payment_price;			//최종금액
	private int payment_state;			//상태
	private Date payment_start;			//시작일
	private Date payment_end;			//종료일
	private String payment_kind;		//결제 수단
	private String payment_bank;		//결제 은행
	private String payment_card;		//카드번호
	private String payment_approval;	//승인번호
	private int payment_taxable;		//현금영수증 / 세금계산서 가능 여부
	private String payment_taxserial;	//현금영수증 / 세금계산서 번호
	private int gro_no;					//객실옵션번호
	private String product_sort;		//상품 구분
	
	public PaymentVO() {}
	
	public PaymentVO(int payment_no, String payment_id, int product_no, int member_no, int gr_no, int uc_no,
			Date payment_reservedate, Date payment_date, int payment_people, int payment_price, int payment_state,
			Date payment_start, Date payment_end, String payment_kind, String payment_bank, String payment_card,
			String payment_approval, int payment_taxable, String payment_taxserial, int gro_no, String product_sort) {
		this.payment_no = payment_no;
		this.payment_id = payment_id;
		this.product_no = product_no;
		this.member_no = member_no;
		this.gr_no = gr_no;
		this.uc_no = uc_no;
		this.payment_reservedate = payment_reservedate;
		this.payment_date = payment_date;
		this.payment_people = payment_people;
		this.payment_price = payment_price;
		this.payment_state = payment_state;
		this.payment_start = payment_start;
		this.payment_end = payment_end;
		this.payment_kind = payment_kind;
		this.payment_bank = payment_bank;
		this.payment_card = payment_card;
		this.payment_approval = payment_approval;
		this.payment_taxable = payment_taxable;
		this.payment_taxserial = payment_taxserial;
		this.gro_no = gro_no;
		this.product_sort = product_sort;
	}
	

	public int getGro_no() {
		return gro_no;
	}

	public void setGro_no(int gro_no) {
		this.gro_no = gro_no;
	}

	public String getProduct_sort() {
		return product_sort;
	}

	public void setProduct_sort(String product_sort) {
		this.product_sort = product_sort;
	}

	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getGr_no() {
		return gr_no;
	}
	public void setGr_no(int gr_no) {
		this.gr_no = gr_no;
	}
	public int getUc_no() {
		return uc_no;
	}
	public void setUc_no(int uc_no) {
		this.uc_no = uc_no;
	}
	public Date getPayment_reservedate() {
		return payment_reservedate;
	}
	public void setPayment_reservedate(Date payment_reservedate) {
		this.payment_reservedate = payment_reservedate;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public int getPayment_people() {
		return payment_people;
	}
	public void setPayment_people(int payment_people) {
		this.payment_people = payment_people;
	}
	public int getPayment_price() {
		return payment_price;
	}
	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}
	public int getPayment_state() {
		return payment_state;
	}
	public void setPayment_state(int payment_state) {
		this.payment_state = payment_state;
	}
	public Date getPayment_start() {
		return payment_start;
	}
	public void setPayment_start(Date payment_start) {
		this.payment_start = payment_start;
	}
	public Date getPayment_end() {
		return payment_end;
	}
	public void setPayment_end(Date payment_end) {
		this.payment_end = payment_end;
	}
	public String getPayment_kind() {
		return payment_kind;
	}
	public void setPayment_kind(String payment_kind) {
		this.payment_kind = payment_kind;
	}
	public String getPayment_bank() {
		return payment_bank;
	}
	public void setPayment_bank(String payment_bank) {
		this.payment_bank = payment_bank;
	}
	public String getPayment_card() {
		return payment_card;
	}
	public void setPayment_card(String payment_card) {
		this.payment_card = payment_card;
	}
	public String getPayment_approval() {
		return payment_approval;
	}
	public void setPayment_approval(String payment_approval) {
		this.payment_approval = payment_approval;
	}
	public int getPayment_taxable() {
		return payment_taxable;
	}
	public void setPayment_taxable(int payment_taxable) {
		this.payment_taxable = payment_taxable;
	}
	public String getPayment_taxserial() {
		return payment_taxserial;
	}
	public void setPayment_taxserial(String payment_taxserial) {
		this.payment_taxserial = payment_taxserial;
	}
	

	@Override
	public String toString() {
		return "PaymentVO [payment_no=" + payment_no + ", payment_id=" + payment_id + ", product_no=" + product_no
				+ ", member_no=" + member_no + ", gr_no=" + gr_no + ", uc_no=" + uc_no + ", payment_reservedate="
				+ payment_reservedate + ", payment_date=" + payment_date + ", payment_people=" + payment_people
				+ ", payment_price=" + payment_price + ", payment_state=" + payment_state + ", payment_start="
				+ payment_start + ", payment_end=" + payment_end + ", payment_kind=" + payment_kind + ", payment_bank="
				+ payment_bank + ", payment_card=" + payment_card + ", payment_approval=" + payment_approval
				+ ", payment_taxable=" + payment_taxable + ", payment_taxserial=" + payment_taxserial + ", gro_no="
				+ gro_no + ", product_sort=" + product_sort + "]";
	}
}
