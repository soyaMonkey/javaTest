package net.codejava.javatest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userId").trim();
		String password = request.getParameter("password");

		if (userId.equals("chen") && password.equals("123")) {
			HashMap<String, List<StudentInfo>> studentInfoMap = getStudentInfo();
			request.setAttribute("userId", userId);
			request.setAttribute("studentInfoMap", studentInfoMap);
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Invalid userId or password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	private HashMap<String, List<StudentInfo>> getStudentInfo() {
		List<StudentInfo> studentInfos = new ArrayList<>();
		studentInfos.add(new StudentInfo("Dept 1", "S1", "Steve", 50));
		studentInfos.add(new StudentInfo("Dept 1", "S2", "Michelle", 25));
		studentInfos.add(new StudentInfo("Dept 1", "S3", "Jovia", 86));
		studentInfos.add(new StudentInfo("Dept 2", "S4", "Liang Yi", 44));
		studentInfos.add(new StudentInfo("Dept 2", "S5", "Xu Song", 61));
		studentInfos.add(new StudentInfo("Dept 3", "S6", "Kendrick", 32));
		studentInfos.add(new StudentInfo("Dept 3", "S7", "Kaizer", 96));
		studentInfos.add(new StudentInfo("Dept 3", "S8", "James", 39));
		studentInfos.add(new StudentInfo("Dept 4", "S9", "Donna", 27));
		studentInfos.add(new StudentInfo("Dept 4", "S10", "Lydia", 69));

		HashMap<String, List<StudentInfo>> map = new HashMap<>();

		for (StudentInfo info : studentInfos) {
			if (!map.containsKey(info.getDept())) {
				List<StudentInfo> newList = new ArrayList<>();
				newList.add(info);
				map.put(info.getDept(), newList);
			} else {
				map.get(info.getDept()).add(info);
			}
		}

		map = map.entrySet()
				.stream()
				.sorted(Map.Entry.<String, List<StudentInfo>>comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		countPassingRate(map);
		
		return map;
	}
	
	private void countPassingRate(HashMap<String, List<StudentInfo>> map) {
		for(Map.Entry<String, List<StudentInfo>> entry : map.entrySet()) {
			Double passingCount = 0.0;
			for(StudentInfo info : entry.getValue()) {
					if(info.getMark() >= 40) {
						passingCount+=1;
					}
			}
			BigDecimal passingRate = new BigDecimal(passingCount/entry.getValue().size()*100).setScale(2, RoundingMode.HALF_UP);
		
			entry.getValue().forEach(c -> c.setPassingRate(passingRate.doubleValue()));
		}
	}
}
