import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AdminPanel extends JPanel implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7;
	ImageIcon im,i,i2;
	ImageIcon im1,im2,im3,im4,im5,im6;
	JLabel l;

	AdminPanel()
	{
		setLayout(null);
		Font f1=new Font("", Font.BOLD, 15); 
		SwingConstants sc=new SwingConstants(){}; 
		
		i2 = new ImageIcon("panel_but.png");
		b1=new JButton("MANAGE COURSES",i2);
		b1.setBounds(250,180,220,200);	
		b1.setHorizontalTextPosition(sc.CENTER);
		b1.setForeground(Color.white);
		b1.setOpaque(false);
		b1.setFont(f1);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		add(b1);
		
		
		// i2 = new ImageIcon("panel_but.png");
		b2=new JButton("COURSE RESULTS",i2);
		b2.setBounds(670,180,220,200);	
		b2.setHorizontalTextPosition(sc.CENTER);
		b2.setForeground(Color.white);
		b2.setOpaque(false);
		b2.setFont(f1);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		add(b2);
	
		// i3 = new ImageIcon("panel_but.png");
		b3=new JButton("LOG OUT",i2);
		b3.setBounds(1100,180,220,200);	
		b3.setHorizontalTextPosition(sc.CENTER);
		b3.setForeground(Color.white);
		b3.setOpaque(false);
		b3.setFont(f1);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		add(b3);
		
		// i2 = new ImageIcon("panel_but.png");
		b4=new JButton("USERS",i2);
		b4.setBounds(250,480,220,200);	
		b4.setHorizontalTextPosition(sc.CENTER);
		b4.setForeground(Color.white);
		b4.setOpaque(false);
		b4.setFont(f1);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		add(b4);
		
		// i2 = new ImageIcon("panel_but.png");
		b5=new JButton("VERIFICATION",i2);
		b5.setBounds(670,480,220,200);	
		b5.setHorizontalTextPosition(sc.CENTER);
		b5.setForeground(Color.white);
		b5.setOpaque(false);
		b5.setFont(f1);
		b5.setContentAreaFilled(false);
		b5.setBorderPainted(false);
		add(b5);
		
		
		b6=new JButton("CHANGE PASSWORD",i2);
		b6.setBounds(1100,480,220,200);	
		b6.setHorizontalTextPosition(sc.CENTER);
		b6.setForeground(Color.white);
		b6.setOpaque(false);
		b6.setFont(f1);
		b6.setContentAreaFilled(false);
		b6.setBorderPainted(false);
		add(b6);
		b6.addActionListener(this);
		
		// b7=new JButton("Back",i);
		// b7.setBounds(50,550,220,200);	
		// b7.setHorizontalTextPosition(sc.CENTER);
		// b7.setForeground(Color.white);
		// b7.setOpaque(false);
		// b7.setFont(f1);
		// b7.setContentAreaFilled(false);
		// b7.setBorderPainted(false);
		// add(b7);
		
		l=new JLabel("Admin Panel"); 
		l.setBounds(520,25,358,50);
		l.setForeground (Color.black);
		l.setFont(new Font("Copperplate Gothic Bold", Font. BOLD, 40));
		add(l);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1 = JOptionPane.showInputDialog(null,"ChangePwd","Change Password",JOptionPane.INFORMATION_MESSAGE);
		if(s1!=null)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedb?useSSL=false","root","Root");
				Statement st = con.createStatement();
				st.executeUpdate("update admin set upass='"+s1+"' where uname='masterss55@gmail.com'");
				JOptionPane.showMessageDialog(null,"Admin Password has been updated");
				// JOptionPane.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
	public void paintComponent(Graphics g1)
	{
		i=new ImageIcon("menu_bg.jpg");
	    Image d2=i.getImage();
		g1.drawImage(d2,0,0,this);
		
		im1=new ImageIcon("mng_course.png");
	    Image d=im1.getImage();
		g1.drawImage(d,150,210,100,100,this);
		
		im2=new ImageIcon("res_2.png");
	    Image d1=im2.getImage();
		g1.drawImage(d1,550,210,100,100,this);
		
		im3=new ImageIcon("lgout_btn.png");
	    Image d3=im3.getImage();
		g1.drawImage(d3,920,200,190,120,this);
		
		im4=new ImageIcon("users_icon3.png");
	    Image d4=im4.getImage();
		g1.drawImage(d4,100,510,this);
		
		im5=new ImageIcon("Verify_Icon.png");
	    Image d5=im5.getImage();
		g1.drawImage(d5,540,510,120,120,this);
		
		im6=new ImageIcon("pw_bg_2.png");
	    Image d6=im6.getImage();
		g1.drawImage(d6,950,500,150,150,this);
		
	
	}
	
}