package common;

public class ViewPath {
	// A -> 관리자
	// U -> 사용자
	public static final String USER = "/WEB-INF/views/";
	public static final String ADMIN = "/WEB-INF/views/admin/";
	
	//티켓 
	public static final String A_TICKET = ADMIN + "ticket/";
	public static final String A_TSC = ADMIN + "ticketSubCategory/";
	/*
	 * 22.11.24 추가
	 * */
	public static final String A_TE = ADMIN + "ticketEvent/";
	//숙소
	public static final String A_LIDGING = ADMIN +"lodging/";
	public static final String U_LIDGING = USER + "lodging/";
	
	//게시판
	public static final String A_BOARD = ADMIN + "board/";
	
	//멤버
	public static final String A_MEMBER = ADMIN + "member/";
	/*
	 * 22.11.25 추가 
	 * */
	public static final String A_BOARDDATA = ADMIN + "boarddata/";
	
	/*
	 * 22.11.26 추가
	 * **/
	public static final String A_TO = ADMIN + "ticketOption/";
	/*
	 * 22.11.27 추가
	 * **/
	public static final String A_GRO = ADMIN +"guestRoomOption/";
	public static final String A_GR = ADMIN +"guestRoom/";
	
	/*22.11.29 추가*/
	public static final String A_REVIEW = ADMIN + "review/";
	
	/* 22.11.30 추가 */
	public static final String A_AGENCY = ADMIN + "agency/";
	public static final String A_TI = ADMIN +"ticketInfo/";
	
	/* 22.12.01 추가*/
	public static final String U_wishList = USER + "wishList/";
	
	/* 22.12.02 추가 */
	public static final String A_MC = ADMIN + "managerCoupon/";
	
	/* 22.12.04 추가 인진 */
	public static final String U_I = USER + "comingSoon/";
	public static final String U_MEMBER = USER + "member/";
	
	/* 22.12.06 추가 */
	public static final String U_REVIEW = USER + "review/";
	public static final String U_PAYMENT = USER + "payment/";
	

	/* 22.12.07 추가 */
	public static final String U_BOARD = USER + "board/";
	public static final String U_BD = USER + "boarddata/";
	public static final String U_TICKET = USER + "ticket/";
}
