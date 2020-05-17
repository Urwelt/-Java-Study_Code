package com.example.demo;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Interface.Lightweight;
import Interface.PasswordEncoder;
import Interface.UserRepository;
import Interface.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	//フィールドインジェクション
	@Autowired
	private UserRepository userRepsitory;
	
	//フィールドインジェクション
	//作成したアノテーションを定義
	@Autowired
	@Lightweight
	private PasswordEncoder passwordEncoder;
	
	//デフォルトコンストラクタ
	public UserServiceImpl() {}	
	
	//セッターインジェクション
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepsitory = userRepository;
//	}
//	//セッターインジェクション
//	@Autowired
//	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
//
//	インスタンス生成を辞め、依存度を下げる
//	public UserServiceImpl(javax.sql.DataSource dataSource) {
//		//データベース上のユーザー情報を操作する実装クラス
//		this.userRepsitory = new JdbcUserRepository(dataSource);
//		//BCryptアルゴリズムでハッシュ化する処理
//		this.passwordEncoder = new BCryptPasswordEncoder();
//	}
	
	public void register(User user, String rawPassword) {
		if(this.userRepsitory.countByUsername(user.getUsername()) > 0) {
			//ユーザー名がすでに使用されていたら例外を投げる
			throw new UserAlreadyRegisteredException();
		}
		//生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepsitory.save(user);
	}

}
