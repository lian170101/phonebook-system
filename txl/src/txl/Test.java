package txl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";

	public static final String DBURL = "jdbc:mysql://localhost:3306/txl";

	public static final String DBUSER = "root";

	public static final String DBPASS = "root";

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根

		System.out.println("请选择身份：1.账户登录；2.游客登录");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch (i) {
		case 1: {
			boolean j = true;
			while (j) {
				System.out.println("1.已有账号；2.注册账户");
				Scanner sc1 = new Scanner(System.in);
				int i1 = sc1.nextInt();
				switch (i1) {
				case 1: {

					Manage mana2 = new Manage();
					mana2.login();
					
					System.out.println("1.修改密码      2.系统管理      0.退出");
					Scanner sc3 = new Scanner(System.in);
					int i2 = sc3.nextInt();
					switch (i2) {
					case 1: {
						Admin adm = new Admin();
						adm.change();
						break;
					}

					case 2: {
						boolean j1 = true;
						while (j1) {
							System.out.println("\n1.按姓名查找     2.按号码查找     3.查找所有记录");
							System.out.println("4.按姓名删除     5.按号码删除      6.新增记录");
							System.out.println("7.修改手机号     0.退出");
							Scanner sc5 = new Scanner(System.in);
							int i3 = sc5.nextInt();
							
							Manage mana = new Manage();
							
							switch (i3) {
							case 1: {
								mana.searchByName();
								break;
							}

							case 2: {
								mana.searchByTel();
								break;
							}

							case 3: {
								mana.show();
								break;
							}
								

							case 4: {
								mana.deleteByName();
								break;
							}

							case 5: {
								mana.deleteByTel();
								break;
							}
							
							case 6: {
								mana.add();
								break;
							}
							
							case 7: {
								mana.changeByTel();
								break;
							}
							
							case 0:
								System.exit(0);
						}
						}
						break;
					}

					case 0:
						System.exit(0);
					}

					break;
				}

				case 2: {
					Admin ad = new Admin();
					ad.register();
					break;
				}
				}
			}
			break;
		}

		case 2: {
			System.out.println("通讯录所有信息");
			
			Manage mana1 = new Manage();
			mana1.show();

			boolean j2 = true;
			while (j2) {
				System.out.println("\n1.按姓名查找     2.按号码查找     3.按姓名删除");
				System.out.println("4.按号码删除     5.新增记录          6.查找所有记录");
				System.out.println("7.修改手机号     0.退出");
				Scanner sc2 = new Scanner(System.in);
				int i3 = sc2.nextInt();
				switch (i3) {
				
				case 1: {
					mana1.searchByName();
					break;
				}

				case 2: {
					mana1.searchByTel();
					break;
				}

				case 3: {
					mana1.deleteByName();
					break;
				}

				case 4: {
					mana1.deleteByTel();
					break;
				}

				case 5: {
					mana1.add();
					break;
				}
				
				case 6: {
					mana1.show();
					break;
				}
				
				case 7: {
					mana1.changeByTel();
					break;
				}
				
				case 0:
					System.exit(0);
				}
			}

			break;
		}
		}
	}

}
