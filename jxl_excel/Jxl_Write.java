import java.io.File; // ���� ������ ���ؼ� �ʿ�
import java.io.FileNotFoundException; // ���� ������ ���ؼ� �ʿ�
import java.io.IOException; // ���� ������ ���ؼ� �ʿ�

// �Ʒ��� jxl �κ��� ��Ŭ�������� ����Ͻñ� ���ؼ��� �޴��ٿ��� 
//������ ������Ʈ���� ������ Ŭ�� - Build Path - Add External Archives Ŭ���� ��
// jxl API�� �ٿ�޾Ƽ� ������ Ǭ ������ jxl.jar ������ ã�Ƽ� ���Խ��Ѿ� �ؿ�. ��.... �ݵ��.... ������....
// ������ ����Ѵٸ� ���� ������ ���������� ����. ����� ���� ������ Ǯ� �ҷ�����. ^^

import jxl.Workbook; // ���� ���� ������ ���� ó���� ���� �ش��ϴ� �⺻�� �Ǵ� �߻� Ŭ����

import jxl.write.WritableWorkbook; // ���� ���� ���� ������ ���� Workbook, Sheet�� �����ϴ� Swing�� Frame�� ���� �縷�� ���ƽý� �����ϴ� �߻� Ŭ����
import jxl.write.WritableSheet; // ��Ʈ�� �����ϴ� �������̽�
import jxl.write.WritableCellFormat; // ���� ���� ���� Ŭ����
import jxl.write.WriteException; // ���� ���� ������ �����ϱ� ���� 
import jxl.write.Label; // �� ���� Ŭ����
//import jxl.write.Blank; // �� ���� Ŭ����

import jxl.format.*; // �� ����, ����, �÷� �κ� ���� Ŭ���� ����Ʈ


public class Jxl_Write
{
   public static void  main(String args[]) throws FileNotFoundException, IOException, WriteException
   {
		// ����ó���� �ƿ� ���ְ� �����ɴϴ�.
		WritableWorkbook myWorkbook = Workbook.createWorkbook(new File("c:\\temp\\jxl_Smile.xls")); // �����̸��� ���Ͽ� �����Ѵ�.

		WritableSheet mySheet = myWorkbook.createSheet("first sheet", 0); // WritableSheet�� �������̽�
		// WritableWorkbook���� �޼ҵ带 �̿��Ͽ� ����. 0��, �� ù��° ��Ʈ�� first sheet��� �̸����� �����Ѵ�.  

		WritableCellFormat numberFormat = new WritableCellFormat(); // ��ȣ �� ���� ����
		WritableCellFormat nameFormat = new WritableCellFormat(); // �̸� �� ���� ����
		WritableCellFormat dataFormat = new WritableCellFormat(); // ������ �� ���� ����

		// ��ȣ ���̺� �� ���� ����(�ڼ��� ���� ��ũ �� API�� �����ϼ�) ������� : ���� �κп��� WriteException�� �߻��ϳ׿�.
		// �׷��� ��ܿ��� �̸� ���� ó���� �ؼ� ��� ���ڳ׿�.

		numberFormat.setAlignment(Alignment.CENTRE); // �� ��� ����
		numberFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // �� ���� ��� ����
		numberFormat.setBorder(Border.ALL, BorderLineStyle.THICK); // ������ �������ν�Ÿ�� ����
		numberFormat.setBackground(Colour.ICE_BLUE); // ������ �´� ���� ? ^^
				
		// �̸� ���̺� �� ���� ����(�ڼ��� ���� ��ũ �� API�� �����ϼ�)
		nameFormat.setAlignment(Alignment.CENTRE); // �� ��� ����
		nameFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // �� ���� ��� ����
		nameFormat.setBorder(Border.BOTTOM, BorderLineStyle.HAIR); // ������ �������ν�Ÿ�� ����
		nameFormat.setBackground(Colour.GOLD); // ������ �´� ���� �ι�° ? ^^

		// ������ �� ���� ����
		dataFormat.setAlignment(Alignment.CENTRE); // �� ��� ����
		dataFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // �� ���� ��� ����

		mySheet.setColumnView(0, 8); // ��Ʈ�� ��ȣ �÷�(0��°)�� ���� ����. setCloumnView(���° �÷�, ����)
		mySheet.setColumnView(1, 15); // ��Ʈ�� �̸� �÷�(1��°)�� ���� ����
		mySheet.setColumnView(2, 20); // ��Ʈ�� ��� �÷�(2��°)�� ���� ����


		// ���� �̿��Ͽ� �ش� ���� ���� �ֱ� ����

		Label numberLabel = new Label(0, 0, "�й�", numberFormat); // �й� ��(��,��,"����",����)
		mySheet.addCell(numberLabel); // ��Ʈ�� addCell �޼ҵ带 ����Ͽ� ����

		Label nameLabel = new Label(1, 0, "����", nameFormat); // ���� ��(��,��,"����",����)
		mySheet.addCell(nameLabel); // ��Ʈ�� addCell �޼ҵ带 ����Ͽ� ����

		//Blank blank = new Blank(2,0,numberFormat); // �� ��(��,��,����) -- �ʿ� �� �ּ� ó�� Ǯ�� ����ϼ�. ^^
		//sheet.addCell(blank); 

		Label postScript = new Label(2, 0, "���", nameFormat); // ��� ��(��,��,"����",����)
		mySheet.addCell(postScript); // ��Ʈ�� addCell �޼ҵ带 ����Ͽ� ����

		for(int no=1;no<6;no++)
		{
				Label numberLabels = new Label(0, no, "["+no+"]", dataFormat); // ������ ���信 �°� 1���� 5���� ��ȣ ����
				mySheet.addCell(numberLabels); // ���� ����
				
				Label nameLabels =new Label(1, no, (char)(no+64)+"", dataFormat); // ������ ���信 �°� �빮�� A���� E���� ����
				mySheet.addCell(nameLabels); // ���� ����
		}

		// ���� �̿��Ͽ� �ش� ���� ���� �ֱ� ��
		myWorkbook.write(); // �غ�� ������ ���� ���信 �°� �ۼ� 
		myWorkbook.close(); // ó�� �� �޸𸮿��� ���� ó��
	}
}
