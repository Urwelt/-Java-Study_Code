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
	
//	�C���X�^���X���������߁A�ˑ��x��������
//	public UserServiceImpl(javax.sql.DataSource dataSource) {
//		//�f�[�^�x�[�X��̃��[�U�[���𑀍삷������N���X
//		this.userRepsitory = new JdbcUserRepository(dataSource);
//		//BCrypt�A���S���Y���Ńn�b�V�������鏈��
//		this.passwordEncoder = new BCryptPasswordEncoder();
//	}
	
	public void register(User user, String rawPassword) {
		if(this.userRepsitory.countByUsername(user.getUsername()) > 0) {
			//���[�U�[�������łɎg�p����Ă������O�𓊂���
			throw new UserAlreadyRegisteredException();
		}
		//���p�X���[�h���n�b�V�������Đݒ�
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepsitory.save(user);
	}

}
