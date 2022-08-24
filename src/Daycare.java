public class Daycare 
{
   private String name;
   private String zipCode;
   private String county;
   public Daycare(String n, String z, String c) {
      name = n.trim();
      zipCode = z.trim();
      county = c;
   }
   
   public String getName() 
   {
      return name;
   }
   
   public String getZipCode() 
   {
      return zipCode;
   }
   
   public String getCounty() 
   {
      return county;
   }
}