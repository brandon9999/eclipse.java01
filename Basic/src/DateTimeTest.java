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
	//특정일에서 일정 기간후의 날짜 구하기는 메쏘드
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

	//어제 날짜 구하기2
	public static Date getYesterday ( Date today )
	{
		if ( today == null ) 
		throw new IllegalStateException ( "today is null" );
		Date yesterday = new Date ( );
		yesterday.setTime ( today.getTime ( ) - ( (long) 1000 * 60 * 60 * 24 ) );
	
		return yesterday;
	}

	//두 날짜의 차이를 일수로 구하기3
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
		
		// 현재 날짜, 시간 가져오기
		Date today = new Date (); 
		System.out.println ( today );
		System.out.println(new Date());     
		
		// 경과 시간(초) 알아보기
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
		
		//Date를 Calendar로 맵핑시키기
		//Date d = new Date ( );
		//Calendar c = Calendar.getInstance ( );
		//c.setTime ( d );

		//날짜(년/월/일/시/분/초) 구하기 1
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );

		//날짜(년/월/일/시/분/초) 구하기 2
		GregorianCalendar today1 = new GregorianCalendar ( );
		int year = today1.get ( today1.YEAR );
		int month = today1.get ( today1.MONTH ) + 1;
		int yoil = today1.get ( today1.DAY_OF_MONTH ); 
		GregorianCalendar gc = new GregorianCalendar ( );
		System.out.println ( gc.get ( Calendar.YEAR ) );
		System.out.println ( String.valueOf ( gc.get ( Calendar.MONTH ) + 1 ) );
		System.out.println ( gc.get ( Calendar.DATE ) );

		//날짜(년/월/일/시/분/초) 구하기3
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA);
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		String nal = df.format(cal.getTime()); 
		System.out.println ( nal );

		//표준시간대를 지정하고 날짜를 가져오기.
		TimeZone jst = TimeZone.getTimeZone ("JST");
		Calendar cal2 = Calendar.getInstance ( jst ); // 주어진 시간대에 맞게 현재 시각으로 초기화된 GregorianCalender 객체를 반환.// 또는 Calendar now = Calendar.getInstance(Locale.KOREA);
		System.out.println ( cal2.get ( Calendar.YEAR ) + "년 " + ( cal2.get ( Calendar.MONTH ) + 1 ) + "월 " + cal2.get ( Calendar.DATE ) + "일 " + cal2.get ( Calendar.HOUR_OF_DAY ) + "시 " +cal2.get ( Calendar.MINUTE ) + "분 " + cal2.get ( Calendar.SECOND ) + "초 " );

		//영어로된 날짜를 숫자로 바꾸기
		Date myDate = new Date ( "Sun,5 Dec 1999 00:07:21" ); 
		System.out.println ( myDate.getYear ( ) + "-" + myDate.getMonth ( ) + "-" + myDate.getDay ( ) ); 

		//"Sun, 5 Dec 1999 00:07:21"를 "1999-12-05"로 바꾸기
		SimpleDateFormat formatter_one = new SimpleDateFormat ( "EEE, dd MMM yyyy hh:mm:ss",Locale.ENGLISH );
		SimpleDateFormat formatter_two = new SimpleDateFormat ( "yyyy-MM-dd" );
		String inString = "Sun, 5 Dec 1999 00:07:21"; 
		ParsePosition pos = new ParsePosition ( 0 );
		Date frmTime = formatter_one.parse ( inString, pos );
		String outString = formatter_two.format ( frmTime );
		System.out.println ( outString );
		
		//숫자 12자리를, 다시 날짜로 변환하기
		Date conFromDate = new Date();
		long ttl = conFromDate.parse ( "Dec 25, 1997 10:10:10" );
		System.out.println ( ttl ); //예 938291839221
		Date today3 = new Date ( ttl );
		DateFormat format = DateFormat.getDateInstance ( DateFormat.FULL,Locale.US );
		String formatted = format.format ( today3 );
		System.out.println ( formatted );

		//특정일에서 일정 기간후의 날짜 구하기2
		System.out.println(getDate(5));
		
		//현재날짜에서 2달전의 날짜를 구하기
		Calendar cal4 = Calendar.getInstance ( ); //오늘 날짜를 기준으루..
		cal4.add ( cal4.MONTH, -2 ); //2개월 전....
		System.out.println ( cal4.get ( cal4.YEAR ) );
		System.out.println ( cal4.get ( cal4.MONTH ) + 1 );
		System.out.println ( cal4.get ( cal4.DATE ) );

		//달에 마지막 날짜 구하기
		for ( int month2 = 1; month2 <= 12; month2++ ) 
		{
			GregorianCalendar cld = new GregorianCalendar ( 2001, month2 - 1, 1 );
			System.out.println ( month2 + "/" + cld.getActualMaximum ( Calendar.DAY_OF_MONTH ) );
		}

		//해당하는 달의 마지막 일 구하기
		GregorianCalendar today5 = new GregorianCalendar ( );
		int maxday = today5.getActualMaximum ( ( today5.DAY_OF_MONTH ) );
		System.out.println ( maxday );

		//특정일을 입력받아 해당 월의 마지막 날짜를 구하는 간단한 예제.(달은 -1 해준다.)...윤달 30일 31일 알아오기.
		//예) 2012 04 11
		Calendar cal5 = Calendar.getInstance ( );
		cal5.set ( Integer.parseInt ( "2012" ), Integer.parseInt ( "04" ) - 1, Integer.parseInt ( "11" ) );
		SimpleDateFormat dFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
		System.out.println ( "입력 날짜 " + dFormat.format ( cal5.getTime ( ) ) );
		System.out.println ( "해당 월의 마지막 일자 : " + cal5.getActualMaximum ( Calendar.DATE ) );
		
		//어제 날짜 구하기2
		System.out.println ( getYesterday(new Date()) );

		//내일 날짜 구하기
		Date today6 = new Date ( );
		Date tomorrow = new Date ( today6.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
		System.out.println ( tomorrow );

		//내일 날짜 구하기2
		Calendar today7 = Calendar.getInstance ( );
		today7.add ( Calendar.DATE, 1 );
		Date tomorrow2 = today7.getTime ( );
		System.out.println ( tomorrow2 );
		
		//오늘날짜에서 5일 이후 날짜를 구하기
		Calendar cCal = Calendar.getInstance();
		cCal.add(Calendar.DATE, 5);
		System.out.println ( cCal );
		
		//날짜에 해당하는 요일 구하기
		Calendar cal8= Calendar.getInstance ( );
		int day_of_week = cal8.get ( Calendar.DAY_OF_WEEK );
		String m_week = "";
		if ( day_of_week == 1 )
			m_week="일요일";
		else if ( day_of_week == 2 )
			m_week="월요일";
		else if ( day_of_week == 3 )
			m_week="화요일";
		else if ( day_of_week == 4 )
			m_week="수요일";
		else if ( day_of_week == 5 )
			m_week="목요일";
		else if ( day_of_week == 6 )
			m_week="금요일";
		else if ( day_of_week == 7 )
			m_week="토요일";
		System.out.println(m_week);


		//두 날짜의 차이를 일수로 구하기2
		Date today8 = new Date ( );
		Calendar cal11 = Calendar.getInstance ( );
		cal11.setTime ( today8 );// 오늘로 설정. 
		Calendar cal22 = Calendar.getInstance ( );
		cal22.set ( 2011, 3, 12 ); // 기준일로 설정. month의 경우 해당월수-1을 해줍니다.
		int count = 0;
		while ( !cal22.after ( cal11 ) )
		{
			count++;
			cal22.add ( Calendar.DATE, 1 ); // 다음날로 바뀜
			System.out.println ( cal22.get ( Calendar.YEAR ) + "년 " + ( cal22.get ( Calendar.MONTH ) + 1 ) + "월 " + cal22.get ( Calendar.DATE ) + "일" );
		}
		System.out.println ( "기준일로부터 " + count + "일이 지났습니다." );
		
		//두 날짜의 차이를 일수로 구하기3
		System.out.println ( "" + GetDifferenceOfDate (2000, 6, 15, 1999, 8, 23 ) );

		//날짜형식으로 2000-01-03으로 처음에 인식을 시킨후
		//7일씩 증가해서 1년정도의 날짜를 출력해 주고 싶은데요.
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
