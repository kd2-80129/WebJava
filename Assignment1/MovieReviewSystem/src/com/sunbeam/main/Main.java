package com.sunbeam.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.daos.MoviesDao;
import com.sunbeam.daos.ReviewsDao;
import com.sunbeam.daos.ShareDao;
import com.sunbeam.daos.UsersDao;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

public class Main {
	
	
	static int menu(Scanner scn) {
		int choice;
		
		System.out.println("\n--> Menu : ");
		System.out.println("0. EXIT");
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		System.out.println("--> Enter Your Choice : ");
		choice = scn.nextInt();
		
		return choice;
	}
	
	static int men(Scanner scn) {
		int choice;

		System.out.println("\n--> Menu : ");
		System.out.println("0. Log out");
		System.out.println("1. Edit profile");
		System.out.println("2. Change password");
		System.out.println("3. Write a review");
		System.out.println("4. Edit review");
		System.out.println("5. Display Movies");
		System.out.println("6. Display all reviews");
		System.out.println("7. Display my reviews");
		System.out.println("8. Display reviews shared with me");
		System.out.println("9. Share a review");
		System.out.println("10. Delete a review");
		System.out.println("--> Enter Your Choice : ");
		choice = scn.nextInt();
		
		return choice;
	}
	
	public static java.util.Date parse(String str) {
		java.util.Date date = new java.util.Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			date = sdf.parse(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		int choice;
		Scanner scan = new Scanner(System.in);
		
		while((choice = menu(scan)) != 0) {
			switch(choice) {
			case 0:
				System.out.println("Thank You For Using the Application!!");
				break;
			case 1://Login
				System.out.println("Enter Email : ");
				String email = scan.next();
				System.out.println("Enter Password : ");
				String passwd = scan.next();
				try(UsersDao dao = new UsersDao()){
					Users us = dao.signin(email);
					if(us != null && passwd.equals(us.getPasswd())) {
						int choic;
						while((choic = men(scan)) != 0) {
							switch(choic) {
							case 0:
								System.out.println("Signing Out!!");
								break;
							case 1://Edit Information
								System.out.println("Enter User Details : ");
								System.out.println("Enter First Name : ");
								String name = scan.next();
								System.out.println("Enter Last Name : ");
								String lastName = scan.next();
								System.out.println("Enter Mobile No. : ");
								String mobile = scan.next();
								
								System.out.println("Enter Birth Date(dd-mm-yyyy) : ");
								String birth_date = scan.next();
								java.util.Date date = parse(birth_date);
								
								Users user = new Users(us.getId(),name,lastName,"","",mobile,date);
								try(UsersDao dao1 = new UsersDao()){
									dao1.editInfo(user);
									System.out.println("Information Edited!!");
								} catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 2://change a password
								System.out.println("Enter Email : ");
								email = scan.next();
								System.out.println("Enter New Password : ");
								passwd = scan.next();
								java.util.Date jdate = new java.util.Date();
								Users us1 = new Users(us.getId(),"","",email,passwd,"",jdate);
								try(UsersDao dao1 = new UsersDao()){
									dao1.changePasswd(us1);
									System.out.println("Password updated!!");
								} catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 3://write a review
								System.out.println("Enter Review : ");
								System.out.println("Enter Movie ID : ");
								int movie_id = scan.nextInt();
								System.out.println("Enter Rating : ");
								int rating = scan.nextInt();
								scan.nextLine();
								System.out.println("Enter Review : ");
								String review = scan.nextLine();
								java.util.Date sdate = new java.util.Date();
								
								Reviews rev = new Reviews(0,movie_id, review, rating, us.getId(), sdate);
								
								try(ReviewsDao dao1 = new ReviewsDao()){
									int cnt = dao1.insReview(rev);
									System.out.println("Reviews added : " + cnt);
								} catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 4:// edit a review
								System.out.println("Enter Review Id : ");
								int id = scan.nextInt();
								scan.nextLine();
								System.out.println("Enter Review : ");
								String reviewA = scan.nextLine();
								System.out.println("Enter Review : ");
								int ratingA = scan.nextInt();
								try(ReviewsDao dao1 = new ReviewsDao()){
									dao1.editReview(reviewA, us.getId(), id, ratingA);
									System.out.println("Review Updated!!");
								}catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 5://display all movies
								try(MoviesDao dao1 = new MoviesDao()){
									List<Movies> list = dao1.displayAll();
									for(Movies ele : list){
										System.out.println(ele);
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 6:// display all reviews
								try(ReviewsDao dao1 = new ReviewsDao()){
								List<Reviews> list = dao1.displayAll();
								for(Reviews ele : list){
									System.out.println(ele);
								}
							} catch(Exception e) {
								e.printStackTrace();
							}
								break;
							case 7: //display my reviews
								try(ReviewsDao dao1 = new ReviewsDao()){
									List<Reviews> list = dao1.displayMyReviews(us.getId());
									for(Reviews ele : list){
										System.out.println(ele);
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 8:// shows shared reviews with me
								List<Reviews> list2 = new ArrayList<Reviews>();
								try(ReviewsDao rdao = new ReviewsDao()){
									list2 = rdao.getSharedWithUser(us.getId());									
									for(Reviews ele : list2) {
										System.out.println(ele);
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
								break;
							case 9: // share a review
								List<Reviews> list = new ArrayList<>();
								try(ReviewsDao dao1 = new ReviewsDao()){
									list = dao1.displayMyReviews(us.getId());
									for(Reviews ele : list){
										System.out.println(ele);
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
								System.out.println("Enter the id of review to be shared : ");
								int rid = scan.nextInt();
								
								try(ReviewsDao dao1 = new ReviewsDao()){
									list2 = dao1.displayAll();
									for(Reviews ele : list){
										System.out.println(ele);
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
								System.out.println("Enter the id of User to be shared : ");
								int sid[] = new int[5];
								
								for(int i = 0; i < 5; i++) {
									int eid = scan.nextInt();
									if(eid == 0)
										break;
									else
										sid[i] = eid;
								}
								
								
								try(ShareDao dao1 = new ShareDao()){
									int cnt = 0;
									
									for(int i = 0; i < sid.length; i++) {
										
									}
									cnt = dao1.share(rid, rid);
									System.out.println(cnt + " Reviews Shared");
								} catch(Exception e) {
									e.printStackTrace();
								}
								
								break;
							case 10:// delete a reviews
								List<Reviews> list1 = new ArrayList<>();
								try(ReviewsDao dao1 = new ReviewsDao()){
									list1 = dao1.displayMyReviews(us.getId());
									for(Reviews ele : list1){
										System.out.println(ele);
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
								System.out.println("Enter the id of review to be deleted : ");
								int r_id = scan.nextInt();
				
								
								try(ReviewsDao dao1 = new ReviewsDao()){
									int cnt = dao1.deleteReview(r_id, us.getId());
									if(cnt >=1)
										System.out.println("Review deleted successfully!!");
									else
										System.out.println("Review Not Found!!");
								}
								break;
							default:
								break;
							}
						}
						System.out.println("Signing Out!!");
					} else {
						System.out.println("Invalid Email Id or Password !!");
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
				break;
			case 2://Sign up
				System.out.println("Enter User Details : ");
				System.out.println("Enter First Name : ");
				String name = scan.next();
				System.out.println("Enter Last Name : ");
				String lastName = scan.next();
				System.out.println("Enter Email : ");
				email = scan.next();
				System.out.println("Enter Password : ");
				passwd = scan.next();
				System.out.println("Enter Mobile No. : ");
				String mobile = scan.next();
				
				System.out.println("Enter Birth Date(dd-mm-yyyy) : ");
				String birth_date = scan.next();
				java.util.Date date = parse(birth_date);
				
				Users user = new Users(0,name,lastName,email,passwd,mobile,date);
				
				try(UsersDao dao = new UsersDao();){
					int cnt = dao.signUp(user);
					System.out.println("User Registered : " + cnt);
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			default://
				System.out.println("Invalid choice... Try again");
				break;
			}
		}
		System.out.println("Thank You For Using the Application!!");

	}

}
