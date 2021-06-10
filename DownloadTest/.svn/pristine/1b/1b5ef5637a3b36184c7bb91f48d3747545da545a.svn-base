<%@page contentType="text/html; charset=EUC-KR" %>
<%@page import="javax.servlet.*,java.io.*" %>

<%

	String src = "C:\\ÀÛ¾÷Áß\\license";

	if( request.getParameter("src") != null )
		src = request.getParameter("src");

    String separator = System.getProperty("file.separator");
    int idx =  src.lastIndexOf(separator);
	String srcDir = src.substring(0, idx);
	String srcFile = src.substring(idx+1);
	
	System.out.println("######### Source info #########");
	System.out.println("Source Dir  : " + srcDir);		
	System.out.println("Source File : " + srcFile);
	System.out.println("###############################");

	File sourcefile = new File(srcDir, srcFile);
	
	byte b[] = new byte[1024];
	
	try {

		if ( sourcefile!= null && sourcefile.isFile()) {

			response.reset();
			//response.setContentType("application/octet-stream");
			response.setContentType("euc-kr");
			response.setHeader("Content-Disposition", "attachment;filename=" + srcFile + ";");
			response.setHeader("Content-Encoding" , "identity" );
			response.setHeader("Content-Language" , "euc-kr" );
			response.setContentLength((int)sourcefile.length());
			BufferedInputStream fin = new BufferedInputStream(new FileInputStream(sourcefile));
			
			System.out.println("######### Source File info #########");
			System.out.println("File Name : " + sourcefile.getPath());
			System.out.println("File Size : " + sourcefile.length());
			System.out.println("####################################");
			
			BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
			
			int read = 0;
			try {
			
			    while ((read = fin.read(b , 0 , 1024) ) != -1){
			        outs.write(b,0,read);
			    }
			    			
			} catch (Exception e) {
			    e.printStackTrace();
			} finally {
			    if(outs!=null) outs.close();
			    if(fin!=null) fin.close();
			}
			
		} else {
			
			out.println("<h3>Download failed.</h3><br>cause : Souce does not exist or Source is not a file");
		}
		
		//out.println("IS COMMITTED : " + response.isCommitted());
		//RequestDispatcher rd = request.getRequestDispatcher("/error.html");
		//rd.forward(request, response);

	
	} catch(Exception ex) {
		ex.printStackTrace();
	}

%>
