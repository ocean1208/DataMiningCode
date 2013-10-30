package OuterFace;
import java.awt.event.*;


import java.awt.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
public class OuterFace implements TreeSelectionListener{
	public static int i=0;
    JScrollPane treepane=new JScrollPane();
    JScrollPane scrollpane3=new JScrollPane();
	JTree tree;
    //����DefaultTreeCellRenderer�����������и�����ͼ��
    JScrollPane scrollpane1=new JScrollPane();
    
   ImageIcon image1=new ImageIcon("D:\\images\1.jpg");
   ImageIcon image2=new ImageIcon("D:\\images\2.jpg");
   ImageIcon image3=new ImageIcon("D:\\images\3.jpg");
   String[][] data={{"��������","�ļ�2","�ļ�3","�ļ�4"},{"���ݿ�����","�ļ�6","�ļ�7","�ļ�8"},
		           {"�ļ�����","�ļ�10","��11"},{"��Ƶ����","�ļ�12","�ļ�13"},{"��������","�ļ�14","�ļ�15"}};
    
	JButton left=new JButton("����");
	JButton right=new JButton("����");
	JList list1=new JList();
	JList list2=new JList();
   
	DefaultListModel lim1=new DefaultListModel();   //�����б���ģ��  
	DefaultListModel lim2=new DefaultListModel();
    public void CreatUI(){
    	 JFrame f=new JFrame("����������ϵͳ");
    	
    	// f.add(scrollpane1,"Center");
    	 f.addWindowListener(new WindowAdapter(){
    		   public void windowClosing(WindowEvent e){
    			   System.exit(0);
    		   }
    	    });    		
    	    //��������ߵ��������Ŀ��ӻ�ͼ
    	    DefaultMutableTreeNode rootNode=creatNodes();
    	    tree=new JTree(rootNode);
    	    tree.setRootVisible(false);
    	    treepane.setViewportView(tree);

    	    MenuBar menubar=creatMenu();   
    	    f.add(treepane,"West");
    	    f.setMenuBar(menubar);    //���˵������������
    	   // JPanel display=new DisplayPane();
    	    
    	    //f.getContentPane().add(display, BorderLayout.CENTER);
    	    f.setSize(1300,750);
    	    f.setLocation(10,10);
    	    f.setVisible(true);    
    	    	    
    	
    }
    public static void main(String[] args){
     OuterFace ot=new OuterFace();
     ot.CreatUI();

   }
   
