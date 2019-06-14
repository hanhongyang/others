package webadv.s16202234.p2;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Enumeration;  
import java.util.Properties;  
import java.util.Scanner;  
  import webadv.s16202234.p2.jiami;
public class App {
	/*
	 作者：16202234韩弘扬
	 请以管理员身份运行STS。
	 将账户密码存储在属性文件中，密码经过SHA-256保护。
	 账户密码：zhongbei->123
	 yangkai->234
	 sunxu->345
	 ghz->456
	 zhouwei->567 
	 */
	
	private Boolean verification() throws IOException {  
    	String z="123";
    			String y="234";
    			String su="345";
    			String g="456";
    			String zh="567";
    			
    			        String mima1=jiami.sign(z,"SHA-256");//密码转码
    			        String mima2=jiami.sign(y,"SHA-256");//密码转码
    			        String mima3=jiami.sign(su,"SHA-256");//密码转码
    			        String mima4=jiami.sign(g,"SHA-256");//密码转码
    			        String mima5=jiami.sign(zh,"SHA-256");//密码转码
    			    
        Properties pro = new Properties();  
        pro.setProperty("zhongbei",mima1);//往属性文件中加入键和值  
        pro.setProperty("yangkai", mima2);  
        pro.setProperty("sunxu", mima3);  
        pro.setProperty("ghz", mima4);  
        pro.setProperty("zhouwei", mima5);  
        File f = new File("c:/pro.properties");  
        FileOutputStream fos = new FileOutputStream(f);  
        pro.store(fos, "This is myproperties");//保存属性文件  
        fos.close();  
        Scanner scan = new Scanner(System.in);  
        System.out.println("请输入需要验证的用户名...");  
        if (scan.hasNext()) {  
            String str = scan.next();  
            FileInputStream fin = new FileInputStream(f);  
            pro.load(fin);//加载属性文件  
            Enumeration<String> e = (Enumeration<String>)pro.propertyNames();  
            //获取属性文件中所有的key  
            while (e.hasMoreElements()) {//遍历每一个key  
                String key = e.nextElement();//得到每一个key  
                if (key.equals(str)) {  
                    System.out.println("用户名存在，请输入密码");  
                    if (scan.hasNext()) {  
                        String s = scan.next(); 
                        String ss=jiami.sign(s,"SHA-256");//密码转码
                        if (pro.getProperty(key).equals(ss)) {  
                            System.out.println("登录成功！");  
                            return true;  
                        }else   
                            return false;  
                    }  
                }   
            }  
            fin.close();  
        }  
        return false;  
    }
    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.err.println("Please provide an input!");
//            System.exit(0);
       // }
        //System.out.println(sha256hex(args[0]));
    	
    	
    	
    	 try {  
             App pt = new App();  
             if(!pt.verification()){  
                 System.out.println("用户名或密码错误!");  
             }  
         } catch (IOException e) {  
             e.printStackTrace();  
         }  
    }
//    public static String sha256hex(String input) {
//        return DigestUtils.sha256Hex(input);
//    }
}
