package Interface;

import com.example.demo.User;

public interface UserRepository {
	//���[�U�[�����i�����w�ɕۑ�����
	User save(User user);
	//���[�U�[�����J�E���g����
	int countByUsername(String username);
}
