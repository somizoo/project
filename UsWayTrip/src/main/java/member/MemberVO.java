package member;

import java.sql.Date;

public class MemberVO {

// 22.11.24.(인진) 타입 변경
   private int member_no; // 회원번호seq
   private String member_name; // 이름
   private int member_gender; // 성별
   private Date member_birthday; // 생년월일
   private String member_email; // 이메일
   private String member_pw; // 비밀번호
   private int member_clause; // 선택약관동의
   private String member_ph; // 연락처
   private int member_role; // 권한구분
   
   public MemberVO(){
      
   }
   
   public MemberVO(String member_name, String member_email, String member_pw, String member_ph) {
      super();
      this.member_name = member_name;
      this.member_email = member_email;
      this.member_pw = member_pw;
      this.member_ph = member_ph;
   }
   
   public MemberVO(int member_no, String member_name, String member_email, String member_pw, String member_ph) {
      super();
      this.member_no = member_no;
      this.member_name = member_name;
      this.member_email = member_email;
      this.member_pw = member_pw;
      this.member_ph = member_ph;
   }

   public int getMember_no() {
      return member_no;
   }

   public void setMember_no(int member_no) {
      this.member_no = member_no;
   }

   public String getMember_name() {
      return member_name;
   }

   public void setMember_name(String member_name) {
      this.member_name = member_name;
   }

   public int getMember_gender() {
      return member_gender;
   }

   public void setMember_gender(int member_gender) {
      this.member_gender = member_gender;
   }

   public Date getMember_birthday() {
      return member_birthday;
   }

   public void setMember_birthday(Date member_birthday) {
      this.member_birthday = member_birthday;
   }

   public String getMember_email() {
      return member_email;
   }

   public void setMember_email(String member_email) {
      this.member_email = member_email;
   }

   public String getMember_pw() {
      return member_pw;
   }

   public void setMember_pw(String member_pw) {
      this.member_pw = member_pw;
   }

   public int getMember_clause() {
      return member_clause;
   }

   public void setMember_clause(int member_clause) {
      this.member_clause = member_clause;
   }

   public String getMember_ph() {
      return member_ph;
   }

   public void setMember_ph(String member_ph) {
      this.member_ph = member_ph;
   }

   public int getMember_role() {
      return member_role;
   }

   public void setMember_role(int member_role) {
      this.member_role = member_role;
   }

   
}