package com.expensetracker.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.expensetracker.model.Expense;
import com.expensetracker.util.DBConnection;
public class ExpenseDAO {
	public boolean addExpense(Expense expense) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO expenses(title, category, amount, expense_date, user_id) VALUES (?, ?, ?, ?, ?)"
            );

            ps.setString(1, expense.getTitle());
            ps.setString(2, expense.getCategory());
            ps.setDouble(3, expense.getAmount());
            ps.setDate(4, expense.getExpenseDate());
            ps.setInt(5, expense.getUserId());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
	public List<Expense> getExpensesByUser(int userId) {
        List<Expense> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM expenses WHERE user_id=? ORDER BY expense_date DESC"
            );
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setCategory(rs.getString("category"));
                e.setAmount(rs.getDouble("amount"));
                e.setExpenseDate(rs.getDate("expense_date"));

                list.add(e);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
	}
	public double getTotal(int userId) {
	    double total = 0;
	    String sql = "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}

//	public double todayTotal(int userId) {
//	    return getTotal(
//	        "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND DATE(expense_date)=CURDATE()",
//	        userId
//	    );
//	}
//
//	public double last7DaysTotal(int userId) {
//	    return getTotal(
//	        "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND DATE(expense_date)>=CURDATE()-INTERVAL 7 DAY",
//	        userId
//	    );
//	}
//
//	public double yearTotal(int userId) {
//	    return getTotal(
//	        "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND YEAR(expense_date)=YEAR(CURDATE())",
//	        userId
//	    );
//	}
//
//	public double totalExpense(int userId) {
//	    return getTotal(
//	        "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=?",
//	        userId
//	    );
//	}
	
//	public double getTodayTotal(int userId) {
//	    String sql = "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND DATE(expense_date)=CURDATE()";
//	    return getTotal(userId);
//	}
//
//	public double getYesterdayTotal(int userId) {
//	    String sql = "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND DATE(expense_date)=CURDATE()-INTERVAL 1 DAY";
//	    return getTotal(userId);
//	}
//
//	public double getLast7DaysTotal(int userId) {
//	    String sql = "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND DATE(expense_date)>=CURDATE()-INTERVAL 7 DAY";
//	    return getTotal(userId);
//	}
//
//	public double getCurrentYearTotal(int userId) {
//	    String sql = "SELECT IFNULL(SUM(amount),0) FROM expenses WHERE user_id=? AND YEAR(expense_date)=YEAR(CURDATE())";
//	    return getTotal(userId);
//	}

	public double getTodayTotal(int userId) {
	    return getSum(userId, "expense_date = CURDATE()");
	}

	public double getYesterdayTotal(int userId) {
	    return getSum(userId, "expense_date = CURDATE() - INTERVAL 1 DAY");
	}

	public double getLast7DaysTotal(int userId) {
	    return getSum(userId, "expense_date >= CURDATE() - INTERVAL 6 DAY");
	}

	public double getCurrentYearTotal(int userId) {
	    return getSum(userId, "YEAR(expense_date) = YEAR(CURDATE())");
	}

	public double getTotalExpense(int userId) {
	    return getSum(userId, "1=1");
	}

	private double getSum(int userId, String condition) {
	    double total = 0;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT SUM(amount) FROM expenses WHERE user_id=? AND " + condition
	        );
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}

	
	// Common reusable method
//	private double getTotalByQuery(String sql, int userId) {
//	    double total = 0;
//	    try {
//	        Connection con = DBConnection.getConnection();
//	        PreparedStatement ps = con.prepareStatement(sql);
//	        ps.setInt(1, userId);
//	        ResultSet rs = ps.executeQuery();
//	        if (rs.next()) {
//	            total = rs.getDouble(1);
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return total;
//	}
	
	public double todayTotal(int userId) {
	    double total = 0;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT SUM(amount) FROM expenses WHERE user_id=? AND DATE(expense_date)=CURDATE()"
	        );
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}
	public double yesterdayTotal(int userId) {
	    double total = 0;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT SUM(amount) FROM expenses WHERE user_id=? AND DATE(expense_date)=CURDATE()-INTERVAL 1 DAY"
	        );
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}
	public double last7DaysTotal(int userId) {
	    double total = 0;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT SUM(amount) FROM expenses WHERE user_id=? AND expense_date >= CURDATE()-INTERVAL 7 DAY"
	        );
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}
	public double yearTotal(int userId) {
	    double total = 0;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT SUM(amount) FROM expenses WHERE user_id=? AND YEAR(expense_date)=YEAR(CURDATE())"
	        );
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}
	public double totalExpense(int userId) {
	    double total = 0;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT SUM(amount) FROM expenses WHERE user_id=?"
	        );
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}

}
