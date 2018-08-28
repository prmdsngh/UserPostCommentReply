package com.pramod.uri;

public final class UserURI {

	private UserURI() {
		//to avoid constructors
	}
	
	public static final String GET_USERS = "/users";
	public static final String GET_ONE_USERS = "/users/{uid}";
	public static final String GET_ONE_USERS_POST = "/users/{uid}/posts";
	public static final String GET_POST_COMMENT= "/users/{uid}/posts/{pid}/comments";
	public static final String GET_POST_COMMENT_REPLY= "/users/{uid}/posts/{pid}/comments/{cid}/replies";
	
	
	
	
}
