package com.example.demo;

import org.apache.catalina.User;

import Interface.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepsitory;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl
	(UserRepository userRepository,PasswordEncoder, passwordEncoder) {
		this.userRepsitory = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
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
