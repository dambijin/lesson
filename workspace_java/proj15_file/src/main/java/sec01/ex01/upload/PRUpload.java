package sec01.ex01.upload;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.pr")
public class PRUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private static final String USER = "scott4_12";
	private static final String PASSWORD = "tiger";

//	DB접속 메소드
	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";

		try {
			// File ; 파일 또는 디렉토리(폴더)를 관리하는 class
			File currentDirPath = new File("C:\\file_repo");

			// 세팅
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);

			// 처리하는 메모리 용량
			// Threshold(임계값) : 특정한 상황에서의 경계 또는 한계
			// 1024Byte=1KB
			// 1024KB=1MB
			// 1024MB=1GB
			// 1024GB=1TB
			// 1024*1024==1,048,576byte
			// 한번에 처리 하는 용량↓
			factory.setSizeThreshold(1024 * 1024);

			ServletFileUpload upload = new ServletFileUpload(factory);

			// 파일의 최대 크기 지정 (아래는 100MB)
			upload.setFileSizeMax(1024 * 1024 * 100);

			// request를 분석하라
			List items = upload.parseRequest(request);

			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					// form 요소인지 판별
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
//					// 기존처럼 사용 가능
//					String param1 = request.getParameter("param1");
				} else {
					// file 영역
					System.out.println("param:" + fileItem.getFieldName());
					System.out.println("file name:" + fileItem.getName());
					System.out.println("file size:" + fileItem.getSize() + "Bytes");

					if (fileItem.getSize() > 0) {
						// 아이디어 1 : 파일명을 추출하는
						int idx = fileItem.getName().lastIndexOf("\\");
						System.out.println("idx : 1 : " + idx);
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						System.out.println("idx : 2 : " + idx);
						String fileName = fileItem.getName().substring(idx + 1);

						// 아이디어 2 : 파일명 중복 방지
						long timestamp = System.currentTimeMillis();
						fileName = timestamp + "_" + fileName;

						File uploadFile = new File(currentDirPath + "\\" + fileName);
//						File uploadFile = new File(currentDirPath + File.separator + fileName);
//						File uploadFile = new File(currentDirPath + System.getProperty("file.separator") + fileName);
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for

			// 위쪽 for문 안에서 DTO(VO)를 완성하고
			// DB에 저장할 수 있겠다

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8;");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println(getDBUpdate(request, response));
		response.sendRedirect("QnA_board");
	}

	private int getDBUpdate(HttpServletRequest request, HttpServletResponse response) {
		int result = -1;
		try {
			Connection conn = getConnection();
			// SQL준비
			String user_id = request.getParameter("user_id"); // 아이디
			String user_pw = request.getParameter("user_pw"); // 비밀번호
			String up_file = request.getParameter("file1"); // 파일

//			trim() : 앞뒤 공백 제거, 스페이스바 적을 수 있으니까 필요
			if (user_id == null || user_id.trim().equals("") || user_pw == null || user_pw.trim().equals("")) {
				System.out.println("아무것도 적지않음");
			} else {
				String insert = "INSERT INTO Upload_pr (N_ID, UP_ID, UP_PW, UP_IMG)";
				insert += "VALUES (upload_seq.NEXTVAL, ?, ?, ?)";

				System.out.println(insert);
				// SQL 실행준비
				PreparedStatement ps = conn.prepareStatement(insert);
				ps.setString(1, user_id);
				ps.setString(2, user_pw);
				ps.setString(3, up_file);

				result = ps.executeUpdate();
				System.out.println("바뀐 행 수:" + result);

				ps.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
