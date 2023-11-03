import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Result_page extends JPanel {
    JLabel lb1, lb2;
    JButton b1;
    JComboBox cb1;
    ImageIcon i, i2, i3;

    Result_page() {
        setLayout(null);
        Font f2 = new Font("", Font.BOLD, 30);
        lb1 = new JLabel("Course Result");
        lb1.setBounds(610, 30, 300, 30);
        lb1.setForeground(Color.black);
        lb1.setFont(f2);
        add(lb1);

        Font f1 = new Font("", Font.ITALIC, 20);

        JTable jt;
        DefaultTableModel tableModel;
        DefaultTableCellRenderer cellRenderer;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedb?useSSL=false", "root", "Root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from crslt");
            String[] columns = {"S.No", "Username", "Name", "Total Ques.", "Attempted Qu.", "Wrong Ques.", "Total Marks", "Obtained Marks", "Percentage"};
            tableModel = new DefaultTableModel(columns, 0);
            while (rs.next()) {
                String x1 = rs.getString("S_No");
                String x2 = rs.getString("Username");
                String x3 = rs.getString("Name");
                String x4 = rs.getString("Total_Ques");
                String x5 = rs.getString("Attempted_Ques_");
                String x7 = rs.getString("Wrong_Ques_");
                String x8 = rs.getString("Total_Marks");
                String x9 = rs.getString("Obtained_Marks");
                String x10 = rs.getString("Percentage");
                String[] data = {x1, x2, x3, x4, x5, x7, x8, x9, x10};
                tableModel.addRow(data);
            }
            jt = new JTable(tableModel);
            jt.setBackground(Color.cyan);
            jt.setPreferredScrollableViewportSize(jt.getPreferredSize());
            jt.getColumnModel().getColumn(0).setPreferredWidth(650);
            jt.getColumnModel().getColumn(1).setPreferredWidth(1050);
            jt.getColumnModel().getColumn(2).setPreferredWidth(850);
            jt.getColumnModel().getColumn(3).setPreferredWidth(850);
            jt.getColumnModel().getColumn(4).setPreferredWidth(850);
            jt.getColumnModel().getColumn(5).setPreferredWidth(1050);
            jt.getColumnModel().getColumn(6).setPreferredWidth(800);
            jt.getColumnModel().getColumn(7).setPreferredWidth(850);
            jt.getColumnModel().getColumn(8).setPreferredWidth(950);

            cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);

            JScrollPane sp = new JScrollPane(jt);
            sp.setBounds(50, 150, 1300, 200);
            add(sp);

            con.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }

        SwingConstants sc = new SwingConstants() {};
        i = new ImageIcon("panel_but.png");
        b1 = new JButton("Back", i);
        b1.setBounds(30,485,220,200);
        b1.setHorizontalTextPosition(sc.CENTER);
        b1.setForeground(Color.white);
        b1.setOpaque(false);
        b1.setFont(f1);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
		add(b1);
		
	}
	public void paintComponent(Graphics g1)
	{
		i2=new ImageIcon("menu_bg.jpg");
	    Image d1=i2.getImage();
		g1.drawImage(d1,0,0,this);
		
	}
}