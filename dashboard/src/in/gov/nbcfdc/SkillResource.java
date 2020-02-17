package in.gov.nbcfdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SkillResource {
	
	
	// yearly
	public static JSONObject getYearlyAmountSanctioned() {
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
	      sql = "SELECT year,amount_al FROM yearly_skill_details";
	     
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
				 
				       							     
				         if(!obj.get("amount_al").equals(0.0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("yearly_amount_sanctioned", jsonArray) ;
		     System.out.println("Yearly Amount Sanctioned"+finalJson);
			return finalJson;
		
	}
	
	
	
	// yearly trainees trained
		public static JSONObject getYearlyTraineesTrained() {
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
		      sql = "SELECT year,trainee FROM yearly_skill_details";
		     
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
						           obj.put(column_name, rs.getInt(i));}
					           
					          /* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						           obj.put(column_name, rs.getInt(i));
					           }*/
				        }
					 
					       							     
					         if(!obj.get("trainee").equals(0)) {
					        	 jsonArray.add(obj); 
					         }
					    	 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			     finalJson.put("yearly_trainee_trained", jsonArray) ;
			     System.out.println("Yearly Trainess Trained"+finalJson);
				return finalJson;
			
		}
		
		
	
	
	
	
	

	
	
	//cumulative
	public static JSONObject getCumulativeAmountSanctioned() {
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
	      sql = "SELECT state,amount_al FROM cumulative_skill_details";
	     
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
				 
				       							     
				         if(!obj.get("amount_al").equals(0.0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("cumulative_amount_sanctioned", jsonArray) ;
		     System.out.println("Cumulative Amount Sanctioned"+finalJson);
			return finalJson;
		
	}
	
	
	
	
	
	// State Wise Trainees Trained
	public static JSONObject getCumulativeTraineesTrained() {
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
	      sql = "SELECT state,trainee FROM cumulative_skill_details";
	     
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
				 
				       							     
				         if(!obj.get("trainee").equals(0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("cumulative_trainee", jsonArray) ;
		     System.out.println("Cumulative Trainees Trained"+finalJson);
			return finalJson;
		
	}
	
	
	
	
	// year 2019-2020	
	
		public static JSONObject getAmountSanctioned2019_20() {
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
		      sql = "SELECT state,amount_al FROM skill_details_2019_20";
		     
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
						           obj.put(column_name, rs.getDouble(i));
						           }
					           
					          /* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
						           obj.put(column_name, rs.getInt(i));
					           }*/
				     }
					 
					       							     
					         if(!obj.get("amount_al").equals(0.0)) {
					        	 jsonArray.add(obj); 
					         }
					    	 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			     finalJson.put("amount_sanctioned", jsonArray) ;
			     System.out.println("Cumulative Amount Sanctioned"+finalJson);
				return finalJson;
			
		}
		
		
		
		
		
		// State Wise Trainees Trained
		public static JSONObject getTraineesTrained2019_20() {
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
		      sql = "SELECT state,trainee FROM skill_details_2019_20";
		     
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
					 
					       							     
					         if(!obj.get("trainee").equals(0)) {
					        	 jsonArray.add(obj); 
					         }
					    	 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			     finalJson.put("trainees_trained", jsonArray) ;
			     System.out.println("Trainees Trained"+finalJson);
				return finalJson;
			
		}
		
	
	
	
	// year 2018-2019	
	
	public static JSONObject getAmountSanctioned2018_19() {
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
	      sql = "SELECT state,amount_al FROM skill_details_2018_19";
	     
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
					           obj.put(column_name, rs.getDouble(i));
					           }
				           
				          /* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
					           obj.put(column_name, rs.getInt(i));
				           }*/
			     }
				 
				       							     
				         if(!obj.get("amount_al").equals(0.0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("amount_sanctioned", jsonArray) ;
		     System.out.println("Cumulative Amount Sanctioned"+finalJson);
			return finalJson;
		
	}
	
	
	
	
	
	// State Wise Trainees Trained
	public static JSONObject getTraineesTrained2018_19() {
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
	      sql = "SELECT state,trainee FROM skill_details_2018_19";
	     
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
				 
				       							     
				         if(!obj.get("trainee").equals(0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("trainees_trained", jsonArray) ;
		     System.out.println("Trainees Trained"+finalJson);
			return finalJson;
		
	}
	
	
	
	// year 2017-2018	
	
	public static JSONObject getAmountSanctioned2017_18() {
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
	      sql = "SELECT state,amount_al FROM skill_details_2017_18";
	     
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
					           obj.put(column_name, rs.getDouble(i));
					           }
				           
				          /* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
					           obj.put(column_name, rs.getInt(i));
				           }*/
			     }
				 
				       							     
				         if(!obj.get("amount_al").equals(0.0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("amount_sanctioned", jsonArray) ;
		     System.out.println("Cumulative Amount Sanctioned"+finalJson);
			return finalJson;
		
	}
	
	
	
	
	
	// State Wise Trainees Trained
	public static JSONObject getTraineesTrained2017_18() {
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
	      sql = "SELECT state,trainee FROM skill_details_2017_18";
	     
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
				 
				       							     
				         if(!obj.get("trainee").equals(0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("trainees_trained", jsonArray) ;
		     System.out.println("Trainees Trained"+finalJson);
			return finalJson;
		
	}
	
	
	
	
	
	
	
	// year 2016-2017
	
	public static JSONObject getAmountSanctioned2016_17() {
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
	      sql = "SELECT state,amount_al FROM skill_details_2016_17";
	     
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
					           obj.put(column_name, rs.getDouble(i));
					           }
				           
				          /* else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
					           obj.put(column_name, rs.getInt(i));
				           }*/
			     }
				 
				       							     
				         if(!obj.get("amount_al").equals(0.0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("amount_sanctioned", jsonArray) ;
		     System.out.println("Cumulative Amount Sanctioned"+finalJson);
			return finalJson;
		
	}
	
	
	
	
	
	// State Wise Trainees Trained
	public static JSONObject getTraineesTrained2016_17() {
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
	      sql = "SELECT state,trainee FROM skill_details_2016_17";
	     
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
				 
				       							     
				         if(!obj.get("trainee").equals(0)) {
				        	 jsonArray.add(obj); 
				         }
				    	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     finalJson.put("trainees_trained", jsonArray) ;
		     System.out.println("Trainees Trained"+finalJson);
			return finalJson;
		
	}
	
	
	
	


	


}
