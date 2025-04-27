<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information Management System</title>
    <link rel="stylesheet" href="css/stylesheet.css">
    <style>

    </style>
</head>
<body>
    <h1>Student Information Management System</h1>
    <%
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String errorMessage = null;
        try {
            // Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // First connect to MySQL server to create database if not exists
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "123456");
            pstmt = con.prepareStatement("CREATE DATABASE IF NOT EXISTS StuManagement");
            pstmt.executeUpdate();
            
            // Close initial connection
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();

            // Connect to StuManagement database
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/StuManagement?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "123456");

            // Create student table if not exists
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student (" +
                    "sno VARCHAR(10) PRIMARY KEY," +
                    "sname VARCHAR(50) NOT NULL," +
                    "ssex VARCHAR(10) NOT NULL," +
                    "sage INT NOT NULL" +
                    ")";
            pstmt = con.prepareStatement(createTableSQL);
            pstmt.executeUpdate();
            pstmt.close();

            // Insert initial records (ignore if already exists)
            String checkSQL = "SELECT COUNT(*) FROM student";
            pstmt = con.prepareStatement(checkSQL);
            rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            pstmt.close();

            if (count == 0) {
                String insertSQL = "INSERT INTO student (sno, sname, ssex, sage) VALUES (?,?,?,?)";
                pstmt = con.prepareStatement(insertSQL);
                
                pstmt.setString(1, "001");
                pstmt.setString(2, "Zhang San");
                pstmt.setString(3, "Male");
                pstmt.setInt(4, 20);
                pstmt.addBatch();
                
                pstmt.setString(1, "002");
                pstmt.setString(2, "Li Si");
                pstmt.setString(3, "Female");
                pstmt.setInt(4, 21);
                pstmt.addBatch();
                
                pstmt.setString(1, "003");
                pstmt.setString(2, "Wang Wu");
                pstmt.setString(3, "Male");
                pstmt.setInt(4, 22);
                pstmt.addBatch();
                
                pstmt.executeBatch();
                pstmt.close();
            }

            // Get action type
            String action = request.getParameter("action");
            if (action != null) {
                if ("add".equals(action)) {
                    // Add operation
                    String sno = request.getParameter("sno");
                    String sname = request.getParameter("sname");
                    String ssex = request.getParameter("ssex");
                    int sage = Integer.parseInt(request.getParameter("sage"));
                    
                    String addSQL = "INSERT INTO student (sno, sname, ssex, sage) VALUES (?,?,?,?)";
                    pstmt = con.prepareStatement(addSQL);
                    pstmt.setString(1, sno);
                    pstmt.setString(2, sname);
                    pstmt.setString(3, ssex);
                    pstmt.setInt(4, sage);
                    pstmt.executeUpdate();
                    pstmt.close();
                    
                } else if ("delete".equals(action)) {
                    // Delete operation
                    String sno = request.getParameter("sno");
                    String deleteSQL = "DELETE FROM student WHERE sno = ?";
                    pstmt = con.prepareStatement(deleteSQL);
                    pstmt.setString(1, sno);
                    pstmt.executeUpdate();
                    pstmt.close();
                    
                } else if ("update".equals(action)) {
                    // Update operation
                    String sno = request.getParameter("sno");
                    String sname = request.getParameter("sname");
                    String ssex = request.getParameter("ssex");
                    int sage = Integer.parseInt(request.getParameter("sage"));
                    
                    String updateSQL = "UPDATE student SET sname = ?, ssex = ?, sage = ? WHERE sno = ?";
                    pstmt = con.prepareStatement(updateSQL);
                    pstmt.setString(1, sname);
                    pstmt.setString(2, ssex);
                    pstmt.setInt(3, sage);
                    pstmt.setString(4, sno);
                    pstmt.executeUpdate();
                    pstmt.close();
                }
            }

            // Query operation
            String selectSQL = "SELECT * FROM student ORDER BY sno";
            pstmt = con.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();
    %>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("sno") %></td>
            <td><%= rs.getString("sname") %></td>
            <td><%= rs.getString("ssex") %></td>
            <td><%= rs.getInt("sage") %></td>
            <td>
                <a href="student_management.jsp?action=delete&sno=<%= rs.getString("sno") %>" onclick="return confirm('Are you sure to delete this student?')">Delete</a>
                <a href="javascript:void(0);" onclick="editStudent('<%= rs.getString("sno") %>', '<%= rs.getString("sname") %>', '<%= rs.getString("ssex") %>', <%= rs.getInt("sage") %>)">Edit</a>
            </td>
        </tr>
        <% } %>
    </table>

    <form action="student_management.jsp" method="post">
        <input type="hidden" name="action" value="add">
        <h2>Add New Student</h2>
        <label for="sno">Student ID:</label>
        <input type="text" id="sno" name="sno" required><br>
        <label for="sname">Name:</label>
        <input type="text" id="sname" name="sname" required><br>
        <label for="ssex">Gender:</label>
        <select id="ssex" name="ssex" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br>
        <label for="sage">Age:</label>
        <input type="number" id="sage" name="sage" min="10" max="50" required><br>
        <input type="submit" value="Add Student">
    </form>

    <script>
        function editStudent(sno, sname, ssex, sage) {
            var newSname = prompt("Enter new name", sname);
            if (newSname === null) return;
            
            var newSsex = prompt("Enter new gender (Male/Female/Other)", ssex);
            if (newSsex === null) return;
            
            var newSage = prompt("Enter new age (10-50)", sage);
            if (newSage === null) return;
            
            if (newSname && newSsex && newSage) {
                window.location.href = "student_management.jsp?action=update&sno=" + sno + 
                                      "&sname=" + encodeURIComponent(newSname) + 
                                      "&ssex=" + encodeURIComponent(newSsex) + 
                                      "&sage=" + encodeURIComponent(newSage);
            }
        }
    </script>
    <%
        } catch (ClassNotFoundException e) {
            errorMessage = "Database driver error: " + e.getMessage();
        } catch (SQLException e) {
            errorMessage = "Database operation error: " + e.getMessage();
        } catch (NumberFormatException e) {
            errorMessage = "Age must be a number: " + e.getMessage();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                errorMessage = "Error closing database connection: " + e.getMessage();
            }
        }
        if (errorMessage != null) {
            out.println("<p class='error'>Error: " + errorMessage + "</p>");
        }
    %>
</body>
</html>