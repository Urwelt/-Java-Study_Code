package Interface;

import com.example.demo.User;

public interface UserService {
	//ユーザー情報を登録する処理
	void register(User user, String rawPassword);
}