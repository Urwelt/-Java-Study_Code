package Interface;

import com.example.demo.User;

public interface UserRepository {
	//ユーザー情報を永続化層に保存する
	User save(User user);
	//ユーザー情報をカウントする
	int countByUsername(String username);
}
