package dao;

import model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLoginDao extends JpaRepository<UserLogin, Integer> {

    @Query("select u from UserLogin u where u.email = :email AND u.senha = :senha")
    public UserLogin findByLogin(String email, String senha);

    @Query("select u from UserLogin u where u.email = :email")
    public UserLogin buscaEmail(String email);
}
