package Product;

public class ProductDto {
	
	private int pd_num; 
	private String name;
	private String makeyear;
	private int in_pri;
	private int sell_pri;
	
	public int getPd_num() {
		return pd_num;
	}
	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMakeyear() {
		return makeyear;
	}
	public void setMakeyear(String makeyear) {
		this.makeyear = makeyear;
	}
	public int getIn_pri() {
		return in_pri;
	}
	public void setIn_pri(int in_pri) {
		this.in_pri = in_pri;
	}
	public int getSell_pri() {
		return sell_pri;
	}
	public void setSell_pri(int sell_pri) {
		this.sell_pri = sell_pri;
	}

}
