package com.halbayrak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class HesapMakinesi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	double sayi1=0;
	double sayi2=0;
	String islem="";
	boolean durum=false;
	double pi;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HesapMakinesi frame = new HesapMakinesi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HesapMakinesi() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hatice ALBAYRAK\\Desktop\\calculater.jpg"));
		setTitle("Hesap Makinesi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { //textField harf girilmemesi için
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)))
				{
					e.consume();
					
				}
			}
		});
		//textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(5, 5, 294, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton yuzdeButon = new JButton("%");
		yuzdeButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="%";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText("");
				
			}
		});
		yuzdeButon.setBounds(5, 51, 50, 36);
		contentPane.add(yuzdeButon);
		
		JButton kareKokButon = new JButton(" \u221A");
		kareKokButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="K";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText(" "+Math.sqrt(sayi1));
			}
		});
		kareKokButon.setBounds(5, 98, 50, 36);
		contentPane.add(kareKokButon);
		
		JButton kareButon = new JButton("x\u00B2");
		kareButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="KK";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText(" "+sayi1*sayi1);
			}
		});
		kareButon.setBounds(5, 145, 50, 36);
		contentPane.add(kareButon);
		
		JButton kupButon = new JButton("x\u00B3");
		kupButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="KKK";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText(" "+sayi1*sayi1*sayi1);
			}
		});
		kupButon.setBounds(5, 192, 50, 36);
		contentPane.add(kupButon);
		
		JButton xBoluButon = new JButton("1/X");
		xBoluButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="B";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText(" "+(1/sayi1));
			}
		});
		xBoluButon.setBounds(5, 239, 50, 36);
		contentPane.add(xBoluButon);
		
		JButton bosButon = new JButton("  ");
		bosButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//islem="M";
				//sayi1=Double.parseDouble(textField.getText());
				//textField.setText(" "+Math.abs(sayi1));
				JOptionPane.showMessageDialog(null, "Burada işlem basamağı mevcut değil..", "Boş Kutu", 3);
			}
		});
		bosButon.setBounds(70, 51, 50, 36);
		contentPane.add(bosButon);
		
		JButton buton7 = new JButton("7");
		buton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("");
				
				if (durum) {
		            durum = false;
		            textField.setText("7");
		        } else {
				textField.setText(textField.getText()+"7");}
			}
		});
		buton7.setBounds(70, 98, 50, 36);
		contentPane.add(buton7);
		
		JButton buton4 = new JButton("4");
		buton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("");
				if (durum) {
		            durum = false;
		            textField.setText("4");
		        } else {
				textField.setText(textField.getText()+"4");}
			}
		});
		buton4.setBounds(70, 145, 50, 36);
		contentPane.add(buton4);
		
		JButton buton1 = new JButton("1");
		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durum) {
		            durum = false;
		            textField.setText("1");
		        } else {
					textField.setText(textField.getText()+"1");}
				
			}
		});
		buton1.setBounds(70, 192, 50, 36);
		contentPane.add(buton1);
		
		JButton negPozButon = new JButton(" \u00B1");
		negPozButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("")) 
					textField.setText(String.valueOf(Double.valueOf(textField.getText()) * -1.0));
			}
		});
		negPozButon.setBounds(70, 239, 50, 36);
		contentPane.add(negPozButon);
		
		JButton tamaminiSilButon = new JButton("C");
		tamaminiSilButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				//textField.setText("0");
			}
		});
		tamaminiSilButon.setBounds(130, 51, 50, 36);
		contentPane.add(tamaminiSilButon);
		
		JButton buton8 = new JButton("8");
		buton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durum) {
		            durum = false;
		            textField.setText("8");
		        } else {
				textField.setText(textField.getText()+"8");}
			}
		});
		buton8.setBounds(130, 98, 50, 36);
		contentPane.add(buton8);
		
		JButton buton5 = new JButton("5");
		buton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durum) {
					durum = false;
					textField.setText("5");
				} else {
					textField.setText(textField.getText() + "5");
				}
			}
		});
		buton5.setBounds(130, 145, 50, 36);
		contentPane.add(buton5);
		
		JButton buton2 = new JButton("2");
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durum) {
					durum = false;
					textField.setText("2");
				} else {
					textField.setText(textField.getText() + "2");
				}
			}
		});
		buton2.setBounds(130, 192, 50, 36);
		contentPane.add(buton2);
		
		JButton buton0 = new JButton("0");
		buton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("");
				//if(!islem.equals(""))
					//textField.setText("");
				if (durum) {
					durum = false;
					textField.setText("0");
				} else {
					textField.setText(textField.getText() + "0");
				}
			}
		});
		buton0.setBounds(130, 239, 50, 36);
		contentPane.add(buton0);
		
		JButton delButon = new JButton("<x");
		delButon.setFont(new Font("Courier New", Font.PLAIN, 11));
		delButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (textField.getText().length() > 0) {
					 textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
			        }
			}
		});
		delButon.setBounds(191, 51, 50, 36);
		contentPane.add(delButon);
		
		JButton buton9 = new JButton("9");
		buton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durum) {
		            durum = false;
		            textField.setText("9");
		        } else {
				textField.setText(textField.getText()+"9");}
			}
		});
		buton9.setBounds(191, 98, 50, 36);
		contentPane.add(buton9);
		
		JButton buton6 = new JButton("6");
		buton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("");
				if (durum) {
		            durum = false;
		            textField.setText("6");
		        } else {
				textField.setText(textField.getText()+"6");}
			}
		});
		buton6.setBounds(190, 145, 50, 36);
		contentPane.add(buton6);
		
		JButton buton3 = new JButton("3");
		buton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durum) {
		            durum = false;
		            textField.setText("3");
		        } else {
				textField.setText(textField.getText()+"3");}
			}
		});
		buton3.setBounds(190, 192, 50, 36);
		contentPane.add(buton3);
		
		JButton isaretButonu = new JButton(".");
		isaretButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().contains(".")) {
					textField.setText(textField.getText() + ".");

		        }
		        if (textField.getText().equals(".")) {
		        	textField.setText("0.");
		        }
			}
		});
		isaretButonu.setBounds(190, 239, 50, 36);
		contentPane.add(isaretButonu);
		
		JButton boluButon = new JButton("/");
		boluButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="/";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		boluButon.setBounds(252, 51, 50, 36);
		contentPane.add(boluButon);
		
		JButton carpButon = new JButton("X");
		carpButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="*";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		carpButon.setBounds(251, 98, 50, 36);
		contentPane.add(carpButon);
		
		JButton cikarButon = new JButton("-");
		cikarButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="-";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		cikarButon.setBounds(250, 145, 50, 36);
		contentPane.add(cikarButon);
		
		JButton toplaButon = new JButton("+");
		toplaButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islem="+";
				sayi1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		toplaButon.setBounds(250, 192, 50, 36);
		contentPane.add(toplaButon);
		
		JButton esittirButon = new JButton("=");
		esittirButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double sonuc=0;
				sayi2=Double.parseDouble(textField.getText());
				switch(islem) {
				case "*":
					sonuc=sayi1*sayi2;
					break;
				case "/":
					if (textField.getText().equals("0")) {
						JOptionPane.showMessageDialog(null, "0'a bölemezsiniz");
					} else
						sonuc=sayi1/sayi2;
					break;
				case "-":
					sonuc=sayi1-sayi2;
					break;
				case "+":
					sonuc=sayi1+sayi2;
					break;
				case "%":
					sonuc=sayi1*sayi2/100;
					break;
				case "K":
					break;
				case "KK":
					break;
				case "KKK":
					break;
				case "B":
					break;
				
				default:
					System.out.println("İşlem seçiniz..");
					break;
				}
				textField.setText(String.valueOf(sonuc));
				islem="";
			}
		});
		esittirButon.setBounds(250, 239, 50, 36);
		contentPane.add(esittirButon);
	}

}
