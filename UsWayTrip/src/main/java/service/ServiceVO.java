package service;

public class ServiceVO {
   
   private int service_no;
   private String service_name;
   private String service_img;
   
   public ServiceVO() {
      
   }

   public int getService_no() {
      return service_no;
   }

   public void setService_no(int service_no) {
      this.service_no = service_no;
   }

   public String getService_name() {
      return service_name;
   }

   public void setService_name(String service_name) {
      this.service_name = service_name;
   }

   public String getService_img() {
      return service_img;
   }

   public void setService_img(String service_img) {
      this.service_img = service_img;
   }
   
   
}