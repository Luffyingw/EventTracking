package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table  (name = "users")	
public class User extends BaseEntity{
		
	    @Column(name = "username")
		private String Email_address;
	    
	    @Column(name = "password")
	    private String password;
	    
	   /* @Column(name = "userEmail")
	    private String userEmail;*/

	    /**
	     * 
	     * @return the name
	     */
		public String getUserName() {
			return this.Email_address;
		}

		/**
		 * 
		 * @param UserName
		 */
		public void setUserName(String userName) {
			this.Email_address = userName;
		}
		
		/**
		 * @return the UserPassword
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param Password
		 */
		public void setPassword(String password) {
			this.password = password;
		}

	/*    *//**
		 * @return the Email Address
		 *//*
		public String getEmail() {
			return userEmail;
		}

		*//**
		 * @param user Email address
		 *//*
		public void setEmail(String userEmail) {
			this.userEmail = userEmail;
		}*/
		
	}

