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
	
	//�t�B�[���h�C���W�F�N�V����
	@Autowired
	private UserRepository userRepsitory;
	
	//�t�B�[���h�C���W�F�N�V����
	//�쐬�����A�m�e�[�V�������`
	@Autowired
	@Lightweight
	private PasswordEncoder passwordEncoder;
	
	//�f�t�H���g�R���X�g���N�^
	public UserServiceImpl() {}	
	
	//�Z�b�^�[�C���W�F�N�V����
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepsitory = userRepository;
//	}
//	//�Z�b�^�[�C���W�F�N�V����
//	@Autowired
//	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
//
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
