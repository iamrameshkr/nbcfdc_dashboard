package in.gov.nbcfdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




public class LoanResource {
	
	
	// get the yearly statewise amount
		public static JSONObject getYearlyAmount() {

			Statement stmt = null;
			ResultSet rs = null;

			//Execute a query

			System.out.println("Creating statement...");
			try {
				Connection conn = JDBCConnection.getConnection();
				stmt = conn.createStatement();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql;
			sql = "SELECT year,financial FROM yearly_loan_details";

			try {
				rs = stmt.executeQuery(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			JSONArray jsonArray = new JSONArray();  
			JSONObject finalJson = new JSONObject();
			ResultSetMetaData rsmd = null;

			try {
				rsmd = rs.getMetaData();
			} catch (Exception e) {
				// TODO: handle exception
			}



			//Extract data from result set
			try {
				while(rs.next()){

					int numColumns = rsmd.getColumnCount();

					JSONObject obj = new JSONObject();

					for (int i=1; i<numColumns+1; i++) {
						String column_name = rsmd.getColumnName(i);

						if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
							obj.put(column_name, rs.getString(i));
						}
						else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
							obj.put(column_name, rs.getDouble(i));}

						/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
											           obj.put(column_name, rs.getInt(i));
										           }*/
					}


					if(!obj.get("financial").equals(0.0)) {
						jsonArray.add(obj); 
					}

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finalJson.put("yearly_amount", jsonArray) ;
			System.out.println("Yearly"+finalJson);
			return finalJson;
		}
		
		
		// get the yearly statewise amount
				public static JSONObject getYearlyBen() {

					Statement stmt = null;
					ResultSet rs = null;

					//Execute a query

					System.out.println("Creating statement...");
					try {
						Connection conn = JDBCConnection.getConnection();
						stmt = conn.createStatement();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String sql;
					sql = "SELECT year,physical FROM yearly_loan_details";

					try {
						rs = stmt.executeQuery(sql);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					JSONArray jsonArray = new JSONArray();  
					JSONObject finalJson = new JSONObject();
					ResultSetMetaData rsmd = null;

					try {
						rsmd = rs.getMetaData();
					} catch (Exception e) {
						// TODO: handle exception
					}



					//Extract data from result set
					try {
						while(rs.next()){

							int numColumns = rsmd.getColumnCount();

							JSONObject obj = new JSONObject();

							for (int i=1; i<numColumns+1; i++) {
								String column_name = rsmd.getColumnName(i);

								if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
									obj.put(column_name, rs.getString(i));
								}
								else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
									obj.put(column_name, rs.getInt(i));}

								/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
													           obj.put(column_name, rs.getInt(i));
												           }*/
							}


							if(!obj.get("physical").equals(0)) {
								jsonArray.add(obj); 
							}

						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					finalJson.put("yearly_ben", jsonArray) ;
					System.out.println("Yearly Ben"+finalJson);
					return finalJson;
				}


	// get the cumulative statewise amount
	public static JSONObject getCumulativeAmount() {

		Statement stmt = null;
		ResultSet rs = null;

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,financial FROM cumulative_loan_details";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}
					else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
						obj.put(column_name, rs.getDouble(i));}

					/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
										           obj.put(column_name, rs.getInt(i));
									           }*/
				}


				if(!obj.get("financial").equals(0.0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("cumulative_amount", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;
	}



	// get the cumulative statewise ben
	public static JSONObject getCumulativeBen() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,physical FROM cumulative_loan_details";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}

					else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						obj.put(column_name, rs.getInt(i));
					}
				}


				if(!obj.get("physical").equals(0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("cumulative_ben", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;
	}




	/* financial year 2019-20*/


	// get the cumulative statewise amount
	public static JSONObject getAmount2019_20() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,financial FROM loan_details_2019_20";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}
					else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
						obj.put(column_name, rs.getDouble(i));}

					/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
										           obj.put(column_name, rs.getInt(i));
									           }*/
				}


				if(!obj.get("financial").equals(0.0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("amount", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}



	// get the statewise ben
	public static JSONObject getBen2019_20() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,physical FROM loan_details_2019_20";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}

					else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						obj.put(column_name, rs.getInt(i));
					}
				}


				if(!obj.get("physical").equals(0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("beneficiary", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}





	/* financial year 2018-19*/


	// get the cumulative statewise amount
	public static JSONObject getAmount2018_19() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,financial FROM loan_details_2018_19";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}
					else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
						obj.put(column_name, rs.getDouble(i));}

					/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
										           obj.put(column_name, rs.getInt(i));
									           }*/
				}


				if(!obj.get("financial").equals(0.0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("amount", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}



	// get the statewise ben
	public static JSONObject getBen2018_19() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,physical FROM loan_details_2018_19";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}

					else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						obj.put(column_name, rs.getInt(i));
					}
				}


				if(!obj.get("physical").equals(0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("beneficiary", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}


	/* financial year 2017-18*/


	// get the cumulative statewise amount
	public static JSONObject getAmount2017_18() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,financial FROM loan_details_2017_18";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}
					else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
						obj.put(column_name, rs.getDouble(i));}

					/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
										           obj.put(column_name, rs.getInt(i));
									           }*/
				}


				if(!obj.get("financial").equals(0.0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("amount", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}



	// get the statewise ben
	public static JSONObject getBen2017_18() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,physical FROM loan_details_2017_18";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}

					else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						obj.put(column_name, rs.getInt(i));
					}
				}


				if(!obj.get("physical").equals(0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("beneficiary", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}	




	/* financial year 2016-17*/


	// get the cumulative statewise amount
	public static JSONObject getAmount2016_17() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,financial FROM loan_details_2016_17";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}
					else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
						obj.put(column_name, rs.getDouble(i));}

					/* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
															           obj.put(column_name, rs.getInt(i));
														           }*/
				}


				if(!obj.get("financial").equals(0.0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("amount", jsonArray) ;
		System.out.println("Cumulative"+finalJson);
		return finalJson;

	}



	// get the statewise ben
	public static JSONObject getBen2016_17() {

		Statement stmt = null;
		ResultSet rs = null;
		//	  JSONObject obj = new JSONObject();

		//Execute a query

		System.out.println("Creating statement...");
		try {
			Connection conn = JDBCConnection.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql;
		sql = "SELECT state,physical FROM loan_details_2016_17";

		try {
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//  obj = writeResultSetToJson(rs);
		//  System.out.println("Obj "+obj);

		JSONArray jsonArray = new JSONArray();  
		JSONObject finalJson = new JSONObject();
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}



		//Extract data from result set
		try {
			while(rs.next()){

				int numColumns = rsmd.getColumnCount();
				//      System.out.println("ddd"+numColumns);

				JSONObject obj = new JSONObject();

				for (int i=1; i<numColumns+1; i++) {
					String column_name = rsmd.getColumnName(i);

					if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
						obj.put(column_name, rs.getString(i));
					}

					else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						obj.put(column_name, rs.getInt(i));
					}
				}


				if(!obj.get("physical").equals(0)) {
					jsonArray.add(obj); 
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finalJson.put("beneficiary", jsonArray) ;
		System.out.println("Beneficiary 2016-17"+finalJson);
		return finalJson;

	}		


}