      MyListener ml=new MyListener();
	  public  DefaultMutableTreeNode creatNodes(){
		  DefaultMutableTreeNode root;
		  DefaultTreeCellRenderer tr=new DefaultTreeCellRenderer();//�����������Ⱦ����   
		  DefaultTreeModel model1;
		   root=new DefaultMutableTreeNode("root");//������ʼ��
		   JTree tree=new JTree(root);   //�����г�ʼ������������Դ��root����
		   tr.setClosedIcon(image1);   //���ý��պ�ͼ��
		   tr.setOpenIcon(image2);     //���ý���ͼ��
		   tr.setLeafIcon(image3);   //����Ҷ�ӽ��ͼ��
		   tr.setBorder(null);
		   tr.setVerifyInputWhenFocusTarget(false);
		   tr.setDisplayedMnemonic('3');
		   tr.setLabelFor(tree);
		   tr.setBorderSelectionColor(Color.red);
		   tr.setTextNonSelectionColor(Color.DARK_GRAY);
		   tr.setTextSelectionColor(Color.green);
		   tree.setCellRenderer(tr);     //����Ⱦ�����ӵ�����
		   //����ͬʱֻ����һ���ڵ㱻ѡ�У���������Ϊ��ȷ��Ψһ·�������ܼ���valueChange�¼�
		   tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		   //���Ӽ���
		
		   //treepane.add(tree);
		   model1=(DefaultTreeModel)tree.getModel();   //����������������
		                                               //����DefaultTreeModel�����������˾���������ݶ���                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		   for(int i=0;i<data.length;i++)
		   {
			   DefaultMutableTreeNode r=new DefaultMutableTreeNode(data[i][0]);
			   for(int j=0;j<data[i].length;j++)
			   {
				   r.add(new DefaultMutableTreeNode(data[i][j]));
			   }
			   root.add(r);
		   }
		   tree.addTreeSelectionListener(ml);
		   return root;
	 }	  	    
	  public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			DefaultMutableTreeNode node=(DefaultMutableTreeNode)e.getNewLeadSelectionPath().getLastPathComponent();
		    System.out.println("What happen?");
			if(node==null){
				return;
			}
			if(node.isLeaf()){
				System.out.println("maybe?");
				System.out.println(e.getPath().toString());
			}
		}  
    
   public  MenuBar creatMenu(){ 
	  // MyMonitor mm=new MyMonitor();   
		
	    MenuBar mb=new MenuBar();
	    Menu m1=new Menu("�ļ�");
	    Menu m2=new Menu("����Դ");
	    Menu m3=new Menu("���ݴ���");
	    Menu m4=new Menu("����ͳ��");
	    Menu m5=new Menu("�߼�ͳ��");
	    Menu m6=new Menu("�����ھ�");
	    Menu m7=new Menu("������ͼ");
	    Menu m8=new Menu("����");	    
	    
	    Menu mi11=new Menu("�½�");  //�����˵���һ���˵�һ��
	    MenuItem mi12=new MenuItem("��");
	    MenuItem mi13=new MenuItem("����");
	    MenuItem mi14=new MenuItem("����Ϊ");
	    MenuItem mi15=new MenuItem("��ѡ��");
	    MenuItem mi16=new MenuItem("�ر�");
	    
	    MenuItem mi111=new MenuItem("������");    //ֻ�����һ����Ҫ��MenuItem
	    MenuItem mi7=new MenuItem("�˳�");
	    
	    MenuItem m21=new MenuItem("�������ļ�");
	    MenuItem m22=new MenuItem("���ݿ�");
	    MenuItem m23=new MenuItem("txt�ļ�");
	    MenuItem m24=new MenuItem("Excel");
	    MenuItem m25=new MenuItem("DBF�ļ�");
	    MenuItem m26=new MenuItem("�û�����");
	    MenuItem m27=new MenuItem("ͨ������Դ");
	    MenuItem m28=new MenuItem("�����ֵ�");
	    
	    MenuItem m31=new MenuItem("��ά��ѯ");
	    MenuItem m32=new MenuItem("��¼ѡ��");
	    MenuItem m33=new MenuItem("��������");
	    MenuItem m34=new MenuItem("��¼����");
	    MenuItem m35=new MenuItem("ȱʧֵ���");
	    MenuItem m36=new MenuItem("���ݳ���");
	    MenuItem m37=new MenuItem("���±���");
	    Menu m3d=new Menu("��������");
	    Menu m3e=new Menu("�ļ��ϲ�");
	    MenuItem m3d1=new MenuItem("�������");
	    MenuItem m3d2=new MenuItem("ɾ������");
	    MenuItem m3d3=new MenuItem("���������޸�");
	    m3d.add(m3d1);
	    m3d.add(m3d2);
	    m3d.add(m3d3);
	    MenuItem m3e1=new MenuItem("��¼�ϲ�");
	    MenuItem m3e2=new MenuItem("�����ϲ�");
	    m3e.add(m3e1);
	    m3e.add(m3e2);
	    MenuItem m38=new MenuItem("���б任");
	    MenuItem m39=new MenuItem("���ݺϲ�");
	    MenuItem m3a=new MenuItem("�����ع�");
	    MenuItem m3b=new MenuItem("�������");
	    MenuItem m3c=new MenuItem("���������");
	    
	    Menu m41=new Menu("��ط���");
	    Menu m42=new Menu("��������");
	    Menu m43=new Menu("�ǲ�������");
	    m41.add(new MenuItem("������ط���"));
	    m41.add(new MenuItem("ƫ��ط���"));
	    m41.add(new MenuItem("������ط���"));
	    m42.add(new MenuItem("��������ֵ����"));
	    m42.add(new MenuItem("��������������"));
	    m42.add(new MenuItem("�������������"));
	    m42.add(new MenuItem("˫������ֵ����"));
	    m42.add(new MenuItem("˫��������"));
	    m42.add(new MenuItem("˫�����������"));
	    m42.add(new MenuItem("���˫������ֵ����"));
	    m43.add(new MenuItem("��������"));
	    m43.add(new MenuItem("����ֲ�����"));
	    m43.add(new MenuItem("�γ̼���"));
	    m43.add(new MenuItem("������K-S����"));
	    m43.add(new MenuItem("����������������"));
	    m43.add(new MenuItem("���������������"));
	    m43.add(new MenuItem("���������������"));
	    m43.add(new MenuItem("��������������"));
	    
	    
	    Menu m51=new Menu("�ع����");
	    m51.add(new MenuItem("���Իع�"));
	    m51.add(new MenuItem("����ع�"));
	    m51.add(new MenuItem("����ع�"));
	    m51.add(new MenuItem("���ʵ�λ�ع�"));
	    m51.add(new MenuItem("��ֵ�߼��ع�"));
	    m51.add(new MenuItem("��ֵ�߼��ع�"));
	    m51.add(new MenuItem("���߻ع�"));
	    m51.add(new MenuItem("��ع�"));
	    m51.add(new MenuItem("���ɷֻع�"));
	    
	    Menu m52=new Menu("�������");
	    m52.add(new MenuItem("�ֲ����"));
	    m52.add(new MenuItem("���پ���"));
	    
	    Menu m53=new Menu("ʱ������");
	    m53.add(new MenuItem("�ƶ�ƽ��ģ��"));
	    m53.add(new MenuItem("ARIMAģ��"));
	    m53.add(new MenuItem("���ڽ⹹ģ��"));
	    m53.add(new MenuItem("ָ��ƽ��ģ��"));
	    m53.add(new MenuItem("X11ģ��"));
	    m53.add(new MenuItem("X-12-ARIMAģ��"));
	    
	    Menu m54=new Menu("�������");
	    m54.add(new MenuItem("������"));
	    m54.add(new MenuItem("KM����"));
	    m54.add(new MenuItem("���ʷ���ģ��"));
	    Menu m55=new Menu("Э������");
	    m55.add(new MenuItem("��λ������"));
	    m55.add(new MenuItem("Э������"));
	    m55.add(new MenuItem("�������ģ��"));
	    Menu m56=new Menu("ָ�����");
	    m56.add(new MenuItem("ʱ����ط���"));
	    m56.add(new MenuItem("K-L��Ϣ��"));

	    
	    Menu m61=new Menu("������");
	    m61.add(new MenuItem("HopField������"));
	    m61.add(new MenuItem("Kohonon������"));
	    m61.add(new MenuItem("ART1������"));
	    m61.add(new MenuItem("BP������"));
	    m61.add(new MenuItem("RBF������"));
	    Menu m62=new Menu("��������");
	    m62.add(new MenuItem("��ά��������"));
	    m62.add(new MenuItem("��ά��������"));

	    mi11.add(mi111);
 
	    m1.add(mi11);
	    m1.add(mi12);
	    m1.add(mi13);
	    m1.add(mi14);
	    m1.add(mi15);
	    m1.add(mi16);
	    m1.add(mi7);
	    
	    m2.add(m21);
	    m2.add(m22);
	    m2.add(m23);
	    m2.add(m24);
	    m2.add(m25);
	    m2.add(m26);
	    m2.add(m27);
	    m2.add(m27);
	    m2.add(m28);
	    
	    m3.add(m31);
	    m3.add(m32);
	    m3.add(m33);
	    m3.add(m34);
	    m3.add(m35);
	    m3.add(m36);
	    m3.add(m37);
	    m3.add(m38);
	    m3.add(m39);
	    m3.add(m3a);
	    m3.add(m3b);
	    m3.add(m3c);
	    m3.add(m3d);
	    m3.add(m3e);
	    
	    
	    
	    m4.add(new MenuItem("��ֵ����"));
	    m4.add(new MenuItem("Ƶ�ʷ���"));
	    m4.add(new MenuItem("����ͳ��"));
	    m4.add(new MenuItem("�����"));
	    m4.add(m41);
	    m4.add(m42);
	    m4.add(m43);
	   
	    m5.add(m51);
	    m5.add(m52);
	    m5.add(m53);
	    m5.add(m54);
	    m5.add(m55);
	    m5.add(m56);
	    m5.add(new MenuItem("�б����"));
	    m5.add(new MenuItem("���ɷַ���"));
	    m5.add(new MenuItem("���ӷ���"));
	    m5.add(new MenuItem("�������"));
	    m5.add(new MenuItem("�����Իع�ģ��"));
	    m5.add(new MenuItem("Granger�������"));
	    m5.add(new MenuItem("��������"));
	    m5.add(new MenuItem("�������ģ��"));
	    
	    m6.add(m61);
	    m6.add(m62);
	    m6.add(new MenuItem("������"));
	    m6.add(new MenuItem("֧��������"));
	    m6.add(new MenuItem("ģ������"));
	    m6.add(new MenuItem("�ֲڼ�"));
	    m6.add(new MenuItem("���������"));
	    m6.add(new MenuItem("��Ҷ˹����"));

        m7.add(new MenuItem("ֱ��ͼ"));
        m7.add(new MenuItem("��״ͼ"));
        m7.add(new MenuItem("Բ��ͼ"));
        m7.add(new MenuItem("���ͼ"));
        m7.add(new MenuItem("��״ͼ"));
        m7.add(new MenuItem("ֱ��ͼ"));
        m7.add(new MenuItem("����ͼ"));
        m7.add(new MenuItem("���ͼ"));
        m7.add(new MenuItem("����ͼ"));
        m7.add(new MenuItem("ɢ��ͼ"));
        m7.add(new MenuItem("�����ͼ"));
        m7.add(new MenuItem("�����ͼ"));
        m7.add(new MenuItem("����ͼ"));
        m7.add(new MenuItem("ROC����"));
        m7.add(new MenuItem("�ߵ�ͼ"));
        m7.add(new MenuItem("P-Pͼ"));
        m7.add(new MenuItem("Q-Qͼ"));
        m7.add(new MenuItem("����ͼ"));
       
	    m8.add(new MenuItem("����"));
	    m8.add(new MenuItem("��������Ʒϵ��"));
	    m8.add(new MenuItem("����������"));
	   
	   // mi7.addActionListener(mm);
	    mb.add(m1);
	    mb.add(m2);
	    mb.add(m3);
	    mb.add(m4);
	    mb.add(m5);
	    mb.add(m6);
	    mb.add(m7);
	    mb.add(m8);
	    return mb;
   }
}