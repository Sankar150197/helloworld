package shopping.model;

public class product {
        private int id;
        private String productname;
        private String categery;
        private int price;
		public product() {
			
		}
		public product(int id, String productname, String categery, int price) {
			super();
			this.id = id;
			this.productname = productname;
			this.categery = categery;
			this.price = price;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getCategery() {
			return categery;
		}
		public void setCategery(String categery) {
			this.categery = categery;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public product getSingleProduct(int pId) {
			// TODO Auto-generated method stub
			return null;
		} 
		
        
}
