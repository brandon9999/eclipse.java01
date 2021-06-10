import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


public class DateTimeTest 
{
	//Ư���Ͽ��� ���� �Ⱓ���� ��¥ ���ϱ�� �޽��
	public static String getDate( int iDay ) 
	{
		Calendar temp=Calendar.getInstance ( );
		StringBuffer sbDate=new StringBuffer ( );
	
		temp.add ( Calendar.DAY_OF_MONTH, iDay );
	
		int nYear = temp.get ( Calendar.YEAR );
		int nMonth = temp.get ( Calendar.MONTH ) + 1;
		int nDay = temp.get ( Calendar.DAY_OF_MONTH );
	
		sbDate.append ( nYear );
		if ( nMonth < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nMonth );
		if ( nDay < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nDay );
	
		return sbDate.toString ( );
	}

	//���� ��¥ ���ϱ�2
	public static Date getYesterday ( Date today )
	{
		if ( today == null ) 
		throw new IllegalStateException ( "today is null" );
		Date yesterday = new Date ( );
		yesterday.setTime ( today.getTime ( ) - ( (long) 1000 * 60 * 60 * 24 ) );
	
		return yesterday;
	}

	//�� ��¥�� ���̸� �ϼ��� ���ϱ�3
	public static int GetDifferenceOfDate ( int nYear1, int nMonth1, int nDate1, int nYear2, int nMonth2, int nDate2 )
	{
		Calendar cal = Calendar.getInstance ( );
		int nTotalDate1 = 0, nTotalDate2 = 0, nDiffOfYear = 0, nDiffOfDay = 0;

		if ( nYear1 > nYear2 )
		{
			for ( int i = nYear2; i < nYear1; i++ ) 
			{
				cal.set ( i, 12, 0 );
				nDiffOfYear += cal.get ( Calendar.DAY_OF_YEAR );
			}
			nTotalDate1 += nDiffOfYear;
		}
		else if ( nYear1 < nYear2 )
		{
			for ( int i = nYear1; i < nYear2; i++ )
			{
				cal.set ( i, 12, 0 );
				nDiffOfYear += cal.get ( Calendar.DAY_OF_YEAR );
			}
			nTotalDate2 += nDiffOfYear;
		}
	
		cal.set ( nYear1, nMonth1-1, nDate1 );
		nDiffOfDay = cal.get ( Calendar.DAY_OF_YEAR );
		nTotalDate1 += nDiffOfDay;
	
		cal.set ( nYear2, nMonth2-1, nDate2 );
		nDiffOfDay = cal.get ( Calendar.DAY_OF_YEAR );
		nTotalDate2 += nDiffOfDay;
	
		return nTotalDate1-nTotalDate2;
	} 

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		// ���� ��¥, �ð� ��������
		Date today = new Date (); 
		System.out.println ( today );
		System.out.println(new Date());     
		
		// ��� �ð�(��) �˾ƺ���
		long time1 = System.currentTimeMillis (); 
        try 
        {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) 
        {
        }		
		long time2 = System.currentTimeMillis ();
		System.out.println ( ( time2 - time1 ) / 1000.0 );
		
		//Date�� Calendar�� ���ν�Ű��
		//Date d = new Date ( );
		//Calendar c = Calendar.getInstance ( );
		//c.setTime ( d );

