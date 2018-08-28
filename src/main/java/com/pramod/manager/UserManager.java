package com.pramod.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramod.DTO.CommentDTO;
import com.pramod.DTO.PostDTO;
import com.pramod.DTO.ReplyDTO;
import com.pramod.DTO.UserDTO;
import com.pramod.entity.CommentEntity;
import com.pramod.entity.PostEntity;
import com.pramod.entity.ReplyEntity;
import com.pramod.entity.UserEntity;
import com.pramod.jpaconfig.CommentJPA;
import com.pramod.jpaconfig.PostJPA;
import com.pramod.jpaconfig.ReplyJPA;
//import com.pramod.entity.CommentEntity;
//import com.pramod.jpaconfig.CommentJPA;
//import com.pramod.jpaconfig.PostJPA;
import com.pramod.jpaconfig.UserJPA;


//import com.pramod.repository.UserRepositoryService;
//import com.pramod.repository.UserRepositoryServiceImpl;

@Service
public class UserManager {

	@Autowired private UserJPA userjpa;
//	
	@Autowired private PostJPA postJPA;
//	
	@Autowired private CommentJPA commentJPA;
	
	@Autowired private ReplyJPA replyJPA;
//	@Autowired UserRepositoryServiceImpl userRepositoryServiceImpl;

	public UserDTO getOneUser(Integer id) {
		UserEntity user = userjpa.findOne(id);
		System.out.println(user.getEmail());
		return Transformer.getUserDTO(user);
		
	}
	
	public void addUser(UserEntity user) {
		userjpa.save(user);
	}
	
	public List<PostDTO> getPosts(Integer uid){
		UserEntity user = userjpa.findOne(uid);
		return Transformer.getPostDTO(user.getPosts());
	}
	
	public String setPosts(Integer uid,PostDTO post){
		UserEntity user  = userjpa.findOne(uid);
		
		PostEntity postEntity = Transformer.getPostEntity(post);
		postEntity.setUid(user);
		postJPA.save(postEntity);
		return "successfully added";
	}
	
	
	
//	public List<PostDTO> getUserPosts(Integer uid){
//		UserEntity user = userjpa.findOne(uid);
//		List<PostEntity> postList = userRepositoryServiceImpl.getPosts(user.getUid());
//		return Transformer.getUserPosts(postList);
//	}
	
	public List<UserDTO> getUsers(){
		List<UserEntity> userList = (List<UserEntity>) userjpa.findAll();
		return Transformer.getUsers(userList);
	}

	public UserEntity setUser(UserDTO u) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(u, user);
		return userjpa.save(user);
		
	}

	public CommentEntity saveComment(Integer pid, Integer uid, CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		UserEntity user = userjpa.findOne(uid);
		List<PostEntity> posts = user.getPosts();
		PostEntity post = null;
		for(PostEntity p : posts) {
			if(p.getPid()==pid)
			{
				post = p;
				break;
			}
		}
		CommentEntity commentEntity = Transformer.getCommentEntity(commentDTO);
		commentEntity.setPid(post);
		return commentJPA.save(commentEntity);
		
		
	}

	public List<CommentEntity> getPostComment(Integer pid, Integer uid) {
		// TODO Auto-generated method stub
		UserEntity user = userjpa.findOne(uid);
		PostEntity post = null;
		for(PostEntity p : user.getPosts()) {
			if(p.getPid()==pid)
			{
				post = p;
				break;
			}
		}
		return post.getComments();
	}

	public List<ReplyEntity> getPostCommentReplies(Integer pid, Integer uid, Integer cid) {
		// TODO Auto-generated method stub
//		UserEntity user = userjpa.findOne(uid);
//		PostEntity post = null;
//		for(PostEntity p : user.getPosts()) {
//			if(p.getPid()==pid)
//			{
//				post = p;
//				break;
//			}
//		}
//		List<CommentEntity> commentList = post.getComments();
//		System.out.println("CommentList : "+commentList);
//		CommentEntity comment = null;
//		for(CommentEntity c : commentList) {
//			if(c.getCid()==cid) {
//				comment = c;
//				break;
//			}
//		}
//		System.out.println("comment : "+comment);
//		return comment.getReplies();
		CommentEntity comment = commentJPA.findOne(cid);
		return comment.getReplies();
	}

	public ReplyEntity setPostCommentReplies(Integer pid, Integer uid, Integer cid, ReplyDTO replyDTO) {
		// TODO Auto-generated method stub
//		UserEntity user = userjpa.findOne(uid);
//		PostEntity post = null;
//		for(PostEntity p : user.getPosts()) {
//			if(p.getPid()==pid)
//			{
//				post = p;
//				break;
//			}
//		}
//		CommentEntity comment = null;
//		for(CommentEntity p : post.getComments()) {
//			if(p.getCid()==cid)
//			{
//				comment = p;
//				break;
//			}
//		}
		ReplyEntity reply = Transformer.getReplyEntity(replyDTO);
		CommentEntity comment = commentJPA.findOne(cid);
		reply.setCid(comment);
		replyJPA.save(reply);
		return reply;
	}

	public UserEntity saveUser(UserDTO user) {
		UserEntity users = Transformer.getUserEntity(user);
		//without using findOne
		UserEntity userEntity = userjpa.findOne(users.getUid());
		
		copyNonNullProperties(users, userEntity);
		return userjpa.save(userEntity);
		
		
		
	
//	public void savePost(List<PostEntity> post,Integer id) {
//		UserEntity u = userjpa.findOne(id);
//		u.setPosts(post);
//	}
	
	
}
	public static void copyNonNullProperties(Object src, Object target) {
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
		//	CriteriaBuilder builder = session.getCriteriaBuilder();
		//	CriteriaUpdate<UserEntity> criteria = builder.createCriteriaUpdate(UserEntity.class);
		//	Root<UserEntity> root = criteria.from(UserEntity.class);
		//	criteria.set(root.get(""), date);
		//	criteria.where(builder.equal(root.get("id"), id));
		//	session.createQuery(criteria).executeUpdate();	
	    
}
}
