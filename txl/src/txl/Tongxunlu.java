package txl;

public class Tongxunlu {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	
	public static final String DBURL = "jdbc:mysql://localhost:3306/txl" ;
	
	public static final String DBUSER = "root" ;
	
	public static final String DBPASS = "root" ;
	
	private String name;
	private String tel;
	private String addr;
	
	public Tongxunlu() {}
	
	public Tongxunlu(String strName, String strTel, String strAddr)
	{
		name = strName;
		tel = strTel;
		addr = strAddr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