		//��¥(��/��/��/��/��/��) ���ϱ� 1
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );

		//��¥(��/��/��/��/��/��) ���ϱ� 2
		GregorianCalendar today1 = new GregorianCalendar ( );
		int year = today1.get ( today1.YEAR );
		int month = today1.get ( today1.MONTH ) + 1;
		int yoil = today1.get ( today1.DAY_OF_MONTH ); 
		GregorianCalendar gc = new GregorianCalendar ( );
		System.out.println ( gc.get ( Calendar.YEAR ) );
		System.out.println ( String.valueOf ( gc.get ( Calendar.MONTH ) + 1 ) );
		System.out.println ( gc.get ( Calendar.DATE ) );

		//��¥(��/��/��/��/��/��) ���ϱ�3
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA);
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		String nal = df.format(cal.getTime()); 
		System.out.println ( nal );

		//ǥ�ؽð��븦 �����ϰ� ��¥�� ��������.
		TimeZone jst = TimeZone.getTimeZone ("JST");
		Calendar cal2 = Calendar.getInstance ( jst ); // �־��� �ð��뿡 �°� ���� �ð����� �ʱ�ȭ�� GregorianCalender ��ü�� ��ȯ.// �Ǵ� Calendar now = Calendar.getInstance(Locale.KOREA);
		System.out.println ( cal2.get ( Calendar.YEAR ) + "�� " + ( cal2.get ( Calendar.MONTH ) + 1 ) + "�� " + cal2.get ( Calendar.DATE ) + "�� " + cal2.get ( Calendar.HOUR_OF_DAY ) + "�� " +cal2.get ( Calendar.MINUTE ) + "�� " + cal2.get ( Calendar.SECOND ) + "�� " );

		//����ε� ��¥�� ���ڷ� �ٲٱ�
		Date myDate = new Date ( "Sun,5 Dec 1999 00:07:21" ); 
		System.out.println ( myDate.getYear ( ) + "-" + myDate.getMonth ( ) + "-" + myDate.getDay ( ) ); 

		//"Sun, 5 Dec 1999 00:07:21"�� "1999-12-05"�� �ٲٱ�
		SimpleDateFormat formatter_one = new SimpleDateFormat ( "EEE, dd MMM yyyy hh:mm:ss",Locale.ENGLISH );
		SimpleDateFormat formatter_two = new SimpleDateFormat ( "yyyy-MM-dd" );
		String inString = "Sun, 5 Dec 1999 00:07:21"; 
		ParsePosition pos = new ParsePosition ( 0 );
		Date frmTime = formatter_one.parse ( inString, pos );
		String outString = formatter_two.format ( frmTime );
		System.out.println ( outString );
		
		//���� 12�ڸ���, �ٽ� ��¥�� ��ȯ�ϱ�
		Date conFromDate = new Date();
		long ttl = conFromDate.parse ( "Dec 25, 1997 10:10:10" );
		System.out.println ( ttl ); //�� 938291839221
		Date today3 = new Date ( ttl );
		DateFormat format = DateFormat.getDateInstance ( DateFormat.FULL,Locale.US );
		String formatted = format.format ( today3 );
		System.out.println ( formatted );

		//Ư���Ͽ��� ���� �Ⱓ���� ��¥ ���ϱ�2
		System.out.println(getDate(5));
		
		//���糯¥���� 2������ ��¥�� ���ϱ�
		Calendar cal4 = Calendar.getInstance ( ); //���� ��¥�� ��������..
		cal4.add ( cal4.MONTH, -2 ); //2���� ��....
		System.out.println ( cal4.get ( cal4.YEAR ) );
		System.out.println ( cal4.get ( cal4.MONTH ) + 1 );
		System.out.println ( cal4.get ( cal4.DATE ) );

		//�޿� ������ ��¥ ���ϱ�
		for ( int month2 = 1; month2 <= 12; month2++ ) 
		{
			GregorianCalendar cld = new GregorianCalendar ( 2001, month2 - 1, 1 );
			System.out.println ( month2 + "/" + cld.getActualMaximum ( Calendar.DAY_OF_MONTH ) );
		}

		//�ش��ϴ� ���� ������ �� ���ϱ�
		GregorianCalendar today5 = new GregorianCalendar ( );
		int maxday = today5.getActualMaximum ( ( today5.DAY_OF_MONTH ) );
		System.out.println ( maxday );

		//Ư������ �Է¹޾� �ش� ���� ������ ��¥�� ���ϴ� ������ ����.(���� -1 ���ش�.)...���� 30�� 31�� �˾ƿ���.
		//��) 2012 04 11
		Calendar cal5 = Calendar.getInstance ( );
		cal5.set ( Integer.parseInt ( "2012" ), Integer.parseInt ( "04" ) - 1, Integer.parseInt ( "11" ) );
		SimpleDateFormat dFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
		System.out.println ( "�Է� ��¥ " + dFormat.format ( cal5.getTime ( ) ) );
		System.out.println ( "�ش� ���� ������ ���� : " + cal5.getActualMaximum ( Calendar.DATE ) );
		
		//���� ��¥ ���ϱ�2
		System.out.println ( getYesterday(new Date()) );

		//���� ��¥ ���ϱ�
		Date today6 = new Date ( );
		Date tomorrow = new Date ( today6.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
		System.out.println ( tomorrow );

		//���� ��¥ ���ϱ�2
		Calendar today7 = Calendar.getInstance ( );
		today7.add ( Calendar.DATE, 1 );
		Date tomorrow2 = today7.getTime ( );
		System.out.println ( tomorrow2 );
		
		//���ó�¥���� 5�� ���� ��¥�� ���ϱ�
		Calendar cCal = Calendar.getInstance();
		cCal.add(Calendar.DATE, 5);
		System.out.println ( cCal );
		
		//��¥�� �ش��ϴ� ���� ���ϱ�
		Calendar cal8= Calendar.getInstance ( );
		int day_of_week = cal8.get ( Calendar.DAY_OF_WEEK );
		String m_week = "";
		if ( day_of_week == 1 )
			m_week="�Ͽ���";
		else if ( day_of_week == 2 )
			m_week="������";
		else if ( day_of_week == 3 )
			m_week="ȭ����";
		else if ( day_of_week == 4 )
			m_week="������";
		else if ( day_of_week == 5 )
			m_week="�����";
		else if ( day_of_week == 6 )
			m_week="�ݿ���";
		else if ( day_of_week == 7 )
			m_week="�����";
		System.out.println(m_week);


		//�� ��¥�� ���̸� �ϼ��� ���ϱ�2
		Date today8 = new Date ( );
		Calendar cal11 = Calendar.getInstance ( );
		cal11.setTime ( today8 );// ���÷� ����. 
		Calendar cal22 = Calendar.getInstance ( );
		cal22.set ( 2011, 3, 12 ); // �����Ϸ� ����. month�� ��� �ش����-1�� ���ݴϴ�.
		int count = 0;
		while ( !cal22.after ( cal11 ) )
		{
			count++;
			cal22.add ( Calendar.DATE, 1 ); // �������� �ٲ�
			System.out.println ( cal22.get ( Calendar.YEAR ) + "�� " + ( cal22.get ( Calendar.MONTH ) + 1 ) + "�� " + cal22.get ( Calendar.DATE ) + "��" );
		}
		System.out.println ( "�����Ϸκ��� " + count + "���� �������ϴ�." );
		
		//�� ��¥�� ���̸� �ϼ��� ���ϱ�3
		System.out.println ( "" + GetDifferenceOfDate (2000, 6, 15, 1999, 8, 23 ) );

		//��¥�������� 2000-01-03���� ó���� �ν��� ��Ų��
		//7�Ͼ� �����ؼ� 1�������� ��¥�� ����� �ְ� ��������.
		SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-mm-dd" );
		Calendar c = Calendar.getInstance ( );
		for ( int i = 0; i < 48; i++ )
		{
			c.clear ( );
			c.set ( 2000, 1, 3 - ( i * 7 ) );
			java.util.Date d = c.getTime ( );
			String thedate = sdf.format ( d );
			System.out.println ( thedate );
		} 		
	}

}
