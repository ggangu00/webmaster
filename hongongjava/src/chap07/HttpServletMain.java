package chap07;

public class HttpServletMain {

	public static void main(String[] args) {
		method(new LoginServlet()); //로그인합니다.
		method(new FileDownloadServlet()); //파일 다운로드합니다.
	}
	
	public static void method(httpServlet servlet) {
		servlet.service();
	}

}