package arrange;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import run.Run;

public class MainFrame extends javax.swing.JFrame {

	public MainFrame() {
		setTitle("자리 배치");
		this.setBounds(200, 100, 900, 700);

		JPanel panel1 = new JPanel();
		JLabel front = new JLabel("  교실  앞  ");
		front.setFont(new Font("맑은고딕", Font.BOLD, 30));
		JButton refresh = new JButton("다시 시작");
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Refresh();
				dispose();
			}
		});
		panel1.add(front);
		panel1.add(refresh);

		String str = "버튼을 한 번씩만 클릭하세요. 자리에 앉을 사람이 랜덤으로 배정됩니다.\n";
		JLabel explan = new JLabel(str);
		explan.setFont(new Font("맑은고딕", Font.BOLD, 25));
		this.add(explan);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GRAY);
		JPanel leftPanel = new JPanel();
		leftPanel.setMinimumSize(new Dimension(350, 300));
		leftPanel.setLayout(new GridLayout(5, 3));

		JButton btn;
		ArrayList<JButton> list = new ArrayList<>();
		ArrayList<ClassMember> cm = new ArrayList<>();
		for (ClassMember m : ClassMember.values()) {
			cm.add(m);
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				btn = new JButton();
				btn.setPreferredSize(new Dimension(70, 70));
				leftPanel.add(btn);
				list.add(btn);
				int a = list.size();
				btn.setText(a + "");
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String name = cm.get(((int) (Math.random() * (cm.size() - 1) + 1)) - 1).getName();
							list.get(a - 1).setText(name);
							ArrayList<String> member = new ArrayList<>();
							for (int i = 0; i < cm.size(); i++) {
								if (name.equals(cm.get(i).getName())) {
									cm.remove(i);
								}
								member.add(cm.get(i).getName());
							}
							explan.setText("<html><body><center>" + str + "<br>vv남은 사람vv<br>" + member.toString()
									+ "</center></body></html>");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "남은 사람이 없습니다.");
							e1.printStackTrace();
						}
					}
				});
			}
		}
		JPanel centerPanel = new JPanel();
		centerPanel.setMaximumSize(new Dimension(300, 300));
		JLabel hall = new JLabel("복도");
		hall.setFont(new Font("맑은고딕", Font.BOLD, 30));
		centerPanel.add(hall);

		JPanel rightPanel = new JPanel();
		rightPanel.setMaximumSize(new Dimension(350, 300));
		rightPanel.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				btn = new JButton();
				btn.setPreferredSize(new Dimension(70, 70));
				rightPanel.add(btn);
				list.add(btn);
				int a = list.size();
				btn.setText(list.size() + "");
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String name = cm.get(((int) (Math.random() * (cm.size() - 1) + 1)) - 1).getName();
							list.get(a - 1).setText(name);
							ArrayList<String> member = new ArrayList<>();
							for (int i = 0; i < cm.size(); i++) {
								if (name.equals(cm.get(i).getName())) {
									cm.remove(i);
								}
								member.add(cm.get(i).getName());
							}
							explan.setText("<html><body><center>" + str + "<br>vv남은 사람vv<br>" + member.toString()
									+ "</center></body></html>");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "남은 사람이 없습니다.");
							e1.printStackTrace();
						}
					}
				});
			}
		}
		panel2.add(leftPanel, "West");
		panel2.add(centerPanel, "Center");
		panel2.add(rightPanel, "East");
		this.add(panel1, "North");
		this.add(panel2, "South");
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
